package GWTP10.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import GWTP10.client.application.dodajfakture.DodajFaktureModule;
import GWTP10.client.application.dodajpozycje.DodajPozycjeModule;
import GWTP10.client.application.home.HomeModule;
import GWTP10.client.application.pokazpozycje.PokazPozycjeModule;
import GWTP10.client.application.wyswietlfakture.WyswietlFaktureModule;

public class ApplicationModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new DodajPozycjeModule());
		install(new PokazPozycjeModule());
		install(new WyswietlFaktureModule());
		install(new DodajFaktureModule());
		install(new HomeModule());

		bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
				ApplicationPresenter.MyProxy.class);
	}
}
