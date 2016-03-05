package enumss;


public enum Enumz {
	
	aamel("buffalo", "18"),
	akbar("virginia", "20"),
	azemoon("cali", "22"),
	ossamah("minnesota", "19");
	
	private final String city;
	private final String age;
	
	Enumz(String origin, String old){
		city=origin;
		age=old;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getAge(){
		return age;
	}

}
