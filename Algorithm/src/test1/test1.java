package test1;

public class test1 {

	public static void main(String[] args) {

		Country object = new Country();
		Country korea = new Country("seoul", 50000000);
		Country japan = new Country("tokyo", 120000000);
		korea.hi();

		System.out.println(korea.population + japan.population);
	}

}
