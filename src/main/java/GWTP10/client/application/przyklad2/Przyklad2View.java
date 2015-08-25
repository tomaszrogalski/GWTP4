package GWTP10.client.application.przyklad2;


import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;

class Przyklad2View extends PopupViewImpl implements Przyklad2Presenter.MyView {
    interface Binder extends UiBinder<Widget, Przyklad2View> {
    }

    @UiField
	Button okButton;
    
    @Inject
    Przyklad2View(EventBus eventBus, Binder uiBinder) {
        super(eventBus);
    
        initWidget(uiBinder.createAndBindUi(this));
    }

	public Button getOkButton() {
		return okButton;
	}
    
    
}