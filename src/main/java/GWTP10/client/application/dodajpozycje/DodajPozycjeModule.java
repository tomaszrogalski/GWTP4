package GWTP10.client.application.dodajpozycje;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DodajPozycjeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(DodajPozycjePresenter.class, DodajPozycjePresenter.MyView.class, DodajPozycjeView.class);
    }
}