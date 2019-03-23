package entity;

public class MemberPoint {
	
	private String memname;
	
	private double mgpsx;
	
	private double mgpsy;
	
	private double time;
	
	private double honour;
	
	private int order;
	
	private String weight;

	private String score;
	public MemberPoint(String memname, double mgpsx, double mgpsy, double time, double honour, int order,String weight,String score) {
		super();
		this.memname = memname;
		this.mgpsx = mgpsx;
		this.mgpsy = mgpsy;
		this.time = time;
		this.honour = honour;
		this.order = order;
		this.weight = weight;
		this.score = score;
	}
	
	public MemberPoint() {		
	}

	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	public double getMgpsx() {
		return mgpsx;
	}

	public void setMgpsx(double mgpsx) {
		this.mgpsx = mgpsx;
	}

	public double getMgpsy() {
		return mgpsy;
	}

	public void setMgpsy(double mgpsy) {
		this.mgpsy = mgpsy;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getHonour() {
		return honour;
	}

	public void setHonour(double honour) {
		this.honour = honour;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	
	
	

}
