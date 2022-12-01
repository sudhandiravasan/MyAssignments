package week4day2assigments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLLibrary {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> Column = driver.findElements(By.xpath("//table[contains(caption,'Most Popular')]//th"));
		List<WebElement> Row = driver.findElements(By.xpath("//table[contains(caption,'Most Popular')]//tr"));
		for (int i = 1; i < Row.size()-1; i++) {
			for (int j = 1; j <= Column.size(); j++) {
				String a = driver.findElement(By.xpath("//table[contains(caption,'Most Popular')]//tr//th["+j+"]")).getText();
				String b = driver.findElement(By.xpath("//table[contains(caption,'Most Popular')]//tr["+i+"]//td["+j+"]")).getText();
				System.out.println(a+" "+b);
			}		
		}
		driver.quit();
	}
	
}
