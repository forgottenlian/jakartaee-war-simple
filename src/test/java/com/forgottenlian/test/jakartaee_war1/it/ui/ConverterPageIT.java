package com.forgottenlian.test.jakartaee_war1.it.ui;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UI")
class ConverterPageIT extends BaseUI {

    private static final String PAGE_TITLE = "h1:has-text('Main')";

    @Test
    @DisplayName("Page should load successfully")
    public void testPageLoads() {
        page.navigate(baseUrl + "/converter.jsf");
        assertTrue(page.locator(PAGE_TITLE).isVisible(), "Converter page should load");
    }
}
