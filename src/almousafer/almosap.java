package almousafer;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.google.common.hash.BloomFilter;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class almosap {
	String Url= "https://global.almosafer.com/en";
    WebDriver driver = new ChromeDriver();
	
	SoftAssert Myassaration = new SoftAssert();
	@BeforeTest
	public void Mypeforetest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get(Url);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/button[1]")).click();
	}
	
	@Test(enabled = false)
	public void Chackthelanguage() {
	
		
		String Thelang =driver.findElement(By.tagName("html")).getAttribute("lang");
	
		Assert.assertEquals(Thelang, "en","This is to test the lang");
	}
		
		@Test(enabled = false)
		public void Chackthecarrancy() {
			
			WebElement Carrancy = driver.findElement(By.className("fPnvOO"));
		String Thecarrancy = Carrancy.getText();
		
		Assert.assertEquals(Thecarrancy, "SAR","This to  chak the carrancy");
	}
	
		@Test(enabled = false)
		public void Checkthenumber() {
			WebElement Thenumber = driver.findElement(By.cssSelector("a[class='sc-hUfwpO cZBJLD'] strong"));
			String number =  Thenumber.getText();
			String Accualnumber = "+966554400000";
		Assert.assertEquals(number, Accualnumber);
			
			
		}
	@Test(enabled = false)
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
	@Test(enabled = false)
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
		
	@Test(enabled = false)
	public void CheckTheDateOfTheWebSite() {
		LocalDate Today = LocalDate.now();
		int expectedDepatureDate= Today.plusDays(1).getDayOfMonth();
		int expectedReturnDate = Today.plusDays(2).getDayOfMonth();
		
		 WebElement ActualDepatureDateOnTheWebSite =driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"));
		WebElement ActualreturnDateOnTheWebSitee = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"));
		String expectedwelcomemsg ="Let’s book your next trip!";
		  String Actualwelcomemsg =driver.findElement(By.xpath("//h1[contains(text(),'Let’s book your next trip!')]")).getText();
		 Myassaration.assertEquals(Integer.parseInt(ActualDepatureDateOnTheWebSite.getText()),700,"this is to return" );
		 Myassaration.assertEquals(Integer.parseInt(ActualreturnDateOnTheWebSitee.getText()), 400,"we aer chak the welcome msg");
		 Myassaration.assertEquals(Integer.parseInt(ActualDepatureDateOnTheWebSite.getText()),67);
		 Myassaration.assertAll();
	}
	
	
	@Test()
	
	public void HotelTabSwitch() {
		Random rand = new Random();
		String [] arabiccitise = {"دبي","جده"};
		String [] englishcites = {"dubai","jeddah","riyadh"};
		int randomarbiccitise = rand.nextInt(arabiccitise.length);
		int randomenglishcites = rand.nextInt(englishcites.length);
	String mywebsite [] = {"https://www.almosafer.com/ar","https://www.almosafer.com/en"};


	int randomnumber  = rand.nextInt(mywebsite.length);
	driver.get(mywebsite[randomnumber]);
	
	WebElement HotalTabe = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	HotalTabe.click();
	
	
	  if(driver.getCurrentUrl().contains("ar")){

		
			WebElement Serachabouthotal =driver.findElement(By.xpath("(//input[@placeholder='البحث عن فنادق أو وجهات'])[1]"));
			
	  Serachabouthotal.sendKeys(arabiccitise[randomarbiccitise]+Keys.ENTER);
	driver.findElement(By.xpath("(//button[@class='sc-jTzLTM hQpNle sc-1vkdpp9-6 iKBWgG js-HotelSearchBox__SearchButton btn btn-primary btn-block'])[1]")).click();
	
	WebElement Myselectelemant = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
	Select selector = new Select(Myselectelemant);
	String resultfound= driver.findElement( By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']")).getText();
	Assert.assertEquals(resultfound.contains("وجدنا"), true);

	}
	  else{
		  WebElement Serachabouthotal1 =driver.findElement(By.xpath("(//input[@placeholder='Search for hotels or places'])"));
		  Serachabouthotal1.sendKeys(englishcites[randomenglishcites]+Keys.ENTER);
		  driver.findElement(By.xpath("(//button[@class='sc-jTzLTM hQpNle sc-1vkdpp9-6 iKBWgG js-HotelSearchBox__SearchButton btn btn-primary btn-block'])[1]")).click();
		  WebElement Myselectelemant = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
			Select selector = new Select(Myselectelemant);
			selector.selectByIndex(rand.nextInt(2));
			String resultfound= driver.findElement( By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']")).getText();
			Assert.assertEquals(resultfound.contains("found"), true);
		}
	  }

	@AfterTest
	public void Myaftertest() {}
	
	
	
	
	
	
}



