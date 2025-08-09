package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resource.java.GG_BaseTest;

import java.util.List;

public class GG_ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        if (identifierType == null || identifierValue == null || identifierType.isEmpty() || identifierValue.isEmpty()) {
            throw new IllegalArgumentException("El tipo o valor del localizador no puede ser nulo o vacío.");
        }

        switch (identifierType.toUpperCase()) {
            case "ID":
                return GG_BaseTest.driver.findElement(By.id(identifierValue));
            case "CSS":
                return GG_BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return GG_BaseTest.driver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return GG_BaseTest.driver.findElement(By.xpath(identifierValue));
            case "LINK TEXT":
                return GG_BaseTest.driver.findElement(By.linkText(identifierValue));
            default:
                throw new IllegalArgumentException("Tipo de localizador no soportado: " + identifierType);
        }
    }

    public List<WebElement> getListWebElements(String identifierType, String identifierValue) {
        if (identifierType == null || identifierValue == null || identifierType.isEmpty() || identifierValue.isEmpty()) {
            throw new IllegalArgumentException("El tipo o valor del localizador no puede ser nulo o vacío.");
        }

        switch (identifierType.toUpperCase()) {
            case "ID":
                return GG_BaseTest.driver.findElements(By.id(identifierValue));
            case "CSS":
                return GG_BaseTest.driver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return GG_BaseTest.driver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return GG_BaseTest.driver.findElements(By.xpath(identifierValue));
            case "LINK TEXT":
                return GG_BaseTest.driver.findElements(By.linkText(identifierValue));
            default:
                throw new IllegalArgumentException("Tipo de localizador no soportado: " + identifierType);
        }
    }
}
