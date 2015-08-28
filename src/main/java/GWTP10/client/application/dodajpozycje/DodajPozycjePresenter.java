package GWTP10.client.application.dodajpozycje;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import GWTP10.client.place.NameTokens;
import GWTP10.serwer.Pozycja;

public class DodajPozycjePresenter extends PresenterWidget<DodajPozycjePresenter.MyView>
		implements DodajPozycjeUiHandlers {
	interface MyView extends PopupView, HasUiHandlers<DodajPozycjeUiHandlers> {
		Pozycja pobierzPozycje();

		void wyczyscPola();

		public void ustaw();
	}

	@Inject
	PlaceManager placeManager;

	@Inject
	DodajPozycjePresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);
		getView().ustaw();
		getView().setUiHandlers(this);
	}

	@Override
	public void buttonAkcjaDodajPozycje() {
		Pozycja pozycja = getView().pobierzPozycje();
		PlaceRequest responsePlaceRequest = new PlaceRequest.Builder().nameToken(NameTokens.dodajFakture)
				.with("pozycja", pozycja.toString()).build();

		placeManager.revealPlace(responsePlaceRequest);

		getView().wyczyscPola();
	}
}