package com.stock.scripts;

import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Basicscript {

	
	public static void main(String[] args) 
	{
		String Expval="Login";
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://webapp.qedgetech.com");
	String Actval=driver.findElement(By.id("btnsubmit")).getText();
       if(Expval.equalsIgnoreCase(Actval))
       {
		System.out.println("Stock accounting login page displayed");
	}
       else
       {
    	   System.out.println("Stock accounting login page not displayed");
       }
       Expval="Administrator";
	driver.findElement(By.id("btnreset")).click();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("master");
	driver.findElement(By.id("btnsubmit")).click();
	Sleeper.sleepTightInSeconds(3);
	 Actval=driver.findElement(By.xpath(".//*[@id='msUserName']/font/strong")).getText();
	    if(Expval.equalsIgnoreCase(Actval))
	       {
			System.out.println("Stock accounting home page displayed");
		}
	       else
	       {
	    	   System.out.println("Stock accounting home page not displayed");
	       }
//driver.findElement(By.xpath(".//*[@id='mi_a_suppliers']/a")).click();
   Actions act=new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).build().perform();
    driver.findElement(By.xpath(".//*[@id='mi_a_stock_categories']/a")).click();
    	
	}

}
