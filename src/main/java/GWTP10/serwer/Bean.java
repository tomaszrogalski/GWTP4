package GWTP10.serwer;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import GWTP10.shared.CzlowiekDto;

@Stateless
@Remote
public class Bean {

	@PersistenceContext(unitName = "cwiczenie2")
	private EntityManager entityManager;

	public void stworz(CzlowiekDto czlowiekDTO) {
		entityManager.persist(czlowiekDTO);
	}

	public void stworzczlowiek(Czlowiek stworzObiektKlasyCzlowiekZCzlowiekDto) {
		entityManager.persist(stworzObiektKlasyCzlowiekZCzlowiekDto);
		
	}
}
