package jsonData;
import com.fasterxml.jackson.databind.ObjectMapper;

class Car{
	public String brand;
	public String model;
	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}	
}

public class ObjectToJson {

	public static void main(String[] args) {
		try {
			ObjectMapper objMap = new ObjectMapper();
			Car car = new Car("Toyota" , "Swift");
			
			String jsonString = objMap.writeValueAsString(car);
			System.out.println(jsonString);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}