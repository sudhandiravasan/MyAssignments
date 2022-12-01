package week4day2assigments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testleaftable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> Column = driver.findElements(By.xpath("//table//th"));
		List<WebElement> Row = driver.findElements(By.xpath("//table//tr"));
		System.out.println("Number of Rows   in the Table: "+Column.size());
		System.out.println("Number of Column in the Table: "+Row.size());
		String text = driver.findElement(By.xpath("//table//tr[3]//td[2]")).getText();
		System.out.println("Progress Value of 'Learn to interact with Elements': "+text);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		driver.quit();
	}
}
