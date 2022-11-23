package week4.day1assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("sudhan");
		driver.findElement(By.id("lastNameField")).sendKeys("vasan");
		driver.findElement(By.name("submitButton")).click();
		System.out.println("print First Name:sudhan");
		System.out.println("print last name:vasan");
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> fromname = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(fromname);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("sudhan");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		driver.switchTo().window(window.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> toname = driver.getWindowHandles();
		ArrayList<String> window1 = new ArrayList<String>(toname);
		driver.switchTo().window(window1.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("sudhan");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		driver.switchTo().window(window1.get(0));
		driver.findElement(By.linkText("Merge")).click();
		Alert alertmsg = driver.switchTo().alert();
		String text = alertmsg.getText();
		alertmsg.accept();
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
