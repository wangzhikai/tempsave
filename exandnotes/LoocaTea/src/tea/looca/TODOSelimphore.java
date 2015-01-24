package tea.looca;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TODOSelimphore {
	//TODO https://sites.google.com/a/chromium.org/chromedriver/getting-started
	
	//TODO selenium-server-standalone-2.44.0.jar

	public static void main(String[] args) throws InterruptedException {
		  // Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "/Users/zwang/Downloads/chromedriver");

		  WebDriver driver = new ChromeDriver();
		  driver.get("http://www.google.com/xhtml");
		  Thread.sleep(5000);  // Let the user actually see something!
		  WebElement searchBox = driver.findElement(By.name("q"));
		  searchBox.sendKeys("ChromeDriver");
		  searchBox.submit();
		  Thread.sleep(5000);  // Let the user actually see something!
		  driver.quit();
	}

}
