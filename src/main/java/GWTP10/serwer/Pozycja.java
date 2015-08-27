package GWTP10.serwer;

public class Pozycja {

	private String nazwa;
	private String cenaJednostkowa;
	private String ilosc;

	public Pozycja(String nazwa, String cenaJednostkowa, String ilosc) {
		super();
		this.nazwa = nazwa;
		this.cenaJednostkowa = cenaJednostkowa;
		this.ilosc = ilosc;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getCenaJednostkowa() {
		return cenaJednostkowa;
	}

	public void setCenaJednostkowa(String cenaJednostkowa) {
		this.cenaJednostkowa = cenaJednostkowa;
	}

	public String getIlosc() {
		return ilosc;
	}

	public void setIlosc(String ilosc) {
		this.ilosc = ilosc;
	}

	@Override
	public String toString() {
		return nazwa + "," + cenaJednostkowa + "," + ilosc;
	}
}
