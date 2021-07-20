package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class TemporaryPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//meta[@property='og:url']")
    private ExtendedWebElement pageURL;

    // to check(!!)
    public String readPageURL() {
        return pageURL.getElement().getText();
    }

    public String readTitle() {
        return pageTitle.getElement().getText();
    }

    public TemporaryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(readPageURL());
    }
}
