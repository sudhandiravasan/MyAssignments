package week4.day1assignments;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Windows {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// print active window/tab
		String windowHandle = driver.getWindowHandle();// ctrl+2+l
		System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		// click open
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		System.out.println(driver.getTitle());
		Set<String> wh1 = driver.getWindowHandles();
		ArrayList<String> arrayList1 = new ArrayList<String>(wh1);
		driver.switchTo().window(arrayList1.get(0));
		driver.close();
		driver.switchTo().window(arrayList1.get(1));
		System.out.println(driver.getTitle());
		// Find the Number of Opened Tabs
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		Set<String> wh2 = driver.getWindowHandles();
		System.out.println(wh2.size());
		// Close Window
		System.out.println("Close Window");
		driver.findElement(By.xpath("(//span[text()='Close Windows']")).click();
		Set<String> wh4 = driver.getWindowHandles();
		System.out.println(wh4.size());
		System.out.println(driver.getTitle());
	}
}
