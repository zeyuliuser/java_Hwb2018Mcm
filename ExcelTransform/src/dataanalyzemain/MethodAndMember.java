package dataanalyzemain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MethodAndMember {
	int finali;
	int finalj;
	
	public void caculateDistance(String path) throws IOException {
		int i ;
		int j ;
		int cal;
		double t1;
		double t2;
		double d1;
		double d2;
		double d;
		double f;
		InputStream iStream = new FileInputStream(path);
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(iStream);
		HSSFSheet sheet2 = workbook.getSheetAt(1);
		HSSFSheet sheet5 = workbook.getSheetAt(4);
		int lastrow1 = sheet2.getLastRowNum();
		int lastrow2 = sheet5.getLastRowNum();		
		for(i=1;i<=lastrow1;i++) {
			t1=Double.parseDouble(sheet2.getRow(i).getCell(1).toString());
			t2=Double.parseDouble(sheet2.getRow(i).getCell(2).toString());
			d1=Double.parseDouble(sheet5.getRow(i).getCell(6).toString());
			d2=Double.parseDouble(sheet5.getRow(i).getCell(5).toString());
			d = (t1-d1)*(t1-d1)+(t2-d2)*(t2-d2);
			cal=0;
			for(j=1;j<=lastrow2;j++) {
				d1=Double.parseDouble(sheet5.getRow(j).getCell(6).toString());
				d2=Double.parseDouble(sheet5.getRow(j).getCell(5).toString());
				f=(t1-d1)*(t1-d1)+(t2-d2)*(t2-d2);
				//得出最小距离
				if(f<=d) {
					d=f;
				}
				/*if(f<=0.0156719822426092) {
					cal++;
				}*/
				
			}
			
			
			System.out.println(d);

		}
		
	}

}
