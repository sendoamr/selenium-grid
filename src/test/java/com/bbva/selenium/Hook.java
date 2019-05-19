package com.bbva.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Hook {

    @Test
    public void launchTest()  {
        App.launch();
    }

    @Before
    public void prepareTest() throws Exception {
        App.openDriver();
    }

    @After
    public void shutDown() {
        App.closeDriver();
    }

}
