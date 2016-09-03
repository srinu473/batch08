package com.stock.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Stock_Lib 

{
	public static Properties Pr;
	public static FileInputStream Fis;
public static WebDriver driver;
public static String Expval,Actval;

public String OpenApp(String Url) throws IOException

{
	Pr=new Properties();
	Fis=new FileInputStream("C:\\Users\\user06\\stock\\ERP\\src\\com\\stock\\properties\\Rep.properties");
	Pr.load(Fis);    
	Expval="Login";
	    driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(Url);
		Actval=driver.findElement(By.id(Pr.getProperty("Login"))).getText();
	       if(Expval.equalsIgnoreCase(Actval))
	       {
			//System.out.println("Stock accounting login page displayed");
	    	   return "pass";
		}
	       else
	       {
	    	   //System.out.println("Stock accounting login page not displayed");
	          return "fail";
	       }
}


      public String AdminLgn(String Un,String Pwd)
      {
    	  Expval="Administrator";
    		driver.findElement(By.id(Pr.getProperty("Reset"))).click();
    		driver.findElement(By.id(Pr.getProperty("Uname"))).sendKeys(Un);
    		driver.findElement(By.id(Pr.getProperty("Pwd"))).sendKeys(Pwd);
    		
    		driver.findElement(By.id(Pr.getProperty("Login"))).click();
    	
    		 Actval=driver.findElement(By.xpath(".//*[@id='msUserName']/font/strong")).getText();
    		    if(Expval.equalsIgnoreCase(Actval))
    		       {
    				//System.out.println("Stock accounting home page displayed");
    			return "pass";
    		       }
    		       else
    		       {
    		    	   //System.out.println("Stock accounting home page not displayed");
    		      return "fail";
    		       }
      }
      
      
      

      public String UOM(String UOM_id,String UOM_descrptn)
 	
 	{
 		
 		  driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")).click();
 	      Actions act= new Actions(driver);
 	      act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")));
 	      act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a")));
 	      act.click();
 	      act.build().perform();
 	      driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
 	      driver.findElement(By.id("x_UOM_ID")).sendKeys(UOM_id);
 	      driver.findElement(By.id("x_UOM_Description")).sendKeys(UOM_descrptn);
 	      driver.findElement(By.id("btnAction")).click();
 	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
 	      Sleeper.sleepTightInSeconds(2);
 	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
 	      
 	      Expval="Add succeeded";
 	      Actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
 	      if (Expval.equalsIgnoreCase(Actval)) 
 	      {
 	    	  return "Pass";
 		  } 
 	      else
 	      {
 	    	  return "fail";
 		  }
 	}
     

}
