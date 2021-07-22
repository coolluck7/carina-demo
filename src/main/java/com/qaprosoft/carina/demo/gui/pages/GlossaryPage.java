package com.qaprosoft.carina.demo.gui.pages;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.GlossaryItem;

public class GlossaryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='st-text']//p")
    private List<GlossaryItem> glossaryParagraphItems;

    @FindBy(xpath = "//div[@class='st-text']//h3")
    private List<GlossaryItem> glossaryParagraphNames;

    public GlossaryPage(WebDriver driver) {
        super(driver);
        setPageURL("/glossary.php3");
    }

    public boolean compareParagraphNamesWithParagraphItems() {
        boolean result = false;
        for (int i = 0; i < glossaryParagraphNames.size(); i++) {
            String link = glossaryParagraphItems.get(i).readLinkItemText();
            String symbol = glossaryParagraphNames.get(i).readSymbolItemText();
            String digit = String.valueOf(symbol.charAt(0));
            if (Character.isDigit(symbol.charAt(0))) {
                result = StringUtils.startsWithIgnoreCase(link, digit);
            } else if (StringUtils.startsWithIgnoreCase(link, symbol)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    public List<String> getParagraphByNumber(int elementNumber) {
        return glossaryParagraphItems.get(elementNumber).readListOfLinkItems();
    }

    public boolean isAlphabetCorrect() {
        List<String> list = getParagraphByNumber(1);
        List<String> tmpList = getParagraphByNumber(1);
        Collections.sort(tmpList);
        return list.equals(tmpList);
    }
}
