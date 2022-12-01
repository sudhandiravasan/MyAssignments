package week4day2assigments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(brand).perform();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("(//a[contains(text(),'Paris')])[1]")).click();
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris")) {
			System.out.println("We are in L'Oreal Paris Page");
		}else {
			System.out.println("We are not in L'Oreal Paris Page");
		}
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		List<WebElement> filter = driver.findElements(By.xpath("//span[@class='filter-value']"));
		if(filter.size()>0) {
			System.out.println("Filter is Applied");
		}else {
			System.out.println("Filter is not Applied");
		}
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> arrayList1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(arrayList1.get(2));
		driver.findElement(By.xpath("//select[@title='SIZE']")).click();
		driver.findElement(By.xpath("//option[text()='175ml']")).click();
		String MRP = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']")).getText().replaceAll("[^0-9]", "");
		System.out.println("MRP: "+MRP);
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='body']")).getText());
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		driver.switchTo().frame(0);
		String GT = driver.findElement(By.xpath("//span[@class='css-n8gwxi e171rb9k3']")).getText().replaceAll("[^0-9]", "");;
		System.out.println("Grand Total: "+GT);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		String PD = driver.findElement(By.xpath("//p[@class='css-5t7v9l eka6zu20']")).getText().replaceAll("[^0-9]", "");;
		System.out.println("Price Details: "+PD);
		if(GT.contains(PD)) {
			System.out.println("Payment Amount is Correct");
		}else {
			System.out.println("Payment Amount is not Correct");
		}
		driver.quit();
	
	}

	
}
