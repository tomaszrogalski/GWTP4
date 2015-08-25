package GWTP10.client.application.pokazpozycje;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

import GWTP10.client.application.WyslijListePozycjiDoWyswietleniaEvent;
import GWTP10.client.application.WyslijListePozycjiDoWyswietleniaEvent.WyslijListePozycjiDoWyswietleniaHandler;
import GWTP10.serwer.Pozycja;

public class PokazPozycjePresenter extends PresenterWidget<PokazPozycjePresenter.MyView>
		implements PokazPozycjeUiHandlers, WyslijListePozycjiDoWyswietleniaHandler {
	interface MyView extends PopupView, HasUiHandlers<PokazPozycjeUiHandlers> {
		public TextBox getTextBoxNazwa();

		public TextBox getTextBoxCena();

		public TextBox getTextboxIlosc();
	}

	//////////////////////////////////////////////////////////////
	private List<Pozycja> listaPozycji = new ArrayList<>();

	@Override
	public void onWyslijListePozycjiDoWyswietlenia(WyslijListePozycjiDoWyswietleniaEvent event) {
		// listaPozycji = event.getListaPozycji();
		for (Pozycja pozycja : event.getListaPozycji()) {
			listaPozycji.add(pozycja);
		}
		ustawieniaPozycja();
	}

	private Integer indexListyPozycji;
	private int rozmiarListyZPozycjami;

	@Inject
	PokazPozycjePresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);

		getView().setUiHandlers(this);
		/////////////////////////////////////////////////////////////////////
		addRegisteredHandler(WyslijListePozycjiDoWyswietleniaEvent.getType(), this);
	
	}

	public void ustawieniaPozycja() {
		rozmiarListyZPozycjami = listaPozycji.size() - 1;

		indexListyPozycji = 0;

		getView().getTextBoxNazwa().setEnabled(false);
		getView().getTextBoxCena().setEnabled(false);
		getView().getTextboxIlosc().setEnabled(false);

		wyswietlPozycje();

	}

	private void wyswietlPozycje() {
		getView().getTextBoxNazwa().setText(listaPozycji.get(indexListyPozycji).getNazwa());
		getView().getTextBoxCena().setText(listaPozycji.get(indexListyPozycji).getCenaJednostkowa());
		getView().getTextboxIlosc().setText(listaPozycji.get(indexListyPozycji).getIlosc());

	}

	public List<Pozycja> getListaPozycji() {
		return listaPozycji;
	}

	public void setListaPozycji(List<Pozycja> listaPozycji) {
		this.listaPozycji = listaPozycji;
	}

	@Override
	public void buttonAkcjaNastepnaPozycja() {

		if (indexListyPozycji != rozmiarListyZPozycjami) {
			indexListyPozycji++;
		}
		wyswietlPozycje();
	}

	@Override
	public void buttonAckjaPoprzedniaPozycja() {
		if (indexListyPozycji != 0) {
			indexListyPozycji--;
		}
		wyswietlPozycje();

	}

}