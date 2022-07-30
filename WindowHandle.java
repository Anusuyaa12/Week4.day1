package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WindowHandle {

		/*Assignment 1:
			===============
			Window Handling:
			1.https://github.com/TestLeafPages/SeleniumAssignments/blob/master/week3/day2/Assignments/MergeContact.java

			2.http://www.leafground.com/pages/Window.html

			3.Assignment for WindowHandles  
			Salesforce Customer service:
			1.Launch the browser
			2.Load the url as " https://login.salesforce.com/ "
			3.Enter the username as " ramkumar.ramaiah@testleaf.com "
			4. Enter the password as " Password$123 "
			5.click on the login button
			6.click on the learn more option in the Mobile publisher
			7.Switch to the next window using Windowhandles.
			8.click on the confirm button in the redirecting page
			9.Get the title
			10.Get back to the parent window
			11.close the browser*/
		
		
		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();

			// launch the browser
			ChromeDriver driver=new ChromeDriver();

			//Launching the URL
			driver.get("https://login.salesforce.com/");

			//Maximize the drive
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
			
			driver.findElement(By.id("password")).sendKeys("Password$123");
			
			driver.findElement(By.id("Login")).click();
			
			driver.findElement(By.xpath("//span[text()='Learn More']")).click();
			
			Set<String> windowhandle=driver.getWindowHandles();

			List<String> list=new ArrayList<String>(windowhandle);

			String second=list.get(1);

			driver.switchTo().window(second);
			
			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			
			System.out.println(driver.getTitle());
			
			driver.close();
			
			driver.quit();
			
		}

	}
