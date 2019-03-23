package dataanalyzemain;

import java.io.IOException;

public class MainTransform {

	public static void main(String[] args) throws IOException {
       /*GpsDispatcher gpsDispatcher = new GpsDispatcher();
       String gpsx;
       String gpsy;

       gpsx = gpsDispatcher.GpsxTransform("F:\\learn\\huiyuan.xls");

       System.out.println(gpsx);*/
		
		/*TransToMatlabFormat transToMatlabFormat = new TransToMatlabFormat();
		transToMatlabFormat.GpsxTransform("C:\\Users\\LZY\\Desktop\\partdata.xls");*/
		
		MethodAndMember methodAndMember=new MethodAndMember();
		methodAndMember.caculateDistance("C:\\Users\\LZY\\Desktop\\partdata.xls");

	}

}
