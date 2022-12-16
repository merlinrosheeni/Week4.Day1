package week4.day1.assginment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContant {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
		 driver.findElement(By.id("username")).sendKeys("DemoCSR");
			//Enter password
			 driver.findElement(By.id("password")).sendKeys("crmsfa");
			 //Click login button
			 driver.findElement(By.className("decorativeSubmit")).click();
			 //Click CRM/SFA
			 String title = driver.getTitle();
			 System.out.println(title);
			 driver.findElement(By.linkText("CRM/SFA")).click();
			 
				System.out.println(driver.getTitle());
				//Click Contact Tab
				driver.findElement(By.linkText("Contacts")).click();
				//Click Merge Contacts
				driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				//Click from contact widget
				driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
				String windowHandle = driver.getWindowHandle();
				System.out.println(windowHandle);
				System.out.println(driver.getTitle());
				
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> lstname=new ArrayList<String>(windowHandles);
				
				driver.switchTo().window(lstname.get(1));
				System.out.println(driver.getWindowHandle());
				System.out.println(driver.getTitle());
				//Click on first resulting contact
				
				driver.findElement(By.xpath("//a[@class='linktext']")).click();
			
				driver.switchTo().window(lstname.get(0));
				System.out.println(driver.getWindowHandle());
				System.out.println(driver.getTitle());
				
				//Click on Widget of To Contact
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
				Set<String> windowHandles1 = driver.getWindowHandles();
				List<String> lstname1=new ArrayList<String>(windowHandles1);
				
				driver.switchTo().window(lstname1.get(1));
				System.out.println(driver.getWindowHandle());
				System.out.println(driver.getTitle());
				
				//Click on Second Resulting Contact
				Thread.sleep(2000);
				//driver.findElement(By.xpath("(//a[@class='linktext'])[3]")).click();
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();

				driver.switchTo().window(lstname1.get(0));
				System.out.println(driver.getTitle());
				
				//Click Merge
				driver.findElement(By.linkText("Merge")).click();

				//handle alert
				Alert al = driver.switchTo().alert();
				String text = al.getText();
				System.out.println("Alert msg :"+text);
				
				al.accept();
				
				
				//Verify the title of the paga
				String verify = driver.getTitle();
				String verify1="View Contact | opentaps CRM";
				if(verify.equals(verify1))
				{
					System.out.println("Page is loaded");
				}
				
				
	}
}



