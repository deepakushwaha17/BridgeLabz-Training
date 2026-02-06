package collectors;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyCounter {

	public static void main(String[] args) {
		String paragraph = "Java is powerful and Java is popular. Java is fun.";
		
		Map<String , Integer> wordCount = Stream.of(paragraph.split(" "))
				.collect(Collectors.toMap(word -> word, word -> 1, Integer :: sum));

		wordCount.forEach((word, count) ->
        System.out.println(word + " : " + count));
	}

}
