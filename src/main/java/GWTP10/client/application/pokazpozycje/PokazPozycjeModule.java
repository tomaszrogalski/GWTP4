package GWTP10.client.application.pokazpozycje;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PokazPozycjeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(PokazPozycjePresenter.class, PokazPozycjePresenter.MyView.class, PokazPozycjeView.class);
    }
}