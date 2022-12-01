package week4day2assigments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		List<WebElement> Column = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered')]//th"));
		List<WebElement> Row = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered')]//tr"));
		System.out.println("Number of Rows   in the Table: "+Column.size());
		System.out.println("Number of Column in the Table: "+Row.size());
		List<String> securityName = new ArrayList<String>();
		for (int i = 1; i < Row.size(); i++) {
			String text =driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]//tr["+i+"]//td[3]")).getText();
			securityName.add(text);
		}
		System.out.println("Total Number of Security Name: "+securityName.size());
		LinkedHashSet<String> securityNameDup = new LinkedHashSet<String>(securityName);
		System.out.println("Total Number of Security Name without Duplicate: "+securityNameDup.size());
		if(securityName.size()==securityNameDup.size()) {
			System.out.println("Security Name don't have Duplictes");	
		}else {
			System.out.println("Security Name have Duplictes");
		}
		driver.quit();
	}

	
	
	
	
	
	
}
