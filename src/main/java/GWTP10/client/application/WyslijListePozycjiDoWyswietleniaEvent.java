package GWTP10.client.application;

import java.util.List;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

import GWTP10.serwer.Pozycja;

public class WyslijListePozycjiDoWyswietleniaEvent
		extends GwtEvent<WyslijListePozycjiDoWyswietleniaEvent.WyslijListePozycjiDoWyswietleniaHandler> {
	public static Type<WyslijListePozycjiDoWyswietleniaHandler> TYPE = new Type<WyslijListePozycjiDoWyswietleniaHandler>();

	public interface WyslijListePozycjiDoWyswietleniaHandler extends EventHandler {
		void onWyslijListePozycjiDoWyswietlenia(WyslijListePozycjiDoWyswietleniaEvent event);
	}

	//////////////////
	List<Pozycja> listaPozycji;

	////////////////////
	public WyslijListePozycjiDoWyswietleniaEvent(List<Pozycja> listaPozycji) {
		this.listaPozycji = listaPozycji;
	}

	///////////////////
	public static void fire(HasHandlers source, List<Pozycja> listaPozycji) {
		source.fireEvent(new WyslijListePozycjiDoWyswietleniaEvent(listaPozycji));
	}

	public static Type<WyslijListePozycjiDoWyswietleniaHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final WyslijListePozycjiDoWyswietleniaHandler handler) {
		handler.onWyslijListePozycjiDoWyswietlenia(this);
	}

	@Override
	public Type<WyslijListePozycjiDoWyswietleniaHandler> getAssociatedType() {
		return TYPE;
	}

	public List<Pozycja> getListaPozycji() {
		return listaPozycji;
	}

	public void setListaPozycji(List<Pozycja> listaPozycji) {
		this.listaPozycji = listaPozycji;
	}
	
	

}
