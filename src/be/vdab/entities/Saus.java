package be.vdab.entities;


import java.util.List;

public class Saus {
	
	
	private long nummer;
	private String naam;
	private List<String> ingredienten;
	
	
	
	public Saus(long nummer, String naam, List<String> ingredienten) {
		
		setNummer(nummer);
		setNaam(naam);
		setIngredienten(ingredienten);
		
		
	}
	
	
	public long getNummer() {
		return nummer;
	}
	public void setNummer(long nummer) {
		this.nummer = nummer;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public List<String> getIngredienten() {
		return ingredienten;
	}
	public void setIngredienten(List<String> ingredienten) {
		this.ingredienten = ingredienten;
	}
	
	
	
	

}
