package GWTP10.client.application.dodajpozycje;

import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.Presenter.RevealType;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import GWTP10.client.place.NameTokens;
import GWTP10.serwer.Pozycja;

public class DodajPozycjePresenter extends PresenterWidget<DodajPozycjePresenter.MyView>
		implements DodajPozycjeUiHandlers {
	interface MyView extends PopupView, HasUiHandlers<DodajPozycjeUiHandlers> {
		public TextBox getTextBoxNazwa();

		public TextBox getTextBoxCena();

		public TextBox getTextboxIlosc();
	}

	@Inject
	PlaceManager placeManager;

	@Inject
	DodajPozycjePresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	

	@Override
	public void buttonAkcjaDodajPozycje() {

		Pozycja pozycja = new Pozycja(getView().getTextBoxNazwa().getText(), getView().getTextBoxCena().getText(),
				getView().getTextboxIlosc().getText());

		PlaceRequest responsePlaceRequest = new PlaceRequest.Builder().nameToken(NameTokens.dodajFakture)
				.with("pozycja", pozycja.toString()).build();

		placeManager.revealPlace(responsePlaceRequest);

		getView().getTextBoxNazwa().setText("");
		getView().getTextBoxCena().setText("");
		getView().getTextboxIlosc().setText("");
	}
}