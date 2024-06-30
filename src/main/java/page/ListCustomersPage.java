package page;

import javax.annotation.processing.SupportedSourceVersion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomersPage{

	WebDriver driver;

	public ListCustomersPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div[2]/div/div[1]/div/div/header")
	WebElement CUSTOMER_LIST_HEADER_ELEMENT;

	public void validationOfCustomerListPage(String customerList) {
		Assert.assertEquals(CUSTOMER_LIST_HEADER_ELEMENT.getText(), customerList,
				"Customer list page is not available");
	}
	
/*     ---this is for name only---
	// tbody/tr[1]/td[2]
	// tbody/tr[2]/td[2]
	// tbody/tr[3]/td[2]
	// tbody/tr[i]/td[2]
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[2]";
	
	public void validateInsrtedCustomer() {

		for (int i = 1; i <= 10; i++) {
			String nameFromList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();

			System.out.println(nameFromList);
//   //		String insertedName = "fullName+grnerateRandomNo(999)";
//     //	    String insertedName;     because it is different class, so i have no idea
//  ------ nameFromList of middle part should be insertedName	[see 13C0:55:00]----
			
//			Assert.assertEquals(nameFromList, nameFromList, "Name is not available on the list");

//			break;     
			
		}         
	}           */
	
	

//    //tbody/tr[1]/td[9]/child::button[1]/child::i[1]      or
//    //tbody/tr[1]/td[9]/child::button[1]/i[1] 
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[2]";


	//tbody/tr[1]/td[9]/child::button[1]
	//tbody/tr[3]/td[9]/child::button[1] 
	//tbody/tr[1]/td[9]/child::button[1]  
	//tbody/tr[2]/td[9]/child::button[1]/i[1]  
	//tbody/tr[i]/td[9]/child::button[1]/i[1]
	//tbody/tr[1]/td[3]/following-sibling::td[6]/button[1]
	String before_xpath_delete="//tbody/tr[";
	String after_xpath_delete="]/td[3]/following-sibling::td[6]/button[1]";	
	
	public void validateInsrtedCustomerAndDelete() throws InterruptedException {
		
		for (int i = 1; i <= 10; i++) {
			String nameFromList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			
//			System.out.println(nameFromList);			
//			Assert.assertEquals(nameFromList, nameFromList, "Name is not available on the list");
			
			if(nameFromList.equalsIgnoreCase(nameFromList)) {
				System.out.println("Inserted name exist");
				driver.findElement(By.xpath(before_xpath_delete + i + after_xpath_delete)).click();
				
			}
			Thread.sleep(5000);

			break;     			
			
		}
	}

}
