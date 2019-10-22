import org.jetbrains.annotations.TestOnly;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

class Create_an_account_Page {

    private String izya = "Izya";
    private String shniperson = "Shniperson";
    private String password = "100500";
    private String address = "вулиця Кирилівська, 103А";
    private String city = "Kyiv";
    private String postal_code = "04080";
    private String mobile_phone = "223322223322";

    @FindBy(id = "customer_firstname")
    private WebElement first_name_field_1;

    @FindBy(id = "customer_lastname")
    private WebElement last_name_field_1;

    @FindBy(id = "email")
    private WebElement email_address_field_2;

    @FindBy(id = "passwd")
    private WebElement password_field_1;

    @FindBy(id = "firstname")
    private WebElement first_name_field_2;

    @FindBy(id = "lastname")
    private WebElement last_name_field_2;

    @FindBy(id = "address1")
    private WebElement address_field_1;

    @FindBy(id = "city")
    private WebElement city_field_1;

    @FindBy(id = "postcode")
    private WebElement zip_postal_code_field_1;

    @FindBy(id = "phone_mobile")
    private WebElement mobile_phone_field_1;

    @FindBy(id = "alias")
    private WebElement address_alias_field_1;

    @FindBy(id = "submitAccount")
    private WebElement register_button_1;

    @FindBy(xpath = "(.//*[(.)='Create an account'])[1]/following::p[1]")
    private WebElement validation_message_1;

    Create_an_account_Page(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
    }

    Create_an_account_Page fill_account_form() throws Exception{

        $(first_name_field_1).waitUntil(enabled, 10000).setValue(izya);
        $(last_name_field_1).waitUntil(enabled, 10000).setValue(shniperson);
        $(email_address_field_2).waitUntil(enabled, 10000).shouldHave(value(Sign_in_Page.email));
        $(password_field_1).waitUntil(enabled, 10000).setValue(password);
        $(first_name_field_2).waitUntil(enabled, 10000).setValue(izya);
        $(last_name_field_2).waitUntil(enabled, 10000).setValue(shniperson);
        $(address_field_1).waitUntil(enabled, 10000).setValue(address);
        $(city_field_1).waitUntil(enabled, 10000).setValue(city);
        $(zip_postal_code_field_1).waitUntil(enabled, 10000).setValue(postal_code);
        $(mobile_phone_field_1).waitUntil(enabled, 10000).setValue(mobile_phone);
        $(address_alias_field_1).waitUntil(enabled, 10000).setValue(address);
        return this;
    }

    Create_an_account_Page register_button_click() throws Exception{

        $(register_button_1).waitUntil(enabled, 10000).click();
        return this;
    }

    void verify_validation_message() throws Exception{

        $(validation_message_1).waitUntil(enabled, 10000).shouldHave(text("There"), text("error"));
    }
}
