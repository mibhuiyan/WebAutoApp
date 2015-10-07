
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;

public class TestAuto{

WebDriver _driver, _driver2;
String resFile="/Users/mbhuiyan/Documents/Selenium/Workspace/WebAuto/Report/Report.csv";

FileWriter writer;
@Before
public void setUp() throws IOException{
   System.setProperty("webdriver.chrome.driver", "/Users/mbhuiyan/Documents/Selenium/ChormeDriver/chromedriver");
  _driver=new ChromeDriver();
  writer = new FileWriter(resFile);
  writer.append("TCNO,Test Case,Result\n");
}

@Test
public void BrowserOpen() throws InterruptedException, IOException{

    String baseUrl = "http://auto.iheart.com/beta/";
    String SecUrl = "http://www.iheart.com/activate/";
      
   try{  
      writer.append(",Browser Open==============,\n"); 
    
	  OpenUrl(_driver, baseUrl);
	  writer.append("TC00,Open Browser,Pass\n");  
      
      }
   catch(Exception e){
		  String msg=e.getMessage();
		  writer.append(",Test Execution, Fail\n"); 
		  writer.append(",Test  End==============,\n");
		  writer.append("\n\n\n************************** Error Description ***************************\n"+msg);
	  } 
	 
   
   try{  
	      writer.append(",Terms & Condition==============,\n"); 
	 _driver.switchTo().defaultContent();
	 _driver.switchTo().frame(_driver.findElement(By.xpath("//frame[@src='http://auto.iheart.com/auto/2014122314207/api2/index.html']")));
	 _driver.switchTo().frame(_driver.findElement(By.xpath("//iframe[@id='screen']")));
	 
	   
	  	ClickById(_driver,"agree-eula");
	Thread.sleep(500);
		ClickById(_driver,"agree-privacy");
	Thread.sleep(500);
		ClickById(_driver,"agree-data");
	Thread.sleep(500);
		ClickById(_driver,"agree-location");
	Thread.sleep(2000);
		ClickById(_driver,"legalContinueButton");
	Thread.sleep(2000);
		writer.append("TC01,Select 'I Agree' and click on continue,Pass\n"); 
    
       }
   catch(Exception e){
		  String msg=e.getMessage();
		  writer.append(",Test Execution, Fail\n"); 
		  writer.append(",Test  End==============,\n");
		  writer.append("\n\n\n************************** Error Description ***************************\n"+msg);
	  } 
	
   
   
   try{  
	      writer.append(",Anonymouse user + Live Station==============,\n"); 
	      
		ClickById(_driver,"login-prompt-maybe-button"); 
	Thread.sleep(5000);
		ClickById(_driver,"tnNowPlaying"); 
	Thread.sleep(10000);
		ClickById(_driver,"livescanbutton"); //SCAN
	Thread.sleep(5000);
		ClickById(_driver,"livescanbutton");
	Thread.sleep(2000);
		ClickById(_driver,"favorites"); 
	Thread.sleep(3000);
		writer.append("TC02,Anonymouse user + Live Station,Pass\n");	
   }
   catch(Exception e){
		  String msg=e.getMessage();
		  writer.append(",Test Execution, Fail\n"); 
		  writer.append(",Test  End==============,\n");
		  writer.append("\n\n\n************************** Error Description ***************************\n"+msg);
	  } 
		
		
		
		ClickByXpath(_driver,"//*[@id='modal']/div[4]/a[1]"); 
	Thread.sleep(2000);
		ClickById(_driver,"login-prompt-signup-button");
	Thread.sleep(3000);
		String activeCode= GetTextAttById(_driver,"activationcode");			 	 
	Thread.sleep(2000);
		
	System.out.println(_driver.getTitle());
	System.out.println("this is activation code:"+activeCode);
	
	 
	_driver2 =new ChromeDriver();
	OpenUrl(_driver2, SecUrl);
	System.out.println(_driver2.getTitle());
	
	Thread.sleep(3000);
		ClickByLinkText(_driver2, "Sign up");
	Thread.sleep(2000);
		EnterTextByName(_driver2,"userName",CreateEmail());
	Thread.sleep(500);
		EnterTextByName(_driver2,"password","abcd1234");
	Thread.sleep(500);
		EnterTextByName(_driver2,"zipCode","11218");
	Thread.sleep(500);
		_driver2.findElement(By.name("birthYear")).sendKeys("1980");
	Thread.sleep(500);
		ClickByName(_driver2,"gender");
	Thread.sleep(500);
		ClickByName(_driver2,"termsAcceptanceDate");
	Thread.sleep(2000);
		ClickByXpath(_driver2,"//button[@type='submit']");	
	Thread.sleep(4000);
		EnterTextByName(_driver2,"code",activeCode);
	Thread.sleep(3000);
		ClickByXpath(_driver2,"//button[@type='submit']");
	Thread.sleep(1000); // PASS
	_driver2.close();
	writer.append("TC03,Sign In...,Pass\n");
	
	//Activation Process Done here
	
	
	
	Thread.sleep(4000);
	 	ClickByXpath(_driver,"//*[@id='modal']/div[4]/a"); 
	Thread.sleep(4000);
	    ClickByXpath(_driver,"//*[@id='modal']/div[3]/a"); 
	Thread.sleep(1000);     //Station Saved
	
	
	
		ClickById(_driver,"livescanbutton"); 
	Thread.sleep(4000);
		ClickById(_driver,"livescanbutton"); 
	Thread.sleep(4000);
		ClickById(_driver,"createlivestation"); 
	Thread.sleep(1000);
		ClickById(_driver,"play_new_station_button"); 
	Thread.sleep(1000);
		
	// Create Station done
	
		ClickById(_driver,"tnHome"); 
	Thread.sleep(2000);
		ClickById(_driver,"create-station"); 
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='streamList']/li[1]/a[2]");
	Thread.sleep(2000);
		ClickById(_driver,"nonswipe-right"); 
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='streamList']/li[5]/a"); 
	Thread.sleep(2000);
		ClickById(_driver,"skipbutton"); 
	Thread.sleep(2000);
	//ClickById(_driver,"thumbupordown"); //Click thumbs up/down button
	//Thread.sleep(100);
	//ClickByXpath(_driver,"//*[@id='modal']/div[1]/strong"); // 
	//Thread.sleep(100);
	//ClickById(_driver,""); //Click continue button on modal
	//Thread.sleep(200);
	//ClickById(_driver,"thumbupordown"); //Click thumbs up/down button
	//Thread.sleep(200);
	//ClickById(_driver,""); //Click thumbs down button 
	writer.append("TC004,Custom music,Pass\n");
	
	
	
		ClickById(_driver,"tnHome"); 
	Thread.sleep(2000);
		ClickById(_driver,"custom-talk"); 
	Thread.sleep(2000);
		ClickById(_driver,"nonswipe-right");
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='streamList']/li[8]/a"); 
	Thread.sleep(2000);
		ClickById(_driver,"nonswipe-right");
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='streamList']/li[8]/a/div[2]"); 
	Thread.sleep(2000);
		ClickById(_driver,"skipbutton");
	Thread.sleep(20000);
		ClickById(_driver,"favorites"); 
	Thread.sleep(2000);
		writer.append("TC005,Custom talk,Pass\n");
	
	
		ClickById(_driver,"tnHome"); 
	Thread.sleep(2000);
		ClickById(_driver,"tnSettings"); 
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='streamList']/li[2]/a");
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='settings-actBtns']/li[1]/a"); 
	Thread.sleep(2000);
		ClickById(_driver,"log_out"); 
	Thread.sleep(2000);
		ClickById(_driver,"tnNowPlaying"); 
	Thread.sleep(3000);
		writer.append("TC006,Log out,Pass\n");
	
	
	
		ClickById(_driver,"tnHome"); 
	Thread.sleep(2000);
		ClickById(_driver,"tnSettings"); 
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='streamList']/li[2]/a"); 
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='settings-actBtns']/li[1]/a"); 
	Thread.sleep(2000);
		ClickById(_driver,"login-prompt-login-button");
	Thread.sleep(1000);
		EnterTextByName(_driver,"email","test771@me.com");
	Thread.sleep(500);
		EnterTextByName(_driver,"password","test");
	Thread.sleep(500);
		ClickById(_driver,"login-button");
	Thread.sleep(2000);
		ClickById(_driver,"tnNowPlaying"); 
	Thread.sleep(2000);
		writer.append("TC007,Log in,Pass\n");
	
	
		ClickById(_driver,"tnHome"); 
	Thread.sleep(2000);
		ClickById(_driver,"tnFavorites"); 
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='favoriteList']/li[3]/a[2]");
	Thread.sleep(2000);
		ClickById(_driver,"favorites"); 
	Thread.sleep(2000);
		ClickById(_driver,"tnQuit"); 
	Thread.sleep(2000);
		ClickByXpath(_driver,"//*[@id='modal']/div[3]/a[1]"); 
	Thread.sleep(4000);
	System.out.println(_driver.getTitle());
	
	try{  
	      writer.append(",Browser Close==============,\n"); 
	_driver.close();
	writer.append(",Browser Close==============,\n"); 
	
  } catch(Exception e){
	  String msg=e.getMessage();
	  writer.append(",Test Test Execution, Fail\n"); 
	  writer.append(",Test  End==============,\n");
	  writer.append("\n\n\n************************** Error Description ***************************\n"+msg);
  } 
	
      
}

