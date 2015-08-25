package GWTP10.client.application.wyswietlfakture;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class WyswietlFaktureModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(WyswietlFakturePresenter.class, WyswietlFakturePresenter.MyView.class, WyswietlFaktureView.class, WyswietlFakturePresenter.MyProxy.class);
    }
}