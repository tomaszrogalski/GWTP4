package GWTP10.client.application.pryzklad1;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import GWTP10.client.place.NameTokens;

public class Pryzklad1Presenter extends Presenter<Pryzklad1Presenter.MyView, Pryzklad1Presenter.MyProxy> {
	interface MyView extends View {
	}

	@NameToken(NameTokens.przyklad1)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<Pryzklad1Presenter> {
	}

	@Inject
	Pryzklad1Presenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

	}
}