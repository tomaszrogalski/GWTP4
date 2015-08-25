package GWTP10.serwer;

import java.sql.SQLException;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import GWTP10.shared.CzlowiekRPCAction;
import GWTP10.shared.CzlowiekRPCResult;

public class CzlowiekRPCHandler implements ActionHandler<CzlowiekRPCAction, CzlowiekRPCResult> {

	@Override
	public CzlowiekRPCResult execute(CzlowiekRPCAction action, ExecutionContext context) throws ActionException {

		// Do dao w tej lini przekazuje czlowieka
		try {
			new CzlowiekRPCDao().createCzlowiek(action.getCzlowiekDto().StworzObiektKlasyCzlowiekZCzlowiekDto());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new CzlowiekRPCResult("Hejka");
	}

	@Override
	public Class<CzlowiekRPCAction> getActionType() {

		return CzlowiekRPCAction.class;
	}

	@Override
	public void undo(CzlowiekRPCAction action, CzlowiekRPCResult result, ExecutionContext context) throws ActionException {

	}
}
