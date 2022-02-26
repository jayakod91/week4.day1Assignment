package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disapper {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/disapper.html");
		WebDriverWait expWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		expWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("button")));
		boolean Button = driver.findElement(By.xpath("//button[@id = 'button']")).isDisplayed();
		if (Button != true) {
			System.out.println("The button has Disappeared");
		} else {
			System.out.println("The button has not disappeared");
		}
		System.out.println(driver.findElement(By.tagName("strong")).getText());

	}
}

