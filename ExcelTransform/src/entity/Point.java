package entity;

public class Point {
	
	private String name;
	
	private double gpsx;
	
	private double gpsy;
	
	private double distance;
	
	

	public Point(String name, double gpsx, double gpsy, double distance) {
		/*super();*/
		this.name = name;
		this.gpsx = gpsx;
		this.gpsy = gpsy;
		this.distance = distance;
	}
	
	

	public Point() {
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpsx() {
		return gpsx;
	}

	public void setGpsx(double gpsx) {
		this.gpsx = gpsx;
	}

	public double getGpsy() {
		return gpsy;
	}

	public void setGpsy(double gpsy) {
		this.gpsy = gpsy;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	
}
