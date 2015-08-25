package GWTP10.client.application.odpowiedz;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class OdpowiedzModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(OdpowiedzPresenter.class, OdpowiedzPresenter.MyView.class, OdpowiedzView.class, OdpowiedzPresenter.MyProxy.class);
    }
}