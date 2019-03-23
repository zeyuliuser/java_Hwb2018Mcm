package mainfuntion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class AnalyzeExcelToPrice {

	public void DesicePrice(String path) throws IOException {
		int i;
		double gpsx;
		double gpsy;
		double mindistance;
		int nearbypointnum;
		double predictprice;
		int state;
		double ordprice;
		
		MethodInfo methodInfo = new MethodInfo();
		AnalyzeExcelToPrice aetp = new AnalyzeExcelToPrice();

		InputStream iStream = new FileInputStream(path);
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(iStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int lastrow = sheet.getLastRowNum();
		if (lastrow >= 1) {
			for (i = 1; i <= lastrow; i++) {
				gpsx = Double.parseDouble(sheet.getRow(i).getCell(1).toString());
				gpsy = Double.parseDouble(sheet.getRow(i).getCell(2).toString());
				//已完成状态
					//state = (int) (Double.parseDouble(sheet.getRow(i).getCell(4).toString()));
				//无状态
					state = 3;
				//已完成价格
				//ordprice = Double.parseDouble(sheet.getRow(i).getCell(3).toString());
				//无价格
					ordprice = 0;

				methodInfo = methodInfo.searchForPart(gpsx, gpsy);
				mindistance = aetp.checkForMinDistance(gpsx, gpsy, methodInfo.getPartinfo());
				nearbypointnum = aetp.calNearbyPointNum(gpsx,gpsy,methodInfo.getPartinfo(),mindistance);
				/*System.out.println(mindistance);*/
				predictprice =  aetp.calPrice(methodInfo.getPartinfo(),mindistance,nearbypointnum,state,ordprice);
				System.out.println(predictprice);
			}
		}
	}

	private int calNearbyPointNum(double gpsx, double gpsy, int partinfo,double mindistance) throws IOException {
		
		int i;
		double acceptDistance;
		int calNum=0;
		double t1;
		double t2;		
		double f;
		if(partinfo==1) {
			acceptDistance=0.0103012437254907;
		}else if(partinfo==2) {
			acceptDistance=0.184229808;
		}else if (partinfo == 3) {
			acceptDistance=0.086126741;
		}else {
			acceptDistance = 0.0001;
		}
		//acceptDistance = mindistance*10;
		//遍历区内密度
		InputStream iStream = new FileInputStream("C:\\Users\\LZY\\Desktop\\partdata.xls");
		//遍历全局密度
		//InputStream iStream = new FileInputStream("C:\\Users\\LZY\\Desktop\\member.xls");
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(iStream);
		HSSFSheet sheet = workbook.getSheetAt(2 + partinfo);
		//HSSFSheet sheet = workbook.getSheetAt(0);
		int lastrow = sheet.getLastRowNum();
		if (lastrow >= 1) {
			for (i = 1; i <= lastrow; i++) {
				t1=Double.parseDouble(sheet.getRow(i).getCell(6).toString());
				t2=Double.parseDouble(sheet.getRow(i).getCell(5).toString());
				/*t1=Double.parseDouble(sheet.getRow(i).getCell(1).toString());
				t2=Double.parseDouble(sheet.getRow(i).getCell(2).toString());*/
				
				f=(t1-gpsx)*(t1-gpsx)+(t2-gpsy)*(t2-gpsy);
				if(f<=acceptDistance) {
					calNum++;
				}
			}
		}
		//System.out.println(calNum);
		return calNum ;
	}

	private double calPrice(int partinfo, double mindistance,int nearbypointnum,int state,double ordprice) {
		double predictprice;
		Random random = new Random();
		if(partinfo==1) {
			predictprice = 678.114*mindistance-0.075*nearbypointnum+72.579;
		}else if(partinfo == 2) {
			predictprice = 40.241*mindistance-0.019*nearbypointnum+73.747;
		}else if (partinfo == 3) {
			predictprice = 1.359*mindistance-0.012*nearbypointnum+73.580;
		}else {
			predictprice = 0;
		}
		if(state ==1) {
			if (predictprice>=ordprice) {
				predictprice = ordprice;
			}else {				
		}
		}else if (state==0) {
			if (predictprice<=ordprice) {
				predictprice = ordprice+Math.random()+random.nextInt(10);
			}else {
				
			}
		}else {
			
		}
		return predictprice;
	}

	private double checkForMinDistance(double gpsx, double gpsy, int partinfo) throws IOException {
		double mindistance;
		int i;
		double t1;
		double t2;		
		double d;
		double f;
		//区成员数据
		InputStream iStream = new FileInputStream("C:\\Users\\LZY\\Desktop\\partdata.xls");
		
		//所有成员数据
		//InputStream iStream = new FileInputStream("C:\\Users\\LZY\\Desktop\\member.xls");
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(iStream);
		//遍历区成员
		HSSFSheet sheet = workbook.getSheetAt(2 + partinfo);
		int lastrow = sheet.getLastRowNum();
		t1=Double.parseDouble(sheet.getRow(1).getCell(6).toString());
		t2=Double.parseDouble(sheet.getRow(1).getCell(5).toString());
		//遍历所有成员
		/*HSSFSheet sheet = workbook.getSheetAt(0);
		int lastrow = sheet.getLastRowNum();
		t1=Double.parseDouble(sheet.getRow(1).getCell(1).toString());
		t2=Double.parseDouble(sheet.getRow(1).getCell(2).toString());*/
		d=(t1-gpsx)*(t1-gpsx)+(t2-gpsy)*(t2-gpsy);
		if (lastrow >= 1) {
			for (i = 1; i <= lastrow; i++) {
				t1=Double.parseDouble(sheet.getRow(i).getCell(6).toString());
				t2=Double.parseDouble(sheet.getRow(i).getCell(5).toString());
				f=(t1-gpsx)*(t1-gpsx)+(t2-gpsy)*(t2-gpsy);
				if(f<=d) {
					d=f;
				}

			}
		}
		mindistance = d;
		//System.out.println(mindistance);
		return mindistance;
	}

}
