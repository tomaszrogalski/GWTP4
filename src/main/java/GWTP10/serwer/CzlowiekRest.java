package GWTP10.serwer;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import GWTP10.shared.CzlowiekDto;

@Path("/czlowiek")
public class CzlowiekRest {

	@EJB
	private Bean bean;

	@POST
	@Path("/dodajPOST")
	public Response create() {
		CzlowiekDto czlowiekDto = new CzlowiekDto(23L, "imie", "nazwisko", "pesel", "ulica", "nrdomu", "miejscowosc");
		bean.stworz(czlowiekDto);
		
		CzlowiekDto czlowiekDto2 = new CzlowiekDto(26L, "imie", "nazwisko", "pesel", "ulica", "nrdomu", "miejscowosc");
		
		bean.stworzczlowiek(czlowiekDto2.StworzObiektKlasyCzlowiekZCzlowiekDto());
		return Response.ok().build();
	}

	public CzlowiekRest() {
		super();
	}

	

}
