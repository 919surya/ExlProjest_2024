package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;		
	}
	
		
	@FindBy(how=How.XPATH,using="/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div")WebElement NEW_CUSTOMER_HEADER_ELEMENT;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"general_compnay\"]/div[1]/div/input")WebElement FULL_NAME_ELEMENT;
	@FindBy(how=How.XPATH,using="//*[@id=\"general_compnay\"]/div[2]/div/select")WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how=How.XPATH,using="//*[@id=\"general_compnay\"]/div[3]/div/input")WebElement EMAIL_ELEMENT;
	@FindBy(how=How.XPATH,using="//*[@id=\"phone\"]")WebElement PHONE_ELEMENT;//
	@FindBy(how=How.XPATH,using="//*[@id=\"general_compnay\"]/div[5]/div/input")WebElement ADDRESS_ELEMENT;//
	@FindBy(how=How.XPATH,using="//*[@id=\"general_compnay\"]/div[6]/div/input")WebElement CITY_ELEMENT;//
	@FindBy(how=How.XPATH,using="//*[@id=\"port\"]")WebElement ZIP_CODE_ELEMENT;//
	@FindBy(how=How.XPATH,using="//*[@id=\"general_compnay\"]/div[8]/div[1]/select")WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how=How.XPATH,using="//*[@id=\"customer_group\"]")WebElement GROUP_DROPDOWN_ELEMENT;
	@FindBy(how=How.XPATH,using="//*[@id=\"save_btn\"]")WebElement SAVE_BUTTON_ELEMENT;
	
	public void validateNewCustomer(String addCustomerHeader) {
	Assert.assertEquals(NEW_CUSTOMER_HEADER_ELEMENT.getText(), addCustomerHeader,"add Customer Header is not availiable");
	}
	
	public void insertFullName(String fullName) {
//		grnerateRandomNo(999);
		
		FULL_NAME_ELEMENT.sendKeys(fullName+grnerateRandomNo(999));			
	}
	
	public void selectCompany(String company) {		
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT,company);		
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(grnerateRandomNo(9999)+ email);	
	}
	
	public void insertPhone(String phone) {	
		PHONE_ELEMENT.sendKeys(phone+grnerateRandomNo(9999));
	}
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	public void insertZipCode(String zipCode) {
		ZIP_CODE_ELEMENT.sendKeys(zipCode);
	}
	
	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT,country);	
	}
	public void selectGroup(String group) {
		selectFromDropdown(GROUP_DROPDOWN_ELEMENT,group);	
	}
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}
	
	
	
	
}
