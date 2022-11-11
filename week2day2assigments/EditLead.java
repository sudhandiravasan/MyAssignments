package week2.dayassigments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Find Leads")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("SUDHAN");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.linkText("sudhanvasan")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Edit")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("SSEW");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());

	}

}
