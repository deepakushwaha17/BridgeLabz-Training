//Write a Program to compute the volume of Earth in km^3 and miles^3

public class EarthVolume{
    public static void main(String[] args){
	    int earthRadiusInKm = 6378;
		final double PI = 3.14;
		double earthVoulmeInKm = (4 / 3) * PI * earthRadiusInKm * earthRadiusInKm * earthRadiusInKm;
		double kmToMiles = 1.6; // 1km = 1.6 miles
		double earthVoulmeInMiles = earthVoulmeInKm * kmToMiles * kmToMiles * kmToMiles ; 
		System.out.println("The volume of earth in cubic kilometers is " + earthVoulmeInKm + " and cubic miles is " + earthVoulmeInMiles);
	}
}
		