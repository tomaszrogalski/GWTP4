package GWTP10.serwer;

import java.io.Serializable;

public class Pozycja implements Serializable{

	private String nazwa;
	private String cenaJednostkowa;
	private String ilosc;
	private Jednostki jednosta;

	public Pozycja(String nazwa, String cenaJednostkowa, String ilosc, Jednostki jednosta) {
		super();
		this.nazwa = nazwa;
		this.cenaJednostkowa = cenaJednostkowa;
		this.ilosc = ilosc;
		this.jednosta = jednosta;
	}

	public Pozycja() {
		// TODO Auto-generated constructor stub
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


	public Jednostki getJednosta() {
		return jednosta;
	}

	public void setJednosta(Jednostki jednosta) {
		this.jednosta = jednosta;
	}

	@Override
	public String toString() {
		return nazwa + "," + cenaJednostkowa + "," + ilosc + "," + jednosta.toString();
	}
}
