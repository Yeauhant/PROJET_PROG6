package ai;

/* Enumération des types d'IA.*/
public enum AIType {

	RANDOM("IA de type RANDOM");
	
	private String name = "";
	
	AIType(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
