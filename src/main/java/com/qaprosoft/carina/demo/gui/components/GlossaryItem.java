package com.qaprosoft.carina.demo.gui.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class GlossaryItem extends AbstractUIObject {

    @FindBy(xpath = "./a")
    private ExtendedWebElement linkItem;

    @FindBy(xpath = "./a")
    private List<ExtendedWebElement> linkItems;

    @FindBy(xpath = ".")
    private ExtendedWebElement symbolItem;

    public String readLinkItemText() {
        return linkItem.getElement().getText();
    }

    public String readSymbolItemText() {
        return symbolItem.getElement().getText();
    }

    public List<String> readListOfLinkItems() {
        List<String> linkText = new ArrayList<>();
        for (ExtendedWebElement item : linkItems) {
            linkText.add(item.getText().toLowerCase(Locale.ROOT));
        }
        return linkText;
    }

    public GlossaryItem(WebDriver driver) {
        super(driver);
    }

    public GlossaryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
