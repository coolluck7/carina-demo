package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class ArticlePage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement pageTitle;

    public String readTitle() {
        return pageTitle.getElement().getText();
    }

    public ArticlePage(WebDriver driver) {
        super(driver);
    }
}
