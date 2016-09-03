package com.stock.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jdt.internal.compiler.ast.WhileStatement;

public class UomNotepad {


	public static void main(String[] args) throws IOException 
	{
             Stock_Lib SL=new Stock_Lib();
		
		String Res=SL.OpenApp("http://webapp.qedgetech.com");
             System.out.println(Res);
             Res= SL.AdminLgn("admin","master");
             System.out.println(Res);
		//test data path
     String Fpath="C:\\Users\\user06\\stock\\ERP\\src\\com\\stock\\testdata\\Uom.txt";
     //creating for results
     String Rpath="C:\\Users\\user06\\stock\\ERP\\src\\com\\stock\\results\\uomres.txt";
     String SD;
     FileReader FR=new FileReader(Fpath);
     BufferedReader BR=new BufferedReader(FR);
     String Sread=BR.readLine();
     System.out.println(Sread);
     
     FileWriter FW=new FileWriter(Rpath);
     BufferedWriter BW=new BufferedWriter(FW);
     BW.write(Sread+"$$$"+"Results");
     BW.newLine();
     
     while ((SD=BR.readLine())!=null)
     {
		System.out.println(SD);
		String[] SR=SD.split("###");
		String Uid=SR[0];
		System.out.println(Uid);
		String Udes=SR[1];
		System.out.println(Udes);
	
         Res=SL.UOM(Uid,Udes);
         System.out.println(Res);
         
         BW.write(Uid+"&&&"+Udes+"@@@"+Res);
         BW.newLine();
     
     }
     BW.close();
     FW.close();
	}

}
