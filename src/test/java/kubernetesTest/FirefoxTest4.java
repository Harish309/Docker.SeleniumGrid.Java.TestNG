package kubernetesTest;

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
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:59195/wd/hub"), options);
		driver.get("https://www.flipkart.com/");
		System.out.println("title :"+driver.getTitle());
		driver.quit();
	}
}
