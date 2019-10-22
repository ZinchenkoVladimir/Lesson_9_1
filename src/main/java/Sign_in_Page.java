import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

class Sign_in_Page {

    private static final String minuteinbox = "https://www.minuteinbox.com/";

    static String email;

    @FindBy(id = "email_create")
    private WebElement email_address_field_1;

    @FindBy(id = "SubmitCreate")
    private WebElement create_an_account_button_1;

    @FindBy(css = "a[class = 'btn btn-big cetc']")
    private WebElement copy_button;

    @FindBy(id = "email")
    private WebElement minutinbox_email;

    Sign_in_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    Sign_in_Page email_address_set() throws Exception {

        executeJavaScript("window.open()");
        switchTo().window(1);
        open(minuteinbox);
        email = $(minutinbox_email).getText();

        switchTo().window(0);
        $(email_address_field_1).waitUntil(enabled, 10000).setValue(email);
        return this;
    }

    void create_an_account_button_click() throws Exception {

        $(create_an_account_button_1).waitUntil(enabled, 10000).click();
    }
}
