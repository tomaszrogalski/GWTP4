package GWTP10.client.application.dodajfakture;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import GWTP10.client.application.WyslijFaktureDoWyswietleniaEvent;
import GWTP10.client.application.dodajpozycje.DodajPozycjePresenter;
import GWTP10.client.place.NameTokens;
import GWTP10.serwer.Faktura;
import GWTP10.serwer.Pozycja;

public class DodajFakturePresenter extends Presenter<DodajFakturePresenter.MyView, DodajFakturePresenter.MyProxy>
		implements DodajFaktureUiHandlers {
	interface MyView extends View, HasUiHandlers<DodajFaktureUiHandlers> {
		public TextBox getTextBoxNrFaktury();

		public TextBox getTextBoxImie();

		public TextBox getTextboxNazwisko();
	}

	private List<Pozycja> listaPozycji = new ArrayList<>();

	DodajPozycjePresenter dodajPozycjePresenter;

	@NameToken(NameTokens.dodajFakture)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<DodajFakturePresenter> {
	}

	@Inject
	PlaceManager placeManager;

	@Inject
	DodajFakturePresenter(EventBus eventBus, MyView view, MyProxy proxy, DodajPozycjePresenter dodajPozycjePresenter) {
		super(eventBus, view, proxy, RevealType.Root);
		this.dodajPozycjePresenter = dodajPozycjePresenter;

		getView().getTextBoxNrFaktury().setEnabled(false);

		getView().setUiHandlers(this);
	}

	@Override
	public void buttonAkcjaDodajPozycje() {
		addToPopupSlot(dodajPozycjePresenter);
	}

	@Override
	public void buttonAkcjaCofnijDoWywswietlFaktura() {
		placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.wyswietlFakture).build());
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);

		String pozycja;

		pozycja = request.getParameter("pozycja", "cos");
		String[] pozycjaSkladowe = pozycja.split(",");

		String name = pozycjaSkladowe[0];
		String cena = pozycjaSkladowe[1];
		String ilosc = pozycjaSkladowe[2];

		if (!pozycja.equals("cos")) {
			listaPozycji.add(new Pozycja(name, cena, ilosc));
		}

	}

	@Override
	protected void onHide() {
		listaPozycji = new ArrayList<>();
		getView().getTextBoxImie().setText("");
		getView().getTextboxNazwisko().setText("");
		super.onHide();
	}

	@Override
	public void buttonAkcjaDodajFakture() {
		Faktura faktura = new Faktura(getView().getTextBoxImie().getText(), getView().getTextboxNazwisko().getText(),
				listaPozycji);
		WyslijFaktureDoWyswietleniaEvent.fire(this, faktura);
		PlaceRequest responsePlaceRequest = new PlaceRequest.Builder().nameToken(NameTokens.wyswietlFakture).build();
		placeManager.revealPlace(responsePlaceRequest);

	}
}