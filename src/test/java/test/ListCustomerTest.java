package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomersPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class ListCustomerTest {
	

	WebDriver driver;
	
	ExcelReader exlRead=new ExcelReader("src\\main\\java\\testExcelData\\excelProject01.xlsx");
	String userName=exlRead.getCellData("LoginInfo","UserName",2);
	String password=exlRead.getCellData("LoginInfo", "Password", 2);
	
	String dashBoardPage=exlRead.getCellData("DataValidation", "HeaderDashboardPage", 2);
	
	String newCustomerPage=exlRead.getCellData("DataValidation", "HeaderNewCustomerPage", 2);
	
	String fullName=exlRead.getCellData("AddContactInfo", "FullName", 2);
	String companyName=exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email=exlRead.getCellData("AddContactInfo", "Email", 2);
	String phone=exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address=exlRead.getCellData("AddContactInfo", "Address", 2);
	String city=exlRead.getCellData("AddContactInfo", "City", 2);
	String zipcode=exlRead.getCellData("AddContactInfo", "ZipCode", 2);
	String country=exlRead.getCellData("AddContactInfo", "Country", 2);
	String group=exlRead.getCellData("AddContactInfo", "Group", 2);
	
    @Test
	public void userShouldBeAbleToOpenListCustomerPage()  {
    	

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashBoardPage);
		dashboardPage.clickCustomersPage();
		dashboardPage.clickAddCustomerPage();
		
		AddCustomerPage addCustomerPage=PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateNewCustomer(newCustomerPage);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(companyName);
		addCustomerPage.insertEmail(email);		
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertZipCode(zipcode);		
		addCustomerPage.selectCountry(country);		
		addCustomerPage.selectGroup(group);
		addCustomerPage.clickSaveButton();
		
		dashboardPage.clickListCustomersPage();
		
		
		ListCustomersPage listCustomer=PageFactory.initElements(driver, ListCustomersPage.class);
		listCustomer.validationOfCustomerListPage("Customer List");
		
//		listCustomer.validateInsrtedCustomer();

		listCustomer.validateInsrtedCustomerAndDelete();
		
    }
}
