package GWTP10.client.application.pokazpozycje;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

class PokazPozycjeView extends PopupViewWithUiHandlers<PokazPozycjeUiHandlers>implements PokazPozycjePresenter.MyView {
	interface Binder extends UiBinder<Widget, PokazPozycjeView> {
	}

	@UiField
	TextBox textBoxNazwa;
	@UiField
	TextBox textBoxCena;
	@UiField
	TextBox textboxIlosc;
	@UiField
	Button buttonNastepna;
	@UiField
	Button buttonWstecz;
	@UiField
	Button buttonPoprzednia;

	@Inject
	PokazPozycjeView(EventBus eventBus, Binder uiBinder) {
		super(eventBus);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("buttonNastepna")
	void nastepnaPozycjaClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaNastepnaPozycja();
	}

	@UiHandler("buttonPoprzednia")
	void poprzeddniaPozycjaClick(ClickEvent e) {
		getUiHandlers().buttonAckjaPoprzedniaPozycja();
	}

	@UiHandler("buttonWstecz")
	void wsteczClick(ClickEvent e) {
		this.hide();
	}

	public TextBox getTextBoxNazwa() {
		return textBoxNazwa;
	}

	public TextBox getTextBoxCena() {
		return textBoxCena;
	}

	public TextBox getTextboxIlosc() {
		return textboxIlosc;
	}
}