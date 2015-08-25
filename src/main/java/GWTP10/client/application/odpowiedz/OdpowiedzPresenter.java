package GWTP10.client.application.odpowiedz;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.shared.RestDispatch;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import GWTP10.client.place.NameTokens;
import GWTP10.serwer.Czlowiek;
import GWTP10.serwer.CzlowiekRest;
import GWTP10.shared.CzlowiekRPCAction;
import GWTP10.shared.CzlowiekRPCResult;

public class OdpowiedzPresenter extends Presenter<OdpowiedzPresenter.MyView, OdpowiedzPresenter.MyProxy> {
	interface MyView extends View {
		void setOdpowiedzSerevera(String serverOdpowiedz);
	}

	@NameToken(NameTokens.odpowiedz)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<OdpowiedzPresenter> {
	}

	private final DispatchAsync dispatcher;

//	private final RestDispatch dispatcherREST;
//	private final CzlowiekRest czlowiekREST;
//	,
//	RestDispatch dispatcherREST, CzlowiekRest czlowiekREST
	@Inject
	OdpowiedzPresenter(EventBus eventBus, MyView view, MyProxy proxy, DispatchAsync dispatcher) {
		super(eventBus, view, proxy, RevealType.Root);
		this.dispatcher = dispatcher;
//		this.dispatcherREST = dispatcherREST;
//		this.czlowiekREST = czlowiekREST;
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
	}

	protected void onReset() {
		super.onReset();
		
//		dispatcherREST.execute(czlowiekREST.create(),
//				new AsyncCallback<Czlowiek>() {
//
//			
//			
//					@Override
//					public void onFailure(Throwable caught) {
//						getView().setOdpowiedzSerevera("moze innym razem: " + caught.getMessage());						
//					}
//
//					@Override
//					public void onSuccess(Czlowiek result) {
//					getView().setOdpowiedzSerevera("oki");
//						
//					}
//			      
//			    });
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		CzlowiekDto czlowiekDoWyslania = new CzlowiekDto(5L, "imie", "nazwisko", "pesel", "ulica", "nrdomu",
//				"miejscowosc");
//to ponizej sie wywal Jak probuje dodac czlowieka
		dispatcher.execute(new CzlowiekRPCAction("sadasd"), new AsyncCallback<CzlowiekRPCResult>() {

			@Override
			public void onFailure(Throwable caught) {
				getView().setOdpowiedzSerevera("moze innym razem: " + caught.getMessage());
			
			}

			@Override
			public void onSuccess(CzlowiekRPCResult result) {
				getView().setOdpowiedzSerevera(result.getOdpowiedzZSerwera());

			}
		});
	}
}