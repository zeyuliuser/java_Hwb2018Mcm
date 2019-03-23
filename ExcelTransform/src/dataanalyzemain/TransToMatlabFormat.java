package dataanalyzemain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TransToMatlabFormat {
	String matlabstring;
	public String GpsxTransform(String path) throws IOException {
		int i ;
		String info;
		InputStream iStream = new FileInputStream(path);
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(iStream);
		HSSFSheet sheet = workbook.getSheetAt(2);
		int lastrow = sheet.getLastRowNum();
		if(lastrow>=1) {
			for(i=131;i<=lastrow;i++) {
				info = sheet.getRow(i).getCell(3).toString();	
				matlabstring = matlabstring +" "+ info;		
				
			}
		}
		System.out.println(matlabstring);
		return matlabstring;
	}

}
