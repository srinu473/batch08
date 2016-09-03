package com.stock.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exelib {

	
	public static void main(String[] args) throws IOException 
	
	{
		Stock_Lib SL=new Stock_Lib();
		
		String Res=SL.OpenApp("http://webapp.qedgetech.com");
             System.out.println(Res);
             Res= SL.AdminLgn("admin","master");
             System.out.println(Res);
             //Res=SL.UOM("quality08","Accs08");
             //System.out.println(Res);
             
             //Working with Excel
             FileInputStream Fis=new FileInputStream("C:\\Users\\user06\\stock\\ERP\\src\\com\\stock\\testdata\\UOM.xlsx");
             //Workbook creation
             XSSFWorkbook WB=new XSSFWorkbook(Fis);
             //Sheet
             XSSFSheet WS=WB.getSheet("Uomdata");
             //row
           /*  XSSFRow WR=WS.getRow(1);
             //Column
                XSSFCell WC=WR.getCell(0);
                Res=WC.getStringCellValue();
             System.out.println(Res);*/
             //Row count
             
             int Rc=WS.getLastRowNum();
             for (int i = 1; i <=Rc; i++) 
             {
			XSSFRow WR=WS.getRow(i);
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			XSSFCell WC2=WR.createCell(2);
			
			String UomId=WC.getStringCellValue();
			String UomDes=WC1.getStringCellValue();
			
			
			 Res=SL.UOM(UomId,UomDes);
            System.out.println(Res);
            WC2.setCellValue(Res);			
            }
            FileOutputStream Fos=new FileOutputStream("C:\\Users\\user06\\stock\\ERP\\src\\com\\stock\\results\\Uomres.xlsx");
            WB.write(Fos);
            WB.close();
             
             
             
	}

}
