package GWTP10.client.application.przyklad2;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class Przyklad2Module extends AbstractPresenterModule {
    @Override
    protected void configure() {
    	bindPresenterWidget(Przyklad2Presenter.class, Przyklad2Presenter.MyView.class, Przyklad2View.class);
       
    }
}