package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class HeaderItem extends AbstractUIObject {

    @FindBy(xpath = "//button[@class='lines-button minus focused']")
    private ExtendedWebElement menuButton;

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

    public HeaderItem(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuButtonPresent() {
        return menuButton.isElementPresent();
    }

    public boolean isSearchTextBoxPresent() {
        return searchTextBox.isElementPresent();
    }

    public boolean isTipsButtonPresent() {
        return tipsButton.isElementPresent();
    }

    public boolean isfacebookButtonPresent() {
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
}
