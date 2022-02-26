package week4.day2;




import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SerivceNow {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://developer.service-now.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id ='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id ='password']")).sendKeys("Admin@123!");
		driver.findElement(By.xpath("//button[@id ='login']")).click();
		driver.findElement(By.xpath("//input[@id= 'filter']")).sendKeys("incident");
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Application is not working");
		String incNumber= driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident number is :: "+incNumber);
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>list=new ArrayList<String>(windowHandles);
		System.out.println("Current URL is :: "+ driver.getCurrentUrl());
		driver.switchTo().window(list.get(1)); 
		driver.findElement(By.linkText("Abel Tuter")).click();
		Thread.sleep(2000);
		driver.switchTo().window(list.get(0)) ;
		System.out.println( driver.getCurrentUrl());
		System.out.println(list.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incNumber);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String SearchIncNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println("In search incident number is :: "+SearchIncNumber);
		if(incNumber.equals(SearchIncNumber))
		{
			System.out.println("Incident num is created and verified successfully");
		}

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(2000);
        File source=driver.getScreenshotAs(OutputType.FILE);
        String imageFileName = "./src/main/resources/snapshot/"+incNumber+ ".png";
		File dest=new File(imageFileName);
		FileUtils.copyFile(source, dest);

	}

}
