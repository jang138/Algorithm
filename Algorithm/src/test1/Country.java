package test1;

public class Country {
	String capital = "";
	long population = 0;

	Country() {
	}

	Country(String capital, long population) {
		this.capital = capital;
		this.population = population;
	}

	void hi() {
		System.out.println("country!");
	}
}
