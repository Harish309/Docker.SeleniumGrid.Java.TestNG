package dockerTests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FirefoxTest4
{
	@Test
	public void test4() throws MalformedURLException
	{
		WebDriver driver;
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("disable-infobars");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		driver.get("https://www.flipkart.com/");
		System.out.println("title :"+driver.getTitle());
		driver.quit();
	}
}
