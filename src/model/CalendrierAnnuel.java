package model;

public class CalendrierAnnuel {
	private Mois[] calendrier;
	
	
	public CalendrierAnnuel() {
		calendrier = new Mois[12];
		calendrier[0] = new Mois("Janvier", 31);
		calendrier[1] = new Mois("Fevrier", 28);
		calendrier[2] = new Mois("Mars", 31);
		calendrier[3] = new Mois("Avril", 30);
		calendrier[4] = new Mois("Mai", 31);
		calendrier[5] = new Mois("Juin", 30);
		calendrier[6] = new Mois("Juillet", 31);
		calendrier[7] = new Mois("Aout", 31);
		calendrier[8] = new Mois("Septembre", 30);
		calendrier[9] = new Mois("Octobre", 31);
		calendrier[10] = new Mois("Novembre", 30);
		calendrier[11] = new Mois("Decembre", 31);
	}
	
	public boolean estLibre(int jours, int mois) {
		return calendrier[mois-1].estLibre(jours-1);
	}
	
	public boolean reserver(int jours, int mois) {
		if(estLibre(jours,mois)) {
			 calendrier[mois-1].reserver(jours-1);
			 return true;
		} else {
			return false;
		}
	}


	//////////////////////Classe Interne ///////////////////////
	private static class Mois {
		private String nom;
		private boolean[] jours;
		
		
		public Mois(String nom, int nbJours) {
			this.nom = nom;
			jours = new boolean[nbJours];
		}


		private boolean estLibre(int nJours) {
			return !jours[nJours];
		}
		
		private void reserver (int nJours) throws IllegalStateException{
			if( !estLibre(nJours)) {
				throw new IllegalStateException("Le jour " + nJours + " est deja reservé.");
			} else {
				jours[nJours] = true;
			}
		}
	}
}
