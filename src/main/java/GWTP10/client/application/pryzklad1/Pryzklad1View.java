package GWTP10.client.application.pryzklad1;



import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

class Pryzklad1View extends ViewImpl implements Pryzklad1Presenter.MyView {
    interface Binder extends UiBinder<Widget, Pryzklad1View> {
    }

    @UiField
    Button example;
    
    @Inject
    Pryzklad1View(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("example")
    void handleClick(ClickEvent e) {
      Window.alert("Hello");    
    }
}