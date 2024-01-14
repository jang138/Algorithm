package test1;

public class test1 {

	public static void main(String[] args) {

		Country object = new Country();
		Country korea = new Country("seoul", 50000000);
		Country japan = new Country("tokyo", 120000000);
		Country china = new Country("beijing", 1500000000);
		
		korea.hi();
		object.capital = "aa";
		object.population = 123;

		System.out.println(korea.population + japan.population);
		System.out.println(china.capital + " " + china.population);
		System.out.println(object.capital + " " + object.population);
	}

}
