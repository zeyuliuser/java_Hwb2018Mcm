package mainfuntion;

public class MethodInfo {
	
	public double distance;
	
	public int partinfo;

	double x1=22.642228,x2=114.072741,x3=22.916239,x4=113.829048,x5=23.124365,x6=113.275296;
	
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getPartinfo() {
		return partinfo;
	}

	public void setPartinfo(int partinfo) {
		this.partinfo = partinfo;
	}

	public MethodInfo(double distance, int partinfo) {
		super();
		this.distance = distance;
		this.partinfo = partinfo;
	}
	
	public MethodInfo() {		
	}
	
	public MethodInfo searchForPart(double gpsx,double gpsy) {
		double d1,d2,d3;
		double finald;
		int finalid;
		MethodInfo methodInfo= new MethodInfo();
		
		//按欧式距离分
		/*d1=(gpsx-x1)*(gpsx-x1)+(gpsy-x2)*(gpsy-x2);
		d2=(gpsx-x3)*(gpsx-x3)+(gpsy-x4)*(gpsy-x4);
		d3=(gpsx-x5)*(gpsx-x5)+(gpsy-x6)*(gpsy-x6);
		
		if(d1<=d2) {
			finald = d1;
			finalid = 1;
		}else {
			finald = d2;
			finalid = 2;
		}
		if(finald<d3) {			
		}else {
			finald = d3;
			finalid = 3;
		}*/
		if(gpsx<=22.8&&gpsx>22.5&&gpsy<=114.5&&gpsy>113.8) {
			finald=(gpsx-x1)*(gpsx-x1)+(gpsy-x2)*(gpsy-x2);
			finalid = 1;
		}else if (gpsx<=23.1&&gpsx>22.8&&gpsy<=113.6&&gpsy>112.8) {
			finald=(gpsx-x3)*(gpsx-x3)+(gpsy-x4)*(gpsy-x4);
			finalid = 2;
		}else if (gpsx<=23.33&&gpsx>23.01&&gpsy<=113.6&&gpsy>112.8) {
			finald=(gpsx-x5)*(gpsx-x5)+(gpsy-x6)*(gpsy-x6);
			finalid = 3;
		}else {
			d1=(gpsx-x1)*(gpsx-x1)+(gpsy-x2)*(gpsy-x2);
			d2=(gpsx-x3)*(gpsx-x3)+(gpsy-x4)*(gpsy-x4);
			d3=(gpsx-x5)*(gpsx-x5)+(gpsy-x6)*(gpsy-x6);
			
			if(d1<=d2) {
				finald = d1;
				finalid = 1;
			}else {
				finald = d2;
				finalid = 2;
			}
			if(finald<d3) {			
			}else {
				finald = d3;
				finalid = 3;
			}
		}
		methodInfo.setDistance(finald);
		methodInfo.setPartinfo(finalid);
		//System.out.println(methodInfo.getPartinfo());
		return methodInfo;
	}
	
	

}
