package GWTP10.serwer;

import java.util.List;

public class Faktura {

	private static int nrFakturyStatic = 0;
	private Integer nrFaktury;
	private String imie;
	private String nazwisko;
	private List<Pozycja> pozycjeList;

	public Faktura(String imie, String nazwisko, List<Pozycja> pozycjeList) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pozycjeList = pozycjeList;
		inkrementacjaNrFaktury();
		nrFaktury = nrFakturyStatic;
	}

	public Integer getNrFaktury() {
		return nrFaktury;
	}

	public void setNrFaktury(Integer nrFaktury) {
		this.nrFaktury = nrFaktury;
	}

	public static int getNrFakturyStatic() {
		return nrFakturyStatic;
	}

	public Faktura() {
		super();
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public List<Pozycja> getPozycjeList() {
		return pozycjeList;
	}

	public void setPozycjeList(List<Pozycja> pozycjeList) {
		this.pozycjeList = pozycjeList;
	}

	public static void inkrementacjaNrFaktury() {
		nrFakturyStatic++;

	}
}
