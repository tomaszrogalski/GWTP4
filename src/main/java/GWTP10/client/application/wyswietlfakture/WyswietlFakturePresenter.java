package GWTP10.client.application.wyswietlfakture;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import GWTP10.client.application.WyslijFaktureDoWyswietleniaEvent;
import GWTP10.client.application.WyslijFaktureDoWyswietleniaEvent.WyslijFaktureDoWyswietleniaHandler;
import GWTP10.client.application.WyslijListePozycjiDoWyswietleniaEvent;
import GWTP10.client.application.pokazpozycje.PokazPozycjePresenter;
import GWTP10.client.place.NameTokens;
import GWTP10.serwer.Faktura;
import GWTP10.serwer.Pozycja;

public class WyswietlFakturePresenter
		extends Presenter<WyswietlFakturePresenter.MyView, WyswietlFakturePresenter.MyProxy>
		implements WyswietlFaktureUiHandlers, WyslijFaktureDoWyswietleniaHandler {
	interface MyView extends View, HasUiHandlers<WyswietlFaktureUiHandlers> {
		public TextBox getTextBoxNrFaktury();

		public TextBox getTextBoxImie();

		public TextBox getTextboxNazwisko();

		public void setButtonPokazPozycje(Button buttonPokazPozycje);
	}

	private List<Faktura> listaFaktur = new ArrayList<>();
	private Integer indexListyFaktury;
	private int rozmiarListyZFakturami;

	PokazPozycjePresenter pokazPozycjePresenter;

	@NameToken(NameTokens.wyswietlFakture)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<WyswietlFakturePresenter> {
	}

	@Inject
	PlaceManager placeManager;
	@Inject
	private static EventBus eventBus;

	@Inject
	WyswietlFakturePresenter(EventBus eventBus, MyView view, MyProxy proxy,
			PokazPozycjePresenter pokazPozycjePresenter) {
		super(eventBus, view, proxy, RevealType.Root);
		this.pokazPozycjePresenter = pokazPozycjePresenter;

		getView().setUiHandlers(this);
	}

	@Override
	public void onWyslijFaktureDoWyswietlenia(WyslijFaktureDoWyswietleniaEvent event) {
		listaFaktur.add(event.getFaktura());
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		addRegisteredHandler(WyslijFaktureDoWyswietleniaEvent.getType(), this);
	}

	@Override
	public void buttonAkcjaWyswietlPozycje() {
		addToPopupSlot(pokazPozycjePresenter);
		WyslijListePozycjiDoWyswietleniaEvent.fire(this, listaFaktur.get(indexListyFaktury).getPozycjeList());

	}

	@Override
	public void buttonAkcjaPrzejdzDoDodajFakture() {
		placeManager.setOnLeaveConfirmation("Do you really want to leave?");
		PlaceRequest responsePlaceRequest = new PlaceRequest.Builder().nameToken(NameTokens.dodajFakture).build();
		placeManager.revealPlace(responsePlaceRequest);
	}

	@Override
	protected void onBind() {
		List<Pozycja> listaPozycji = new ArrayList<>();
		List<Pozycja> listaPozycji2 = new ArrayList<>();
		listaPozycji2.add(new Pozycja("Samochod", "30'000", "4"));
		listaPozycji.add(new Pozycja("Zeszyt", "0.30", "100"));

		listaFaktur.add(new Faktura("Adam", "Adamowicz", listaPozycji2));
		listaFaktur.add(new Faktura("Tomek", "Tomaszewicz", listaPozycji));

		rozmiarListyZFakturami = listaFaktur.size() - 1;
		indexListyFaktury = 0;

		getView().getTextBoxImie().setEnabled(false);
		getView().getTextboxNazwisko().setEnabled(false);
		getView().getTextBoxNrFaktury().setEnabled(false);

		wyswietlFakture();
		super.onBind();
	}

	private void wyswietlFakture() {
		getView().getTextBoxImie().setText(listaFaktur.get(indexListyFaktury).getImie());
		getView().getTextboxNazwisko().setText(listaFaktur.get(indexListyFaktury).getNazwisko());
		getView().getTextBoxNrFaktury().setText(listaFaktur.get(indexListyFaktury).getNrFaktury().toString());
	}

	@Override
	public void buttonAkcjaWybierzPoprzedniaFakture() {
		if (indexListyFaktury != 0) {
			indexListyFaktury--;
		}
		wyswietlFakture();
	}

	@Override
	public void buttonAkcjaWyierzNastepnaFakture() {
		rozmiarListyZFakturami = listaFaktur.size() - 1;
		if (indexListyFaktury != rozmiarListyZFakturami) {
			indexListyFaktury++;
		}
		wyswietlFakture();
	}
}