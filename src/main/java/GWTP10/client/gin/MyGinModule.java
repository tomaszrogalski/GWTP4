package GWTP10.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.gwtplatform.dispatch.rest.client.RestApplicationPath;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModule;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModuleBuilder;
import com.gwtplatform.dispatch.shared.SecurityCookie;

public class MyGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		RestDispatchAsyncModule.Builder dispatchBuilder = new RestDispatchAsyncModule.Builder();
		install(dispatchBuilder.build());

		bindConstant().annotatedWith(RestApplicationPath.class).to("/api/v1");
		install(new RestDispatchAsyncModuleBuilder().xsrfTokenHeaderName("Protection-Token").build());
		bindConstant().annotatedWith(SecurityCookie.class).to("JSESSIONID");

	}

}
