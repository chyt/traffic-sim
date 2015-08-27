package distance;

public class CalculateDistance {
	public double calculateStoppingDistance(double mph, double staticFriction) {
		System.out.println("MPH: " + mph);
		double velocity = mph*0.44704;
		System.out.println("Velocity: " + velocity + " m/s");
		double distance = (velocity*velocity)/(2*staticFriction*9.8);
		System.out.println("Stopping distance required going " + mph + " mph: " + distance + "m");
		return distance;
	}
}
