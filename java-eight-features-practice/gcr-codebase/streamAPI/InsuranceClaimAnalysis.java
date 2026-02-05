package streamAPI;
import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
            new Claim("Health", 50000),
            new Claim("Vehicle", 30000),
            new Claim("Health", 70000)
        );

        Map<String, Double> avgClaim =
            claims.stream()
                  .collect(Collectors.groupingBy(
                      Claim::getType,
                      Collectors.averagingDouble(Claim::getAmount)
                  ));

        avgClaim.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}