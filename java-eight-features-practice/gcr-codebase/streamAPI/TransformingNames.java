package streamAPI;

import java.util.*;

public class TransformingNames {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("deepa", "rahul", "amit");

        names.stream()
             .map(String::toUpperCase)
             .sorted()
             .forEach(System.out::println);
    }
}