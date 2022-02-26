package week4.day1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shortable {

	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/pages/sorttable.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ArrayList<String> listNames = new ArrayList<String>();
        WebElement elementTable = driver.findElement(By.id("table_id"));
        List<WebElement> listRows = elementTable.findElements(By.tagName("tr"));
        for(int i=1;i<listRows.size();i++) {
        	WebElement currentRow = listRows.get(i); 
        	List<WebElement> listColumns = currentRow.findElements(By.tagName("td")); 
        	String name = listColumns.get(1).getText();
        	listNames.add(name);
        	
        }	


         Collections.sort(listNames);
         for (String eachName : listNames) {
    	 System.out.println(eachName);

      }
		driver.findElement(By.xpath("//th[text()='Name']")).click();
		ArrayList<String> sortNames = new ArrayList<String>();
		 WebElement elementTable1 = driver.findElement(By.id("table_id"));
	        List<WebElement> listRows1 = elementTable1.findElements(By.tagName("tr"));
		 for(int i=1;i<listRows1.size();i++) { 
	        	WebElement currentRow1 = listRows1.get(i); 
	        	List<WebElement> listColumns1 = currentRow1.findElements(By.tagName("td")); 
	        	String name = listColumns1.get(1).getText();
	        	sortNames.add(name);
	        	System.out.println(name);
	        }	

        if(listNames.equals(sortNames)) {
        	System.out.println("It is sorted");
        }else {
        	System.out.println("Not sorted");
        }
	}

}
