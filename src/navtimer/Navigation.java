	package navtimer;


	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxProfile;
	import org.openqa.selenium.firefox.internal.ProfilesIni;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;


	public class Navigation {

	public static void main(String[] args) {
			
			 String transactionname;
			// Get profile
			 ProfilesIni profile = new ProfilesIni();  
			 FirefoxProfile ffprofile = profile.getProfile("default");
			 FirefoxDriver driver = new FirefoxDriver(ffprofile);
	
			 //long startTime = System.currentTimeMillis();
			 // Call the webpage or click on a particular link or form
			 driver.get("http://www.homedepot.com/");
			 new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Cart']")));
			 //long endTime = System.currentTimeMillis();
			 transactionname = "HomedepotApplicationlaunch";
			 timerOperation(driver, transactionname);
			 driver.get("http://www.lowes.com/");
			 transactionname = "LowesApplicationlaunch";
			 timerOperation(driver, transactionname);
			 
			//long totalTime = endTime - startTime;
			//System.out.println("System counter Load Time: " + totalTime + " milliseconds");
			
		}

	/**
	 * @param driver
	 */
	public static void timerOperation(FirefoxDriver driver,String transactionname) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Get the Load Event End 
		long loadEventEnd = (Long) js.executeScript("return window. performance.timing.loadEventEnd;");      // Get the Navigation Event Start
		long navigationStart = (Long) js.executeScript("return window. performance.timing.navigationStart;");      // Difference between Load Event End and Navigation Event Start is  // Page Load Time
		//System.out.println("Navigation start is " + (navigationStart) + " milli seconds.");
		//System.out.println("Load Event end is " + (loadEventEnd) + " milli seconds.");
		System.out.println( transactionname + " Load Time is " + (loadEventEnd - navigationStart) + " milli seconds.");
	}


	}

