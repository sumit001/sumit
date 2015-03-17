package util;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import net.sf.saxon.functions.Data;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import tests.TestBase;

public class screenshot extends TestBase{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();
	        driver.get("http://apttest.in");
	        Date date = new Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
	       
	        try{
	            //take screenshot and save it in a file
	        	
	            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           // config.getProperty("screenShotsPath")+"\\"+fileName+".jpg"
	            //copy the file to the required path 
	           // FileUtils.copyFile(screenshot,new File("D:\\DiasparkEnergy\\DiasparkEnergy\\src\\screenshots\\screenshots"+"_"+dateFormat.format(date)+".jpeg"));
	            FileUtils.copyFile(screenshot,new File(config.getProperty("screenShotsPath")+"\\"+"screenshots.jpg"+dateFormat.format(date)));

	        }catch(Exception e){
	            //if it fails to take screenshot then this block will execute
	            System.out.println("Failure to take screenshot "+e);

	        }
	        finally
	        {
	            //Whatever happens with the screenshot, driver will quit.
	            driver.quit();
	        }
    }

	}


