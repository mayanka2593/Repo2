


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class EventHandlingDemo {
	
	 WebDriver driver;
	@BeforeClass
	public  void Launch_Browser()
	{
		String driverPath = System.getProperty("user.dir")
				+"\\src\\BrowserDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/anoop/Downloads/template_7/alerts.html");
		
		/*String driverPath = System.getProperty("user.dir")
				+"\\src\\BrowserDriver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/anoop/Downloads/template_7/alerts.html");*/
	}
	
	@Test
	public void AlertHandling() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value='Alert Box']")).click();
		Alert alt=driver.switchTo().alert();
		String expmsg="This is a warning message";
		String actmsg=alt.getText();
		Thread.sleep(5000);
		alt.accept();
	}
	@Test
	public void ConfirmBox() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value='Confirm Box']")).click();
		Alert alt=driver.switchTo().alert();
		String expmsg="save your password";
		String actmsg=alt.getText();
		Thread.sleep(5000);
		alt.dismiss();
	}
	@Test
	public void PromptBox() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value='PromptBox']")).click();
		Alert alt=driver.switchTo().alert();
		String expmsg="This Page says";
		String actmsg=alt.getText();
		/*driver.findElement(By.id(id));*/
		Thread.sleep(5000);
		alt.getText();
		alt.accept();
		
	}
	
}
