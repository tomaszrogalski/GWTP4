package GWTP10.client.application.dodajfakture;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class DodajFaktureView extends ViewWithUiHandlers<DodajFaktureUiHandlers>implements DodajFakturePresenter.MyView {
	interface Binder extends UiBinder<Widget, DodajFaktureView> {
	}

	@UiField
	TextBox textBoxNrFaktury;
	@UiField
	TextBox textBoxImie;
	@UiField
	TextBox textboxNazwisko;
	@UiField
	Button buttonDodajFakture;
	@UiField
	Button buttonWstecz;
	@UiField
	Button buttonDodajPozycje;

	@Inject
	DodajFaktureView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("buttonDodajFakture")
	void dodajFaktureClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajFakture();

	}

	@UiHandler("buttonWstecz")
	void wsteczClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaCofnijDoWywswietlFaktura();

	}

	@UiHandler("buttonDodajPozycje")
	void dodajPozycjeClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajPozycje();
	}

	public TextBox getTextBoxNrFaktury() {
		return textBoxNrFaktury;
	}

	public TextBox getTextBoxImie() {
		return textBoxImie;
	}

	public TextBox getTextboxNazwisko() {
		return textboxNazwisko;
	}
	
	
}