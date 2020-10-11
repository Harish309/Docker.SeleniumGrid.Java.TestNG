package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest2
{
	@Test
	public void test2() throws MalformedURLException 
	{
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		driver.get("https://www.google.com/");
		System.out.println("title :"+driver.getTitle());
		driver.quit();
	}
}
