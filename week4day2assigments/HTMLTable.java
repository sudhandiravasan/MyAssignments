package week4day2assigments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> Column = driver.findElements(By.xpath("//table[contains(caption,'Most Popular')]//th"));
		List<WebElement> Row = driver.findElements(By.xpath("//table[contains(caption,'Most Popular')]//tr"));
		System.out.println("Table Name: The Three Most Popular JavaScript Libraries");
		System.out.println("Number of Rows   in the Table: " + Column.size());
		System.out.println("Number of Column in the Table: " + Row.size());
		List<WebElement> Column1 = driver.findElements(By.xpath("//table[@class='attributes-list']//th"));
		List<WebElement> Row1 = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
		System.out.println("Table Name: Attributes of Create An HTML Table Quickly & Easily With Our Code Example");
		System.out.println("Number of Rows   in the Table: " + Column1.size());
		System.out.println("Number of Column in the Table: " + Row1.size());
		driver.quit();
	}
}
