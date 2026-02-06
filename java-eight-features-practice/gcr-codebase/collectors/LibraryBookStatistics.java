package collectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book{
	String genre;
	int pages;
	public Book(String genre, int pages) {
		this.genre = genre;
		this.pages = pages;
	}
	public String getGenre() {
		return genre;
	}
	public int getPages() {
		return pages;
	}
	
}
public class LibraryBookStatistics {

	public static void main(String[] args) {
		List<Book> books = Arrays.asList(new Book("Fiction", 320),new Book("Fiction", 280),
                new Book("Science", 450), new Book("Science", 500), new Book("History", 400));
		
		Map<String, IntSummaryStatistics> statsByGenre =books.stream()
                     .collect(Collectors.groupingBy(
                             Book::getGenre,
                             Collectors.summarizingInt(Book::getPages)));

		statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages   : " + stats.getSum());
            System.out.println("Average Pages : " + stats.getAverage());
            System.out.println("Max Pages     : " + stats.getMax());
            System.out.println("----------------------------");
        });
	}

}
