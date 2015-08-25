package GWTP10.client.application.przyklad2;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class Przyklad2Presenter extends PresenterWidget<Przyklad2Presenter.MyView> {
	interface MyView extends PopupView {
		public Button getOkButton();
	}

	@Inject
	Przyklad2Presenter(EventBus eventBus, MyView view) {
		super(eventBus, view);

	}

	@Override
	protected void onBind() {
		super.onBind();

		getView().getOkButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getView().hide();
			}
		});
	}
}