package dataanalyzemain;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GetMethodGps {
	public String gpsx="";
	
	public String GpsxTransform(String path) throws IOException {
		int i ;
		String gpsinfo;
		InputStream iStream = new FileInputStream(path);
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(iStream);
		HSSFSheet sheet = workbook.getSheetAt(2);
		int lastrow = sheet.getLastRowNum();
		if(lastrow>=1) {
			for(i=501;i<=lastrow;i++) {
				gpsinfo = sheet.getRow(i).getCell(4).toString();	
				gpsx = gpsx +" "+ gpsinfo;		
				
			}
		}
		System.out.println(gpsx);
		return gpsx;
	}

}
