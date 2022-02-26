package week4.day1;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		WebDriverWait expWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.tagName("button"));
		expWait.until(ExpectedConditions.textToBePresentInElement(element, "Click ME!"));
		String clickME = driver.findElement(By.tagName("button")).getText();
		System.out.println(clickME);
		driver.findElement(By.tagName("button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Text is ::" +alert.getText());
		alert.accept();
	}
	}
