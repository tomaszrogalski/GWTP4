package GWTP10.client.application;

import java.util.List;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

import GWTP10.serwer.Pozycja;

public class WyslijPozycjeDoFakturyDoDodaniaEvent
		extends GwtEvent<WyslijPozycjeDoFakturyDoDodaniaEvent.WyslijPozycjeDoFakturyDoDodaniaHandler> {
	private static Type<WyslijPozycjeDoFakturyDoDodaniaHandler> TYPE = new Type<WyslijPozycjeDoFakturyDoDodaniaHandler>();

	public interface WyslijPozycjeDoFakturyDoDodaniaHandler extends EventHandler {
		void onWyslijPozycjeDoFakturyDoDodania(WyslijPozycjeDoFakturyDoDodaniaEvent event);
	}

	List<Pozycja> listaPozycji;

	public WyslijPozycjeDoFakturyDoDodaniaEvent(List<Pozycja> listaPozycji) {
		this.listaPozycji = listaPozycji;
	}

	public static void fire(HasHandlers source, List<Pozycja> listaPozycji) {
		source.fireEvent(new WyslijPozycjeDoFakturyDoDodaniaEvent(listaPozycji));
	}

	public static Type<WyslijPozycjeDoFakturyDoDodaniaHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final WyslijPozycjeDoFakturyDoDodaniaHandler handler) {
		handler.onWyslijPozycjeDoFakturyDoDodania(this);
	}

	@Override
	public Type<WyslijPozycjeDoFakturyDoDodaniaHandler> getAssociatedType() {
		return TYPE;
	}

	public List<Pozycja> getListaPozycji() {
		return listaPozycji;
	}

	public void setListaPozycji(List<Pozycja> listaPozycji) {
		this.listaPozycji = listaPozycji;
	}

}