@After
public void tearDown() throws InterruptedException, IOException{
	writer.flush();
    writer.close();
}

public void OpenUrl(WebDriver WD, String vUrl){
	 WD.get(vUrl);
     WD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 WD.manage().window().maximize();
}

public void ClickById (WebDriver WD, String iD){
	WD.findElement(By.id(iD)).click();
}

public void ClickByLinkText (WebDriver WD, String lInkText){
	WD.findElement(By.linkText(lInkText)).click();
}

public void EnterTextByName(WebDriver WD, String eleName, String eText){
	WD.findElement(By.name(eleName)).clear();
	WD.findElement(By.name(eleName)).sendKeys(eText);
}

public void ClickAndWaitByXpath(WebDriver WD, String xPath, Long wTime) throws Exception{
	WD.findElement(By.xpath(xPath)).click();
	Thread.sleep(wTime);
}

public void ClickByXpath(WebDriver WD, String xPath){
	WD.findElement(By.xpath(xPath)).click();
}

public void ClickByName(WebDriver WD, String nAme){
	WD.findElement(By.name(nAme)).click();
}

public String GetTextAttByXpath(WebDriver WD, String xPath){	
	return WD.findElement(By.xpath(xPath)).getAttribute("value");
}

public String GetTextAttById(WebDriver WD, String iD){	
	return WD.findElement(By.id(iD)).getAttribute("value");
}

public String CreateEmail(){	
	Random rand = new Random();
	String mEmail;
	int  n = rand.nextInt(1000) + 1;
	mEmail="webauto"+String.valueOf(n)+"@maillinator.com";
	return mEmail;
}

public Boolean IsTextPresent(WebDriver WD, String textToVerify){
	try{ 
			if (WD.findElement(By.xpath(textToVerify)) != null){
				return true;
			}
	   } catch (Exception e){
	       return false;
	   }
	
	return false;
	}

}