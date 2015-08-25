package GWTP10.client.application.home;



import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import GWTP10.client.application.ApplicationPresenter;
import GWTP10.client.place.NameTokens;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
	public interface MyView extends View {
		public TextBox getTextboxImie();

		public TextBox getTextboxNazwisko();

		public TextBox getTextboxPesel();

		public TextBox getTextboxUlica();

		public TextBox getTextboxNrDomu();

		public TextBox getTextboxMiejscowosc();

		public Button getButtonWyczysc();

		public Button getButtonWyslij();
	}

	private final PlaceManager placeManager;

	@ProxyStandard
	@NameToken(NameTokens.home)
	public interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	//
	@Inject
	HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);

		this.placeManager = placeManager;
	}

	@Override
	protected void onBind() {
		super.onBind();
		registerHandler(getView().getButtonWyslij().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				
				
				wyslijDaneDoServera();
			}

		}));
	}

	@Override
	protected void onReset() {
		super.onReset();
		getView().getButtonWyczysc().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getView().getTextboxImie().setText(null);
				getView().getTextboxNazwisko().setText(null);
				getView().getTextboxPesel().setText(null);
				getView().getTextboxUlica().setText(null);
				getView().getTextboxNrDomu().setText(null);
				getView().getTextboxMiejscowosc().setText(null);
			}
		});
	}

	private void wyslijDaneDoServera() {
		// Nie wiem jak przeslac OBIEKT wiec go zasymuluje po wyslaniu
		PlaceRequest responsePlaceRequest = new PlaceRequest.Builder().nameToken(NameTokens.odpowiedz).build();
		placeManager.revealPlace(responsePlaceRequest);
	}
}
