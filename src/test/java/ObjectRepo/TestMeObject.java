package ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TestMeObject {
	
	@FindBy(how=How.ID, using="userName")
	public static WebElement uname;
	
	@FindBy(how=How.ID, using="password")
	public static WebElement pass;
	
	@FindBy(how=How.NAME, using="Login")
	public static WebElement login;
	
	
	

}
