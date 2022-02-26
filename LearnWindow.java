package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/window.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String StartingPage = driver.getWindowHandle();
		System.out.println(StartingPage);
		driver.findElement(By.id("home")).click();
		Set<String>windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		String secondWindow = list.get(1);
		driver.switchTo().window(secondWindow);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
	}

}
