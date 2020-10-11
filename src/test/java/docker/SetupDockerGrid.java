package docker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetupDockerGrid {
	
	@BeforeTest
	public void StartDockerGrid() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("cmd /c start Start_DockerGrid.bat");
		Thread.sleep(30000);//Need time for complete to start Docker
	}
	
	@AfterTest
	public void StopDockerGrid() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("cmd /c start Stop_DockerGrid.bat");
		Thread.sleep(30000);//Need time for complete to stop Docker
		
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe"); //closes the cmd prompt window
	}
}
