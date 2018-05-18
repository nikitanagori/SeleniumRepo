package ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObject {
	
	@FindBy(how=How.ID, using ="identifierId")
	public static WebElement uname;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Next')]")
	public static WebElement next;
	
	@FindBy(how=How.NAME, using="password")
	public static WebElement pass;
	

}
