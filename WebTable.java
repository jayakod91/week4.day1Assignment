package week4.day1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/pages/table.html ");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ArrayList<Integer> list = new ArrayList<Integer>();
        WebElement elementTable = driver.findElement(By.id("table_id"));
        List<WebElement> listRows = elementTable.findElements(By.tagName("tr"));
        System.out.println("Total number of Rows :"+listRows.size());
        WebElement firstRow = listRows.get(1);
        int totalColumn = firstRow.findElements(By.tagName("td")).size();
        System.out.println("Total number of Columns :"+totalColumn);
            for(int i=0;i<listRows.size();i++) { 
        	WebElement currentRow = listRows.get(i); 
        	List<WebElement> listColumns = currentRow.findElements(By.tagName("td")); 
        	for(int j=0;j<listColumns.size();j++) {
	        	if(listColumns.get(j).getText().contains("Learn to interact with Elements")){
	        		System.out.println("Learn to interact with Elements Progress is :: "+listColumns.get(1).getText());
	         	}
	        	if(j == 1)
	        	{
	        		if(listColumns.get(j).getText().equals("30%"))
	        		{
                        driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();

	        		}
	        	}
        	}
        }




}


}    
