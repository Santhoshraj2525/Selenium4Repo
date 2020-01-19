package Selenium4Demo;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElemnentTakingScreenshotFeature {

	@Test
	public static void WebElementScreenShot() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		
		WebElement emailAddress = driver.findElement(By.xpath("//span[text()='Enter Email/Mobile number']/../preceding-sibling::input"));
		WebElement password = driver.findElement(By.xpath("//span[text()='Enter Password']/../preceding-sibling::input"));
		WebElement login = driver.findElement(By.xpath("//button/span[text()='Login']"));
		takeScreenShot(emailAddress, "EmailAddress");
		takeScreenShot(password, "Password");
		takeScreenShot(login, "LoginButton");
		driver.quit();
		
	}
	
	public static void takeScreenShot(WebElement element, String image) throws IOException {
		File src = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshot/"+image+".png"));
	}

}
