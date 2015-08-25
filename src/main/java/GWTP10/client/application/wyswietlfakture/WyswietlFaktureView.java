package GWTP10.client.application.wyswietlfakture;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class WyswietlFaktureView extends ViewWithUiHandlers<WyswietlFaktureUiHandlers>
		implements WyswietlFakturePresenter.MyView {
	interface Binder extends UiBinder<Widget, WyswietlFaktureView> {
	}

	@UiField
	TextBox textBoxNrFaktury;
	@UiField
	TextBox textBoxImie;
	@UiField
	TextBox textboxNazwisko;
	@UiField
	Button buttonDodajNowaFakture;
	@UiField
	Button buttonPokazPozycje;
	@UiField
	Button buttonNastepnaFaktura;
	@UiField
	Button buttonPoprzedniaFaktura;

	@Inject
	WyswietlFaktureView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("buttonNastepnaFaktura")
	void NastepnaFakturaClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaWyierzNastepnaFakture();

	}

	@UiHandler("buttonPoprzedniaFaktura")
	void PoprzedniaFakturaClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaWybierzPoprzedniaFakture();

	}

	@UiHandler("buttonDodajNowaFakture")
	void dodajFaktureClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaPrzejdzDoDodajFakture();

	}

	@UiHandler("buttonPokazPozycje")
	void dodajPozycjeClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaWyswietlPozycje();

	}

	public TextBox getTextBoxNrFaktury() {
		return textBoxNrFaktury;
	}

	public void setTextBoxNrFaktury(TextBox textBoxNrFaktury) {
		this.textBoxNrFaktury = textBoxNrFaktury;
	}

	public TextBox getTextBoxImie() {
		return textBoxImie;
	}

	public void setTextBoxImie(TextBox textBoxImie) {
		this.textBoxImie = textBoxImie;
	}

	public TextBox getTextboxNazwisko() {
		return textboxNazwisko;
	}

	public void setTextboxNazwisko(TextBox textboxNazwisko) {
		this.textboxNazwisko = textboxNazwisko;
	}

	public Button getButtonDodajNowaFakture() {
		return buttonDodajNowaFakture;
	}

	public void setButtonDodajNowaFakture(Button buttonDodajNowaFakture) {
		this.buttonDodajNowaFakture = buttonDodajNowaFakture;
	}

	public Button getButtonPokazPozycje() {
		return buttonPokazPozycje;
	}

	public void setButtonPokazPozycje(Button buttonPokazPozycje) {
		this.buttonPokazPozycje = buttonPokazPozycje;
	}

}