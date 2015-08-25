package GWTP10.client.application.pryzklad1;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class Pryzklad1Module extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(Pryzklad1Presenter.class, Pryzklad1Presenter.MyView.class, Pryzklad1View.class, Pryzklad1Presenter.MyProxy.class);
    }
}