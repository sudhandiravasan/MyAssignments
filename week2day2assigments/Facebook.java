package week2.dayassigments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Sudhan"); 
		
		driver.findElement(By.name("lastname")).sendKeys("Vasan");
		
		driver.findElement(By.name("reg_email__")).sendKeys("vasan1997@gmail.com");
		
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("vasan1997@gmail.com");
		
		driver.findElement(By.name("reg_passwd__")).sendKeys("msdhoni007");

        WebElement dob1 = driver.findElement(By.id("day"));
				
		    Select drop1=new Select(dob1);
		    drop1.selectByValue("15");
		    
	    WebElement dob2 = driver.findElement(By.id("month"));
		    
	        Select drop2=new Select(dob2);
	        drop2.selectByValue("8");
		    
	    WebElement dob3 = driver.findElement(By.id("year"));
			 
            Select drop3=new Select(dob3);
            drop3.selectByValue("1997");
		    
        driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
        driver.findElement(By.name("websubmit")).click();
        
        	}

}
