package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Movies {
	String name;
	double rating;
	int year;
	public Movies(String name, double rating, int year) {
		super();
		this.name = name;
		this.rating = rating;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Movie Name: " + name + " | Rating: " + rating + " | Year: " + year;
	}
	
}

public class TrendingMovies {

	public static void main(String[] args) {
		List<Movies> movies = Arrays.asList(new Movies("Dune 2", 8.8, 2024),new Movies("Pathaan", 7.9 , 2023),
				new Movies("Jawan", 7.8 , 2023),new Movies("Avatar", 7.6 , 2022),
				new Movies("RRR", 8.9 , 2022),new Movies("Pushpa", 7.4 , 2021));
		movies.stream().filter(m -> m.year >= 2021)
		.sorted(Comparator.comparingDouble((Movies ms)-> ms.rating)
		.reversed().thenComparingInt(ms -> ms.year).reversed()).limit(5).forEach(System.out::println);
	}
}