package week4.day1.assginment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrame {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		
		//click me inside frame
		driver.findElement(By.xpath("//button[text()='Click Me'][1]")).click();
		String text = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
		System.out.println("click me inside frame : " + text);
		driver.switchTo().defaultContent();
		
		 //nested frame
		 WebElement frame = driver.findElement(By.xpath("//iframe[@src='default.xhtml']"));
	     driver.switchTo().frame(2);
	     driver.switchTo().frame("frame2");
	     WebElement nf = driver.findElement(By.xpath("//button[text()='Click Me']"));
		 nf.click();
		 String text1 = nf.getText();
		 System.out.println("Nested frame:" + text1);
		 
	}

}