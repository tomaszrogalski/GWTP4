package GWTP10.client.application.wyswietlfakture;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import GWTP10.serwer.Pozycja;

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
	// @UiField
	// Button buttonPokazPozycje;
	@UiField
	Button buttonNastepnaFaktura;
	

	@UiField
	Button buttonPoprzedniaFaktura;

	@UiField
	DataGrid<Pozycja> dataGrid;

	@Inject
	WyswietlFaktureView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));

		TextColumn<Pozycja> textColumnNazwa = new TextColumn<Pozycja>() {

			@Override
			public String getValue(Pozycja pozycja) {
				return pozycja.getNazwa();
			}
		};
		TextColumn<Pozycja> textColumncena = new TextColumn<Pozycja>() {

			@Override
			public String getValue(Pozycja pozycja) {
				return pozycja.getCenaJednostkowa();
			}
		};
		TextColumn<Pozycja> textColumnIlosc = new TextColumn<Pozycja>() {

			@Override
			public String getValue(Pozycja pozycja) {
				return pozycja.getIlosc();
			}
		};

		List<Pozycja> pozycjaList = new ArrayList<>();
		Pozycja poza = new Pozycja("Samochod", "30'000", "4");
		Pozycja poza2 = new Pozycja("Samochod", "30'000", "4");

		pozycjaList.add(poza2);
		pozycjaList.add(poza);
		dataGrid.addColumn(textColumnNazwa, "nazwa");
		dataGrid.addColumn(textColumncena, "cena");
		dataGrid.addColumn(textColumnIlosc, "ilosc");
		dataGrid.setRowCount(pozycjaList.size(), true);
		dataGrid.setRowData(0, pozycjaList);
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

	// @UiHandler("buttonPokazPozycje")
	// void dodajPozycjeClick(ClickEvent e) {
	// getUiHandlers().buttonAkcjaWyswietlPozycje();
	//
	// }

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
	
	public DataGrid<Pozycja> getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(DataGrid<Pozycja> dataGrid) {
		this.dataGrid = dataGrid;
	}

	// public ListView getListview() {
	// return listview;
	// }
	//
	// public void setListview(ListView listview) {
	// this.listview = listview;
	// }

}