package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class LoginPopUp extends AbstractUIObject {

    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement userEmailField;

    @FindBy(xpath = "//input[@id='upass']")
    private ExtendedWebElement userPasswordField;

    @FindBy(xpath = "//input[@id='nick-submit']")
    private ExtendedWebElement loginButton;

    public LoginPopUp(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPopUp(WebDriver driver) {
        super(driver);
    }

    public void loginViaCredentials() {
        userEmailField.type(R.TESTDATA.get("email"));
        userPasswordField.type(R.TESTDATA.get("password"));
        loginButton.click();
    }

    public boolean isUserEmailFieldPresent() {
        return userEmailField.isElementPresent();
    }

    public boolean isUserPasswordFieldPresent() {
        return userPasswordField.isElementPresent();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }
}
