package entity;


public class PackPointInfo {
	
	private int no;
	
	private String pointname1;
	
	private String distance;
	
	private String pointname2;
	
	private String clusterid;

	public String getClusterid() {
		return clusterid;
	}

	public void setClusterid(String clustername) {
		this.clusterid = clustername;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPointname1() {
		return pointname1;
	}

	public void setPointname1(String pointname1) {
		this.pointname1 = pointname1;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getPointname2() {
		return pointname2;
	}

	public void setPointname2(String pointname2) {
		this.pointname2 = pointname2;
	}

	public PackPointInfo(int no, String pointname1, String distance, String pointname2,String clusterid) {
		super();
		this.no = no;
		this.pointname1 = pointname1;
		this.distance = distance;
		this.pointname2 = pointname2;
		this.clusterid = clusterid;
	}
	
	public PackPointInfo() {
		
	}
	
	


}
