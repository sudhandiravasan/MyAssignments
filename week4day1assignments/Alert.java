package week4.day1assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().window().maximize();

		// simple Alert
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		org.openqa.selenium.Alert sa = driver.switchTo().alert();
		String text = sa.getText();
		System.out.println("simple Alert" + text);
		sa.accept();
		
		// confirm Alert
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		org.openqa.selenium.Alert ca = driver.switchTo().alert();
		String txt = sa.getText();
		System.out.println("confrim Alret" + txt);
		sa.accept();
		
		// promt alert
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
		org.openqa.selenium.Alert pa = driver.switchTo().alert();
		pa.sendKeys("Sudhan");
		pa.accept();
		
		// sweet Alert
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		String txtSw = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content']//p")).getText();
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		System.out.println("confirm sweet alert" + txtSw);
		
		// sweet alrt confirmation
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).click();
		String tsc = driver.findElement(By.className("ui-confirm-dialog-message")).getText();
		System.out.println("confirm Sweet Alert delete" + tsc);
		driver.findElement(By.xpath("//span[text()='Yes']")).click();

		// maximize and minimize
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();
		String max = driver.findElement(By.xpath("(//p[@class='m-0'])[2]")).getText();
		driver.findElement(By.xpath("(//a[@role='button'])[3]")).click();
		System.out.println("confirm max an min" + max);
		
		// sweet model dialog
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]")).click();
		String txtSm = driver.findElement(By.xpath("//p[@class='m-0']")).getText();
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		System.out.println(" Confirm Sweet Alert Modal" + txtSm);
		driver.close();

	}
}
