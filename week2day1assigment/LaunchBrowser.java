package week2.day1assigment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/main");
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 driver.findElement(By.className("decorativeSubmit")).click();
		 String title=driver.getTitle();
		 driver.findElement(By.linkText("crmsfa/control/main?externalLoginKey=EL9204973240")).click();
		 driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.linkText("Create Lead")).click();
		 driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Amazon");
		 driver.findElement(By.id("createLeadForm_firstName")).sendKeys("SUDHAN");
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys("VASAN");
	driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("CSE");
	driver.findElement(By.id("createLeadForm_description")).sendKeys("hello");
	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sudhan@150897@gmail.com");
	driver.findElement(By.className("smallSubmit")).click();
	System.out.println(driver.getTitle());
}

	}

