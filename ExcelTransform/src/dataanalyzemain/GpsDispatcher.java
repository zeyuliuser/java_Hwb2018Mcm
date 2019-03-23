package dataanalyzemain;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GpsDispatcher {

	public String gpsx;
	public String gpsy;
	
	public GpsDispatcher() {
	}

	public String GpsxTransform(String path) throws IOException {
		int i ;
		String gpsinfo;
		String[] a;
		InputStream iStream = new FileInputStream(path);
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(iStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int lastrow = sheet.getLastRowNum();
		if(lastrow>=1) {
			for(i=1;i<=lastrow;i++) {
				gpsinfo = sheet.getRow(i).getCell(1).toString();
				a = gpsinfo.split(" ");
				System.out.println(a[0]);
				gpsx = gpsx +" "+a[0];
				
				
			}
		}
		return gpsx;
	}
	
	public String GpsyTransform(String path) throws IOException {
		int i ;
		String gpsinfo;
		String[] a;
		InputStream iStream = new FileInputStream(path);
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(iStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int lastrow = sheet.getLastRowNum();
		if(lastrow>=1) {
			for(i=1;i<=lastrow;i++) {
				gpsinfo = sheet.getRow(i).getCell(1).toString();
				a = gpsinfo.split(" ");
				gpsy = gpsy + " " + a[1];
				
			}			
		}		
		return gpsy;
	}
}
