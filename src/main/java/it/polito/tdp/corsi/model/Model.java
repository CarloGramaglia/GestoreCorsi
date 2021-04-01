package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	
	public Model() {
		corsoDao = new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return corsoDao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso,Integer> getIscrittiByPeriodo(Integer pd) {
		return corsoDao.getIscrittiByPeriodo(pd);
	}
	
	public List<Studente> getStudenteByCorso(String codice){
		return corsoDao.getStudentiByCorso(new Corso(codice, 0, null, 0));
	}

	public boolean esisteCorso(String codice) {
		return corsoDao.esisteCorso(new Corso(codice, 0, null, 0));
	}
	
	public Map<String,Integer> getDivisioneCDS(String codice) {
		//Cosa ci aspettiamo
		//dato il corso con codice ABC
		//GEST -> 50
		//INF -> 40
		//MEC -> 30
		
		
		/*SOLUZUIONE 1-start
		Map<String, Integer> divisione =new HashMap<String,Integer>();
		
		List<Studente> studenti = this.getStudenteByCorso(codice);
		for(Studente s: studenti) {
			if(s.getCDS()!=null && !s.getCDS().equals("")) {
				if(divisione.get(s.getCDS()) == null) {
					 divisione.put(s.getCDS(), 1);
				}else {
					divisione.put(s.getCDS(), divisione.get(s.getCDS())+1);
				}
			}	
		}
		return divisione;
		SOLUZUIONE 1-end*/
		
		return corsoDao.getDivisioneStudenti(new Corso(codice,0,null,0));
		
	}
}
