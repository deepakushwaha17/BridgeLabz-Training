package functionalInterface;

//Custom marker interface
interface SensitiveData {
}

//Example sensitive class
class CreditCards implements SensitiveData {
	String number;
	CreditCards(String number) {
		this.number = number;
	}
}

//Backup processor
public class SensitiveDataTagging {
	public static void main(String[] args) {
		CreditCards card = new CreditCards("1234-5678-9012-3456");
	
	    if (card instanceof SensitiveData) {
	        System.out.println("Encrypting sensitive data: " + card.number);
	    } else {
	        System.out.println("No encryption needed: " + card.number);
	    }
	}
}
