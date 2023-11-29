package almousafer;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.google.common.hash.BloomFilter;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class almosap {
	String Url= "https://global.almosafer.com/en";
    WebDriver driver = new ChromeDriver();
	
	
	@BeforeTest
	public void Mypeforetest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get(Url);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/button[1]")).click();
	}
	
	@Test()
	public void Chackthelanguage() {
	
		
		String Thelang =driver.findElement(By.tagName("html")).getAttribute("lang");
	
		Assert.assertEquals(Thelang, "en","This is to test the lang");
	}
		
		@Test()
		public void Chackthecarrancy() {
			
			WebElement Carrancy = driver.findElement(By.className("fPnvOO"));
		String Thecarrancy = Carrancy.getText();
		
		Assert.assertEquals(Thecarrancy, "SAR","This to  chak the carrancy");
	}
	
		@Test()
		public void Checkthenumber() {
			WebElement Thenumber = driver.findElement(By.cssSelector("a[class='sc-hUfwpO cZBJLD'] strong"));
			String number =  Thenumber.getText();
			String Accualnumber = "+966554400000";
		Assert.assertEquals(number, Accualnumber);
			
			
		}
	@Test()
	public void CheckTheFooter() {
		WebElement theFooter= driver.findElement(By.tagName("Footer"));
		boolean IsQitafdispled = theFooter.findElement(By.xpath("//div[@class='sc-dznXNo iZejAw']//*[name()='svg']")).isDisplayed();
		Assert.assertEquals(IsQitafdispled, true);
	}
		@Test()
		public void CheckhotelIsNotSelected() {
			WebElement hotaltab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
			String Actualvalue = hotaltab.getAttribute("aria-selected");
			Assert.assertEquals(Actualvalue, "false");
		}
	@Test()
	public  void Changethelanguage()  {
		//List<WebElement> mylang = driver.findElements(By.tagName("img"));
		//System.out.println(mylang.size());
		String mywebsite [] = {"https://www.almosafer.com/ar","https://www.almosafer.com/en"};
		Random rand = new Random();
		int randomnumber  = rand.nextInt(mywebsite.length);
		driver.get(mywebsite[randomnumber]);
		String mywebsiturl = driver.getCurrentUrl();
		if(mywebsiturl.contains("ar")) {
			String Thelang =driver.findElement(By.tagName("html")).getAttribute("lang");
			
			Assert.assertEquals(Thelang, "ar","This is to test the lang");
		}
			else if (mywebsiturl.contains("en")) {
				String Thelang =driver.findElement(By.tagName("html")).getAttribute("lang");
		
		Assert.assertEquals(Thelang, "en","This is to test the lang");
			}
			} 
		
	
	
	@AfterTest
	public void Myaftertest() {}
	
	
	
	
	
	
}



