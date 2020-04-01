/**
 * @author aswani.kumar.avilal
 */

package skeleton;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemoWebShopObjects {

/**
 * this object will locate the ID of the email in the 
 */
@FindBy(how=How.ID,using="Email")	
public static	WebElement email;

@FindBy(how=How.ID,using="password")
public static	WebElement password;
/**
 * The login is the button in the Demo Web Shop Login page
 */
@FindBy(how=How.CSS,using="input[value='Log in']")
public static	WebElement login;

@FindBy(how=How.LINK_TEXT,using="Log out")
public static	WebElement logout;

}
