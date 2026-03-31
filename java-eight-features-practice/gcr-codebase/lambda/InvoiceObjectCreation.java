package lambda;

import java.util.Arrays;
import java.util.List;

class Invoice{
	int transactionId;

	public Invoice(int transactionId) {
		super();
		this.transactionId = transactionId;
	}
	
	@Override
    public String toString() {
        return  "Invoice[transactionId] : " +transactionId ;
    }
}

public class InvoiceObjectCreation {

	public static void main(String[] args) {
		List<Integer> invoice = Arrays.asList(101,102,103,104,105,106);
		invoice.stream().map(Invoice::new).forEach(a -> System.out.println(a));

	}

}
