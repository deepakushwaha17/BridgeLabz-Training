package scenario.FutureLogistics;

public class Utility {
	
	// Validate transportId using regex
	public boolean validateTransportId(String transportId) {
        return transportId.matches("RTS[0-9]{3}[A-Z]");
    }
	
	 // Parses input string and returns GoodsTransport object
	public GoodsTransport parseDetails(String input) {	
		String[] data = input.split(":");
		String transportId = data[0];
		
		 // Validate transportId
		if(!validateTransportId(transportId)) {
			 System.out.println("Transport id " + transportId + " is invalid");
			 System.out.println("Please provide a valid record");   	 
			 return null;
		}
		String date = data[1];
        int rating = Integer.parseInt(data[2]);
        String type = data[3];
        
        // Create BrickTransport object
        if (type.equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(transportId, date, rating,Float.parseFloat(data[4]),
                    Integer.parseInt(data[5]),Float.parseFloat(data[6]));
        }
        
        // Create TimberTransport object
        if (type.equalsIgnoreCase("TimberTransport")) {
            return new TimberTransport(transportId, date, rating,Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]),data[6],Float.parseFloat(data[7]));
        }

        return null;
	}
	
	// Identifies object type
	public String findObjectType(GoodsTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport)
            return "TimberTransport";
        else
            return "BrickTransport";
    }
}