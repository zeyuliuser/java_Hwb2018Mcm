package entity;

public class MethodPoint {
	
	private String mname;
	
	private String mgpsx;
	
	private String mgpsy;
	
	private double predictprice;
	
	private String clusterid;
	
	public MethodPoint() {		
	}

	public MethodPoint(String mname, String mgpsx, String mgpsy, double predictprice, String clusterid) {
		this.mname = mname;
		this.mgpsx = mgpsx;
		this.mgpsy = mgpsy;
		this.predictprice = predictprice;
		this.clusterid = clusterid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMgpsx() {
		return mgpsx;
	}

	public void setMgpsx(String mgpsx) {
		this.mgpsx = mgpsx;
	}

	public String getMgpsy() {
		return mgpsy;
	}

	public void setMgpsy(String mgpsy) {
		this.mgpsy = mgpsy;
	}

	public double getPredictprice() {
		return predictprice;
	}

	public void setPredictprice(double predictprice) {
		this.predictprice = predictprice;
	}

	public String getClusterid() {
		return clusterid;
	}

	public void setClusterid(String clusterid) {
		this.clusterid = clusterid;
	}
	
	

	
	

}
