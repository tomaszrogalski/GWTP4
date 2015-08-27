package GWTP10.client.application.dodajpozycje;

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

class DodajPozycjeView extends PopupViewWithUiHandlers<DodajPozycjeUiHandlers>implements DodajPozycjePresenter.MyView {
	interface Binder extends UiBinder<Widget, DodajPozycjeView> {
	}

	@UiField
	TextBox textBoxNazwa;
	@UiField
	TextBox textBoxCena;
	@UiField
	TextBox textboxIlosc;
	@UiField
	Button buttonDodaj;
	@UiField
	Button buttonWstecz;

	@Inject
	DodajPozycjeView(EventBus eventBus, Binder uiBinder) {
		super(eventBus);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("buttonDodaj")
	void dodajClick(ClickEvent e) {
		getUiHandlers().buttonAkcjaDodajPozycje();
		this.hide();
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