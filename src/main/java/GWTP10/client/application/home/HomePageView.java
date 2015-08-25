package GWTP10.client.application.home;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomePageView extends ViewImpl implements HomePagePresenter.MyView {
	public interface Binder extends UiBinder<Widget, HomePageView> {
	}

	@UiField
	Label labelImie;
	@UiField
	Label labelNazwisko;
	@UiField
	Label labelPesel;
	@UiField
	Label labelUlica;
	@UiField
	Label labelNrDomu;
	@UiField
	Label labelMiejscowosc;

	@UiField
	TextBox textboxImie;
	@UiField
	TextBox textboxNazwisko;
	@UiField
	TextBox textboxPesel;
	@UiField
	TextBox textboxUlica;
	@UiField
	TextBox textboxNrDomu;
	@UiField
	TextBox textboxMiejscowosc;

	@UiField
	Button buttonWyczysc;
	@UiField
	Button buttonWyslij;

	@Inject
	HomePageView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	

	public TextBox getTextboxImie() {
		return textboxImie;
	}

	public TextBox getTextboxNazwisko() {
		return textboxNazwisko;
	}

	public TextBox getTextboxPesel() {
		return textboxPesel;
	}

	public TextBox getTextboxUlica() {
		return textboxUlica;
	}

	public TextBox getTextboxNrDomu() {
		return textboxNrDomu;
	}

	public TextBox getTextboxMiejscowosc() {
		return textboxMiejscowosc;
	}

	public Button getButtonWyczysc() {
		return buttonWyczysc;
	}

	public Button getButtonWyslij() {
		return buttonWyslij;
	}
}
