package com.bbva.selenium;

import com.bbva.selenium.driver.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class TestRunnable implements Runnable {

    private final String navegador;

    public TestRunnable(final String nav) {
        navegador = nav;
    }

    @Override
    public void run() {
        final long startTime = System.currentTimeMillis();
        WebDriver driver = null;
        try {
            driver = DriverUtil.getDriver(navegador);
        } catch (final MalformedURLException e) {
            System.err.println("Invalid url");
        }
        driver.get("https://www.bbvanexttechnologies.com/");
        final WebElement btnContact = driver.findElement(By.cssSelector("a[data-default-url='#collapse4']"));
        btnContact.click();
        final WebElement h1Contacto = driver.findElement(By.cssSelector("h1"));
        if (h1Contacto.isDisplayed() && h1Contacto.getText().equalsIgnoreCase("contacto")) {
            System.out.println("Contacto encontrado en " + ((System.currentTimeMillis() - startTime) / 1000) + " segundos");
        }
        final WebElement btnBlog = driver.findElement(By.cssSelector("a[data-default-url='#collapse3']"));
        btnBlog.click();
        final WebElement h1Blog = driver.findElement(By.cssSelector("h1"));
        if (h1Blog.isDisplayed() && h1Blog.getText().equalsIgnoreCase("blog")) {
            System.out.println("Blog encontrado en " + ((System.currentTimeMillis() - startTime) / 1000) + " segundos");
        }
        driver.quit();
    }
}
