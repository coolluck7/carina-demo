package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPopUp extends AbstractUIObject {

    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement userEmail;

    @FindBy(xpath = "//input[@id='upass']")
    private ExtendedWebElement userPassword;

    @FindBy(xpath = "//input[@id='nick-submit']")
    private ExtendedWebElement loginButton;

    public LoginPopUp(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPopUp(WebDriver driver) {
        super(driver);
    }

    public void useCredentials() {
        userEmail.type(R.TESTDATA.get("email"));
        userPassword.type(R.TESTDATA.get("password"));
    }

    public void clickLoginButton() {
        loginButton.click();
    }


}
