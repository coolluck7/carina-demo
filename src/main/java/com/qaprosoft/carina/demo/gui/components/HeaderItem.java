package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class HeaderItem extends AbstractUIObject {

    @FindBy(xpath = "//button[@class='lines-button minus focused']")
    private ExtendedWebElement hamburgerMenuButton;

    @FindBy(xpath = "//input[@name='sSearch']")
    private ExtendedWebElement searchTextBox;

    @FindBy(xpath = "//i[@class='head-icon icon-tip-us icomoon-liga']")
    private ExtendedWebElement tipsButton;

    @FindBy(xpath = "//i[@class='head-icon icon-soc-fb2 icomoon-liga']")
    private ExtendedWebElement facebookButton;

    @FindBy(xpath = "//i[@class='head-icon icon-soc-twitter2 icomoon-liga']")
    private ExtendedWebElement twitterButton;

    @FindBy(xpath = "//i[@class='head-icon icon-instagram icomoon-liga']")
    private ExtendedWebElement instagramButton;

    @FindBy(xpath = "//i[@class='head-icon icon-soc-youtube icomoon-liga']")
    private ExtendedWebElement youtubeButton;

    @FindBy(xpath = "//i[@class='head-icon icon-soc-rss2 icomoon-liga']")
    private ExtendedWebElement RssButton;

    @FindBy(xpath = "//a[@id='login-active']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//a[@class='signup-icon no-margin-right']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//i[@class='head-icon icon-user']")
    private ExtendedWebElement userIconButton;

    @FindBy(xpath = "//i[@class='head-icon icon-signout']")
    private ExtendedWebElement logOutButton;

    public HeaderItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HeaderItem(WebDriver driver) {
        super(driver);
    }

    public void clickLogInButton() {
        logInButton.click();
    }

    public void clickHamburgerMenuButton() {
        hamburgerMenuButton.click();
    }

    public boolean isHamburgerMenuButtonPresent() {
        return hamburgerMenuButton.isElementPresent();
    }

    public boolean isSearchTextBoxPresent() {
        return searchTextBox.isElementPresent();
    }

    public boolean isTipsButtonPresent() {
        return tipsButton.isElementPresent();
    }

    public boolean isFacebookButtonPresent() {
        return facebookButton.isElementPresent();
    }

    public boolean isTwitterButtonPresent() {
        return twitterButton.isElementPresent();
    }

    public boolean isInstagramButtonPresent() {
        return instagramButton.isElementPresent();
    }

    public boolean isYoutubeButtonPresent() {
        return youtubeButton.isElementPresent();
    }

    public boolean isRssButtonPresent() {
        return RssButton.isElementPresent();
    }

    public boolean isLogInButtonPresent() {
        return logInButton.isElementPresent();
    }

    public boolean isSignUpButtonPresent() {
        return signUpButton.isElementPresent();
    }

    public boolean isUserIconButtonPresent() {
        return userIconButton.isElementPresent();
    }

    public boolean isLogOutButtonPresent() {
        return logOutButton.isElementPresent();
    }
}
