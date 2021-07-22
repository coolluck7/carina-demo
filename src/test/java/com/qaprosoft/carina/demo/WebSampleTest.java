/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;


import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderItem;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs.SpecType;
import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.GlossaryPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.zebrunner.agent.core.annotation.TestLabel;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebSampleTest implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "default", value = {"web", "regression"})
    public void testModelSpecs() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValuePrivacyAd().closeAdIfPresent();
        homePage = new HomePage(getDriver());
        BrandModelsPage productsPage = homePage.selectBrand("Samsung");
        ModelInfoPage productInfoPage = productsPage.selectModel("Galaxy A52 5G");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readDisplay(), "6.5\"", "Invalid display info!");
        softAssert.assertEquals(productInfoPage.readCamera(), "64MP", "Invalid camera info!");
        softAssert.assertEquals(productInfoPage.readRam(), "6/8GB RAM", "Invalid ram info!");
        softAssert.assertEquals(productInfoPage.readBattery(), "4500mAh", "Invalid battery info!");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "default", value = {"web", "acceptance"})
    public void testCompareModels() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
        CompareModelsPage comparePage = footerMenu.openComparePage();
        List<ModelSpecs> specs = comparePage.compareModels("Samsung Galaxy J3", "Samsung Galaxy J5", "Samsung Galaxy J7 Pro");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(specs.get(0).readSpec(SpecType.ANNOUNCED), "2016, March 31. Released 2016, May 06");
        softAssert.assertEquals(specs.get(1).readSpec(SpecType.ANNOUNCED), "2015, June 19. Released 2015, July 28");
        softAssert.assertEquals(specs.get(2).readSpec(SpecType.ANNOUNCED), "2017, June");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "default", value = {"web", "acceptance"})
    public void testNewsSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
        final String searchQ = "iphone";
        List<NewsItem> news = newsPage.searchNews(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
        SoftAssert softAssert = new SoftAssert();
        for (NewsItem n : news) {
            System.out.println(n.readTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ),
                    "Invalid search results for " + n.readTitle());
        }
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "vsemak")
    @TestLabel(name = "task 1 - Verify Login page", value = {"web", "acceptance"})
    public void testVerifyLoginPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
    }

    @Test()
    @MethodOwner(owner = "vsemak")
    @TestLabel(name = "task 2 - Verify Sign Up button isn't active", value = {"web", "acceptance"})
    public void testVerifySignUpButton() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(homePage.getHeaderItem().isSignUpButtonPresent(), "Sign Up button isn't present!");
    }

    @Test()
    @MethodOwner(owner = "vsemak")
    @TestLabel(name = "task 4 - Verify header elements", value = {"web", "acceptance"})
    public void testVerifyHeaderElements() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        HeaderItem headerItem = new HeaderItem(getDriver());
        Assert.assertTrue(headerItem.isHamburgerMenuButtonPresent(), "Menu button not found!");
        Assert.assertTrue(headerItem.isSearchTextBoxPresent(), "Search text box not found!");
        Assert.assertTrue(headerItem.isTipsButtonPresent(), "Tips button not found!");
        Assert.assertTrue(headerItem.isFacebookButtonPresent(), "Facebook button not found!");
        Assert.assertTrue(headerItem.isTwitterButtonPresent(), "Twitter button not found!");
        Assert.assertTrue(headerItem.isInstagramButtonPresent(), "Instagram button not found!");
        Assert.assertTrue(headerItem.isYoutubeButtonPresent(), "Youtube button not found!");
        Assert.assertTrue(headerItem.isRssButtonPresent(), "RSS button not found!");
        Assert.assertTrue(headerItem.isLogInButtonPresent(), "Login button not found!");
        Assert.assertTrue(headerItem.isSignUpButtonPresent(), "Sign up button not found!");
    }

    @Test()
    @MethodOwner(owner = "vsemak")
    @TestLabel(name = "task 5 - Verify login feature", value = {"web", "acceptance"})
    public void testVerifyLoginFeature() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.login();
        pause(3);
        Assert.assertTrue(homePage.getHeaderItem().isUserIconButtonPresent(), "User icon is not found!");
    }

    @Test()
    @MethodOwner(owner = "vsemak")
    @TestLabel(name = "task 6 - Verify Article name", value = {"web", "acceptance"})
    public void testVerifyArticleName() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.login();
        homePage.openHamburgerMenu();
        NewsPage newsPage = homePage.clickNewsButton();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
        String expectedResult = newsPage.getArticleTitleByNumber(0);
        ArticlePage articlePage = newsPage.clickNewsArticleByNumber(0);
        String actualResult = articlePage.readTitle();
        Assert.assertEquals(expectedResult, actualResult, "Expected result is " + expectedResult + ", actual result is " + actualResult + ". Article name is not the same as its' name in the news column!");
    }

    @Test()
    @MethodOwner(owner = "vsemak")
    @TestLabel(name = "task 7 - Verify Searching process", value = {"web", "acceptance"})
    public void testVerifySearchingProcess() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.login();
        homePage.openHamburgerMenu();
        NewsPage newsPage = homePage.clickNewsButton();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
        String search = "xiaomi";
        List<NewsItem> news = newsPage.searchNews(search);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "No news found!");
        for (NewsItem newsItem : news) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(newsItem.readTitle(), search), "News have no searching word!");
        }
    }

    @Test()
    @MethodOwner(owner = "vsemak")
    @TestLabel(name = "task 8 - Verify Glossary paragraph header and text by first letter", value = {"web", "acceptance"})
    public void testVerifyGlossaryParagraphHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary page is not opened!");
        Assert.assertTrue(glossaryPage.compareParagraphNamesWithParagraphItems(), "Paragraph symbols don't compare to the text first letters!");
    }

    @Test()
    @MethodOwner(owner = "vsemak")
    @TestLabel(name = "task 9 - Verify Glossary paragraph text by alphabet", value = {"web", "acceptance"})
    public void testVerifyGlossaryParagraphTextByAlphabet() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary page is not opened!");
        Assert.assertTrue(glossaryPage.isAlphabetCorrect(), "Alphabet in the paragraph is incorrect!");
    }
}
