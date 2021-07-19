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
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HamburgerMenuItem;
import com.qaprosoft.carina.demo.gui.components.HeaderItem;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs.SpecType;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
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
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testModelSpecs() {
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        
        //Closing advertising if it's displayed
        homePage.getWeValuePrivacyAd().closeAdIfPresent();
        
        // Select phone brand
        homePage = new HomePage(getDriver());
        BrandModelsPage productsPage = homePage.selectBrand("Samsung");
        // Select phone model
        ModelInfoPage productInfoPage = productsPage.selectModel("Galaxy A52 5G");
        // Verify phone specifications
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readDisplay(), "6.5\"", "Invalid display info!");
        softAssert.assertEquals(productInfoPage.readCamera(), "64MP", "Invalid camera info!");
        softAssert.assertEquals(productInfoPage.readRam(), "6/8GB RAM", "Invalid ram info!");
        softAssert.assertEquals(productInfoPage.readBattery(), "4500mAh", "Invalid battery info!");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCompareModels() {
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        // Open model compare page
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
        CompareModelsPage comparePage = footerMenu.openComparePage();
        // Compare 3 models
        List<ModelSpecs> specs = comparePage.compareModels("Samsung Galaxy J3", "Samsung Galaxy J5", "Samsung Galaxy J7 Pro");
        // Verify model announced dates
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(specs.get(0).readSpec(SpecType.ANNOUNCED), "2016, March 31. Released 2016, May 06");
        softAssert.assertEquals(specs.get(1).readSpec(SpecType.ANNOUNCED), "2015, June 19. Released 2015, July 28");
        softAssert.assertEquals(specs.get(2).readSpec(SpecType.ANNOUNCED), "2017, June");
        softAssert.assertAll();
    }
    
    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
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
        for(NewsItem n : news) {
            System.out.println(n.readTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ),
                    "Invalid search results for " + n.readTitle());
        }
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P6)
    @TestLabel(name = "Task 2, 4", value = {"web", "acceptance"})
    public void testHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        HeaderItem headerItem = homePage.getHeaderItem();

        Assert.assertTrue(headerItem.isMenuButtonPresent(), "Menu button not found!");
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
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P6)
    @TestLabel(name = "Task 5", value = {"web", "acceptance"})
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        HeaderItem headerItem = homePage.getHeaderItem();
        Assert.assertTrue(headerItem.isUIObjectPresent(), "Header not found!");
        headerItem.clickLogInButton();
        homePage.getLoginPopUp().loginViaCredentials();
        Assert.assertTrue(headerItem.isUserIconButtonPresent(), "User icon button not found!");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P6)
    @TestLabel(name = "Task 6", value = {"web", "acceptance"})
    public void testArticle() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        HeaderItem headerItem = homePage.getHeaderItem();
        Assert.assertTrue(headerItem.isUIObjectPresent(), "Header not found!");
        headerItem.clickMenuButton();

        NewsPage newsPage = homePage.clickNewsButton();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
        final String search = "xiaomi";
        List<NewsItem> news = newsPage.searchNews(search);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "No news found!");
        for (NewsItem item : news) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(item.readTitle(), search), "News invalid!");
        }
    }
}
