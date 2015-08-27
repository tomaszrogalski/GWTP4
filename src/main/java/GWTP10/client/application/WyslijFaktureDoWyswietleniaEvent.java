package GWTP10.client.application;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

import GWTP10.serwer.Faktura;

public class WyslijFaktureDoWyswietleniaEvent
		extends GwtEvent<WyslijFaktureDoWyswietleniaEvent.WyslijFaktureDoWyswietleniaHandler> {
	private static Type<WyslijFaktureDoWyswietleniaHandler> TYPE = new Type<WyslijFaktureDoWyswietleniaHandler>();

	public interface WyslijFaktureDoWyswietleniaHandler extends EventHandler {
		void onWyslijFaktureDoWyswietlenia(WyslijFaktureDoWyswietleniaEvent event);
	}

	Faktura faktura;

	WyslijFaktureDoWyswietleniaEvent(final Faktura faktura) {
		this.faktura = faktura;
	}

	public static void fire(HasHandlers source, Faktura faktura) {
		source.fireEvent(new WyslijFaktureDoWyswietleniaEvent(faktura));
	}

	public static Type<WyslijFaktureDoWyswietleniaHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final WyslijFaktureDoWyswietleniaHandler handler) {
		handler.onWyslijFaktureDoWyswietlenia(this);
	}

	@Override
	public Type<WyslijFaktureDoWyswietleniaHandler> getAssociatedType() {
		return TYPE;
	}

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

}