/********************
Nicolas Mitchell
CECS 220-01
5/24/2017
Assignment 02
Problem 04
********************/
public class FlightTest
{
	public static void main(String [] args)
	{
		Flight flight1 = new Flight("United", "Louisville", "Atlanta", 1009);
		System.out.println(flight1.toString());
		flight1.setAirline("Delta");
		System.out.println("\nNew Airline: " + flight1.getAirline());
		flight1.setDestinationCity("New York");
		System.out.println("\nNew Destination: " + flight1.getDestinationCity());
		flight1.setFlightNumber(9982);
		System.out.println("\nNew Flight Number: " + flight1.getFlightNumber());
		System.out.println(flight1.toString() + "\n");

	}
}

class Flight
{
	String airline,origin,destination;
	int flightNumber;
	Flight(String a, String o, String d,int fN)
	{
		airline = a;
		origin = o;
		destination = d;
		flightNumber = fN;
	}
	public String getAirline()
	{
		return airline;
	}
	public String getOriginCity()
	{
		return origin;
	}
	public String getDestinationCity()
	{
		return destination;
	}
	public int getFlightNumber()
	{
		return flightNumber;
	}
	public void setAirline(String a)
	{
		airline = a;
	}
	public void setOriginCity(String o)
	{
		origin = o;
	}
	public void setDestinationCity(String d)
	{
		destination = d;
	}
	public void setFlightNumber(int n)
	{
		flightNumber = n;
	}
	public String toString()
	{
		String f = "\nAirline: " + airline + "\t\t\tOrigin City: " + origin + "\nDestination City: " + destination + "\tFlight Number: " + flightNumber;
		return f;
	}
}