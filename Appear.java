package week4.day1;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/appear.html");
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button")));
		boolean ButtonAppeared = driver.findElement(By.id("button")).isDisplayed();
		if (ButtonAppeared == true) {
			System.out.println("The button has appeared");
		} else {
			System.out.println("The button has not appeared");
		}
		String Buttontext = driver.findElement(By.id("button")).getText();
		System.out.println("The button text is " +Buttontext);

	}

}
