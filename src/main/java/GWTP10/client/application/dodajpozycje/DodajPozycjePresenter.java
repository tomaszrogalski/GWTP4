package GWTP10.client.application.dodajpozycje;

import java.util.List;

import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

import GWTP10.client.application.WyslijListePozycjiDoWyswietleniaEvent;
import GWTP10.client.application.WyslijPozycjeDoFakturyDoDodaniaEvent;
import GWTP10.serwer.Pozycja;

public class DodajPozycjePresenter extends PresenterWidget<DodajPozycjePresenter.MyView>
		implements DodajPozycjeUiHandlers {
	interface MyView extends PopupView, HasUiHandlers<DodajPozycjeUiHandlers> {
		public TextBox getTextBoxNazwa();

		public TextBox getTextBoxCena();

		public TextBox getTextboxIlosc();
	}

	private List<Pozycja> listaPozycji;

	@Inject
	private static EventBus eventBus;

	@Inject
	DodajPozycjePresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);

		getView().setUiHandlers(this);
	}

	@Override
	public void buttonAkcjaDodajPozycje() {

		Pozycja pozycja = new Pozycja(getView().getTextBoxNazwa().getText(), getView().getTextBoxCena().getText(),
				getView().getTextboxIlosc().getText());
		listaPozycji.add(pozycja);
		WyslijPozycjeDoFakturyDoDodaniaEvent.fire(this, listaPozycji);

		getView().getTextBoxNazwa().setText("");
		getView().getTextBoxCena().setText("");
		getView().getTextboxIlosc().setText("");
	}

}