package GWTP10.client.application.dodajpozycje;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.core.java.util.Arrays;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

import GWTP10.serwer.Jednostki;
import GWTP10.serwer.Pozycja;

class DodajPozycjeView extends PopupViewWithUiHandlers<DodajPozycjeUiHandlers>
		implements Editor<Pozycja>, DodajPozycjePresenter.MyView {
	interface Binder extends UiBinder<Widget, DodajPozycjeView> {
	}

	interface Driver extends SimpleBeanEditorDriver<Pozycja, DodajPozycjeView> {
	}

	@UiField
	TextBox nazwa;
	@UiField
	TextBox cenaJednostkowa;
	@UiField
	TextBox ilosc;

	@UiField
	Button buttonDodaj;
	@UiField
	Button buttonWstecz;

	@UiField(provided = true)
	ValueListBox<Jednostki> jednosta = new ValueListBox<Jednostki>(new Renderer<Jednostki>() {

		@Override
		public String render(Jednostki object) {
			// return object == null ? "" : object.toString();
			return String.valueOf(object);
		}

		@Override
		public void render(Jednostki object, Appendable appendable) throws IOException {
			// TODO Auto-generated method stub

		}

	});

	Driver driver = GWT.create(Driver.class);

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

	public Pozycja pobierzPozycje() {

		Pozycja jakasPozycja = driver.flush();

		Window.alert(jakasPozycja.toString());
		return jakasPozycja;
	}

	public void ustaw() {
		driver.initialize(this);

		jednosta.setAcceptableValues(java.util.Arrays.asList(Jednostki.values()));
		driver.edit(new Pozycja());
		// jednosta.addItem("sztuki");
		// jednosta.addItem("kg");
	}

	public void wyczyscPola() {
		//
		// nazwa.setText("");
		// textBoxCena.setText("");
		// textboxIlosc.setText("");

	}

}
