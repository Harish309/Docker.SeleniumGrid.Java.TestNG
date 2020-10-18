package kubernetesTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetupKubeGrid {
	
	String oPUrl;

	@BeforeTest
	public void StartKubeGrid() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("cmd /c start StartMinukube.bat");
		Thread.sleep(10000);
		
		oPUrl = execCmd("cmd /c start GetHubURL.bat");

	}
	
	public static String execCmd(String cmd) {
	    String result = null;
	    try (InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
	            Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
	        result = s.hasNext() ? s.next() : null;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	@AfterTest
	public void StopKubeGrid() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("cmd /c start StopMinikube.bat");
		Thread.sleep(30000);
		
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe"); //closes the cmd prompt window
	}
}
