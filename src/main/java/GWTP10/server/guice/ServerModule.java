package GWTP10.server.guice;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

import GWTP10.serwer.CzlowiekRPCHandler;
import GWTP10.shared.CzlowiekRPCAction;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
    	bindHandler(CzlowiekRPCAction.class, CzlowiekRPCHandler.class);
    }
}
