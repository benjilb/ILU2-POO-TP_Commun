package model;

public class ReservationRestaurant extends Reservation {
	private int numeroService;
	private int numeroTable;
	
	
	public ReservationRestaurant(int jour, int mois, int numeroService, int numeroTable) {
		super(jour, mois);
		this.numeroService = numeroService;
		this.numeroTable = numeroTable;
	}
	public String transfo(int numService) {
		if(numeroService == 1) {
			return "premier";
		} else {
			return "deuxième";
		}
	}
	public String toString() {
		return "Le " + jour + "/" + mois + "\nTable " + numeroTable + " pour le " + transfo(numeroService) + " service.";
	}
	
}
