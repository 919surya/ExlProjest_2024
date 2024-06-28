package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public int grnerateRandomNo(int boundNo) {
		Random rnd = new Random();
		int generateNo = rnd.nextInt(boundNo);
		return generateNo;
	}
	

	public void selectFromDropdown(WebElement element, String byValue) {
		Select sel = new Select(element);
		sel.selectByValue(byValue);

	}
}
