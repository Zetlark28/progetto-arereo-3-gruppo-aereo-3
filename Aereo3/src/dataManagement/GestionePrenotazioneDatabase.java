package dataManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.Query;

import dominio.Cliente;
import dominio.Posto;
import dominio.Prenotazione;
import dominio.Volo;

public class GestionePrenotazioneDatabase extends GestioneDatabase {

	public static List<Prenotazione> getPrenotazioniPerCliente(int codCliente){
		
		String jpql = "SELECT p FROM Prenotazione as p WHERE codCliente = " + codCliente;
		Query query = entityManagerCET.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Prenotazione> prenotazioni = query.getResultList();
		return prenotazioni;
	}
	
	public static List<Prenotazione> getPrenotazioniPerVolo(int idVolo){
		
		String jpql = "SELECT p FROM Prenotazione as p WHERE idVolo = " + idVolo;
		Query query = entityManagerCET.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Prenotazione> prenotazioni = query.getResultList();
		return prenotazioni;
	}

	public static void insertPrenotazione(Cliente c, int v, List<Posto> posti) {
		Prenotazione p = new Prenotazione();
		p.setPagato(false);
		p.setCodCliente(c.getCodCliente());
		p.setIdVolo(v);
		p.setListaBiglietti(posti);
		
		entityManagerGMT.getTransaction().begin();
		entityManagerGMT.persist(p);
		entityManagerGMT.getTransaction().commit();
		entityManagerGMT.clear();
	}

	public static List<Prenotazione> getPrenotazioniInScadenza(){
		Date currentDateScadenza = new Date();
		Calendar calScadenza = Calendar.getInstance();
		calScadenza.add(Calendar.DATE, 4);
		Date expiryInScadenza = calScadenza.getTime();
		
		String jpqlScadenza = "SELECT p FROM Prenotazione as p WHERE p.pagato=0";
		Query queryScadenza = entityManagerCET.createQuery(jpqlScadenza);
		@SuppressWarnings("unchecked")
		List<Prenotazione> prenotazioniScadenza = queryScadenza.getResultList();
		List<Prenotazione> resScadenza = new ArrayList<Prenotazione>();
		for(Prenotazione p : prenotazioniScadenza) {
			Volo v = GestioneVoloDatabase.getVolo(p.getIdVolo());
			if(v.getDataPartenza().getDate()==expiryInScadenza.getDate() && v.getDataPartenza().getMonth()==expiryInScadenza.getMonth() && v.getDataPartenza().getYear()==expiryInScadenza.getYear())
				resScadenza.add(p);
		}
		return resScadenza;
	}
	
	public static List<Prenotazione> getPrenotazioniScadute(){
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 3);
		Date expiry = cal.getTime();
		
		String jpql = "SELECT p FROM Prenotazione as p WHERE p.pagato=0";
		Query query = entityManagerCET.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Prenotazione> prenotazioni = query.getResultList();
		List<Prenotazione> res = new ArrayList<Prenotazione>();
		for(Prenotazione p : prenotazioni) {
			Volo v = GestioneVoloDatabase.getVolo(p.getIdVolo());
			if(v.getDataPartenza().getDate()==expiry.getDate() && v.getDataPartenza().getMonth()==expiry.getMonth() && v.getDataPartenza().getYear()==expiry.getYear())
				res.add(p);
		}
		return res;
	}
	
	public static Prenotazione getIdPrenotazione(Cliente c, int v) {
		String jpql = "SELECT p FROM Prenotazione as p WHERE p.codCliente=:codCliente and p.idVolo=:idVolo";
		Query query = entityManagerCET.createQuery(jpql).setParameter("codCliente", c.getCodCliente()).setParameter("idVolo", v);
		List<Prenotazione>prenotazione = query.getResultList();
		return prenotazione.get(0);
	}
	
	public static void deletePrenotazione(Prenotazione p) {
		entityManagerCET.getTransaction().begin();
		entityManagerCET.remove(p);
		entityManagerCET.getTransaction().commit();
		entityManagerCET.clear();
	}

	public static void pagamentoPrenotazione(int idPrenotazione) {
		entityManagerGMT.getTransaction().begin();
		String jpql ="UPDATE Prenotazione SET pagato=:pagato WHERE id=:id ";
		Query query= entityManagerGMT.createQuery(jpql).setParameter("pagato", true).setParameter("id", idPrenotazione);	
		query.executeUpdate();
		entityManagerGMT.getTransaction().commit();
		entityManagerGMT.clear();
	}
	
	public static boolean trovaCliente(int codCliente, int idVolo) {
		String jpql = "SELECT p FROM Prenotazione as p WHERE p.codCliente=:codCliente and p.idVolo=:idVolo";
		Query query = entityManagerCET.createQuery(jpql).setParameter("codCliente", codCliente).setParameter("idVolo", idVolo);
		List <Prenotazione> ris = query.getResultList();
		if(ris == null || ris.size() == 0)
			return false;
		else 
			return true;
	}
	
	public static Prenotazione getPrenotazionePerId(int id) {
		String jpql = "SELECT p FROM Prenotazione as p WHERE p.id =: id";
		Query query = entityManagerCET.createQuery(jpql).setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Prenotazione> prenotazioni = query.getResultList();
		return prenotazioni.get(0);
	}
	
	
	public static double getSovrapprezzo(int idOld, double costoNuovo) {
		Prenotazione p= getPrenotazionePerId(idOld);
		double sovrapprezzo= costoNuovo-p.getPrezzoTotale();
		double nuovoPrezzo=0;
		if(sovrapprezzo>0) 
			nuovoPrezzo= sovrapprezzo;
		else 
			nuovoPrezzo=10;
		return nuovoPrezzo;
		
	}
		
}
