package tea.looca;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TODOSelimphore {
	//TO-DO https://sites.google.com/a/chromium.org/chromedriver/getting-started
	//TO-DO selenium-server-standalone-2.44.0.jar
	//TODO Overture
	//TODO Shake off

	public static void main(String[] args) throws InterruptedException {
		  // Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "/Users/zwang/Downloads/chromedriver");

		  WebDriver driver = new ChromeDriver();
		  //driver.get("http://www.google.com/xhtml");
		  //http://stackoverflow.com/questions/16215062/selenium-ide-local-non-webhosted-file-access-for-testing
		  driver.get("file:////Users/zwang/Desktop//background-comp6361-concordia.pdf");
		  //file///c:/path/to/your/file.html
		  //background-comp6361-concordia.pdf
		  
		  Thread.sleep(5000);  // Let the user actually see something!
		 // WebElement searchBox = driver.findElement(By.name("q"));
		  //searchBox.sendKeys("ChromeDriver");
		  //searchBox.submit();
		  Thread.sleep(5000);  // Let the user actually see something!
		  driver.quit();
	}

}
