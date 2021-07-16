package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenuItem extends AbstractUIObject {

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'Home')]")
    private ExtendedWebElement homeButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'News')]")
    private ExtendedWebElement newsButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'Reviews')]")
    private ExtendedWebElement reviewsButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'Videos')]")
    private ExtendedWebElement videosButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'Featured')]")
    private ExtendedWebElement featuredButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'Phone Finder')]")
    private ExtendedWebElement phoneFinderButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'Deals')]")
    private ExtendedWebElement dealsButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'Tools')]")
    private ExtendedWebElement toolsButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'Coverage')]")
    private ExtendedWebElement coverageButton;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), 'Contact')]")
    private ExtendedWebElement contactButton;

    public HamburgerMenuItem(WebDriver driver) {
        super(driver);
    }

    public HamburgerMenuItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public NewsPage clickNewsButton() {
        newsButton.click();
        return new NewsPage(driver);
    }

    public boolean isHomeButtonPresent() {
        return homeButton.isElementPresent();
    }

    public boolean isNewsButtonPresent() {
        return newsButton.isElementPresent();
    }

    public boolean isReviewsButtonPresent() {
        return reviewsButton.isElementPresent();
    }

    public boolean isVideosButtonPresent() {
        return videosButton.isElementPresent();
    }

    public boolean isFeaturedButtonPresent() {
        return featuredButton.isElementPresent();
    }

    public boolean isPhoneFinderButtonPresent() {
        return phoneFinderButton.isElementPresent();
    }

    public boolean isDealsButtonPresent() {
        return dealsButton.isElementPresent();
    }

    public boolean isToolsButtonPresent() {
        return toolsButton.isElementPresent();
    }

    public boolean isCoverageButtonPresent() {
        return contactButton.isElementPresent();
    }

    public boolean isContactButtonPresent() {
        return contactButton.isElementPresent();
    }
}
