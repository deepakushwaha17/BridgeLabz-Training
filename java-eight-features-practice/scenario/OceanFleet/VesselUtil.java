package scenario.OceanFleet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VesselUtil {
	
	private List<Vessel> vesselList = new ArrayList<>();

	public List<Vessel> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}
	
	// Add Vessel performance details to the List.
	public void addVesselPerformance(Vessel vessel) {
		vesselList.add(vessel);
	}
	
	// Retrieve vessel detail by vesselId
	public Vessel getVesselById(String vesselId) {
		for(Vessel v : vesselList) {
			if(vesselId.equals(v.getVesselId())) {
				return v;
			}
		}
		return null;
	}
	
	// Retrieve high performance vessels.
	public List<Vessel> getHighPerformanceVessels() {
		List<Vessel> highPerformers = new ArrayList<>();
		
		 if(vesselList.isEmpty()) {
			 return highPerformers;
		 }
		 
		 vesselList.sort(Comparator.comparingDouble(Vessel :: getAverageSpeed).reversed());
		 
		 double maxSpeed = vesselList.get(0).getAverageSpeed();
		 
		 for(Vessel vessel : vesselList) {
			 if(vessel.getAverageSpeed() == maxSpeed) {
				 highPerformers.add(vessel);
			 }else {
				 break;
			 }
		 }
		 return highPerformers;
	}
}
