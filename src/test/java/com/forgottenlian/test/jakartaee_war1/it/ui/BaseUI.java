package com.forgottenlian.test.jakartaee_war1.it.ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

abstract class BaseUI {

    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected String baseUrl = "http://localhost:8080/app1";

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void afterAll() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @BeforeEach
    void beforeEach() {
        context = browser.newContext();
        page = context.newPage();
        page.setDefaultTimeout(10000);
        page.setDefaultNavigationTimeout(10000);
    }

    @AfterEach
    void afterEach() {
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
    }

    protected String getPageUrl(String page) {
        return baseUrl + "/" + page;
    }
}
