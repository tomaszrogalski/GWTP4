package GWTP10.shared;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class CzlowiekRPCResult implements Result {

	private String odpowiedzZSerwera = "Sa dwa uda, albo sie uda albo sie nie uda";

	public CzlowiekRPCResult(final String odpowiedzZSerwera) {
		this.odpowiedzZSerwera = odpowiedzZSerwera;
	}

	@SuppressWarnings("nieuzywany")
	public CzlowiekRPCResult() {
		super();
	}

	public String getOdpowiedzZSerwera() {
		return odpowiedzZSerwera;
	}

}
