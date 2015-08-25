package GWTP10.client.application.odpowiedz;



import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

class OdpowiedzView extends ViewImpl implements OdpowiedzPresenter.MyView {
    interface Binder extends UiBinder<Widget, OdpowiedzView> {
    }
   
    @UiField
    HTML serverOdpowiedz;
  
    @Inject
    OdpowiedzView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setOdpowiedzSerevera(String serverOdpowiedz) {
        this.serverOdpowiedz.setHTML(serverOdpowiedz);
    }

   

    
    
}