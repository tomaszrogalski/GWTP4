package GWTP10.serwer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CzlowiekRPCDao {
	public static final String JDBC_DRIVER = "org.postgresql.Driver";
	public static final String DB_URL = "jdbc:postgresql://localhost:5433/cwiczenie2";
	public static final String USER = "postgres";
	public static final String PASS = "adminLWW";

	private static Statement zadanie1(Connection polaczenie, Statement zapytania) throws SQLException {

		zapytania = polaczenie.createStatement();

		zapytania.execute("INSERT INTO public.Czlowiek(id,imie,nazwisko) VALUES(6,'imie','nazwisko');");

		System.out.println("Dodano!");
		return zapytania;
	}

	public void createCzlowiek(Czlowiek czlowiek) throws SQLException {
		// public static void main(String[] args) throws SQLException {
		////////////////////////// Sterownik /////////////////////////

		System.out.println("Sprawdzanie sterownika:");
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (Exception e) {
			System.out.println("Blad przy ladowaniu sterownika bazy!");

		}
		System.out.println("Sterownik OK");

		////////////////////////// Otwieranie ////////////////////////

		java.sql.Connection polaczenie = null;
		try {
			polaczenie = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			System.out.println("Blad przy ladowaniu sterownika bazy!");

		}
		System.out.println("Polaczenie OK");

		/////////////////////////// Dzialania ////////////////////////

		Statement zapytania = polaczenie.createStatement();
System.out.println("1");
		zapytania.execute("INSERT INTO public.Czlowiek(id,imie,nazwisko) VALUES(7,'imie','nazwisko');");
		// zapytania.execute("INSERT INTO public.Czlowiek(imie)
		// VALUES('imie');");
System.out.println("2");
		zapytania = zadanie1(polaczenie, zapytania);
		//
		// zapytania = Zadanie2(polaczenie, zapytania);
		//
		// zapytania = Zadanie3(polaczenie, zapytania);
		//
		// zapytania = Zadanie4(polaczenie, zapytania);
		//
		// zapytania = Zadanie5(polaczenie, zapytania);
		//
		// zapytania = Zadanie6(polaczenie, zapytania);

		////////////////////////// Zamykanie ////////////////////////

		System.out.println("Zamykanie polaczenia");
		try {
			zapytania.close();
			polaczenie.close();
		} catch (SQLException e) {
			System.out.println("Blad przy zamykaniu polaczenia " + e.toString());

		}
		System.out.print("Zamkniecie OK");

		/////////////////////////////////////////////////////////////

		// CzlowiekDto czlowiekDoWyslania = new CzlowiekDto(5L, "imie",
		// "nazwisko", "pesel", "ulica", "nrdomu",
		// "miejscowosc");
		//
		// EntityManagerFactory entityManagerFactory =
		// Persistence.createEntityManagerFactory("cwiczenie2");
		// EntityManager entityManager =
		// entityManagerFactory.createEntityManager();
		// EntityTransaction tx = entityManager.getTransaction();
		//
		//
		// tx.begin();
		// entityManager.persist(czlowiekDoWyslania.StworzObiektKlasyCzlowiekZCzlowiekDto());
		// entityManager.persist(czlowiek);
		// tx.commit();
		//
		// entityManager.close();

	}
}

// SessionFactory sessionfactory = new
// Configuration().configure().buildSessionFactory();
// Session session = sessionfactory.openSession();
// Transaction transaction = session.beginTransaction();
//
// try
// {
//
// session.save(czlowiek);
// transaction.commit();
// System.err.println("Udalo sie");
//
// } catch (
//
// RuntimeException e)
// {
// try {
// transaction.rollback();
// System.err.println(e.getMessage());
// System.err.println("Nie udalo sie - ROLLBACK");
//
// } catch (RuntimeException rbe) {
// System.err.println("Nawet ROLLBACK sie zepsul");
//
// } finally {
// session.close();
// }
// }
