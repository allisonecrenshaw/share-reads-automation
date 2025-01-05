package com.example.sharereadsautomation.tests;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchForBooks {
  public static void main(String[] args) {
    // May later add some utils like constants class, setup functions, etc.
    WebDriver driver = new ChromeDriver();

    driver.get("https://sharereads.xyz/");

    WebElement bookSearchInput = driver.findElement(By.id("book-search-input"));
    bookSearchInput.sendKeys("ispy");

    WebElement bookSearchButton = driver.findElement(By.id("book-search-button"));
    bookSearchButton.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    List<WebElement> searchResults = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("book-search-result")));

    
    Assertions.assertNotNull(searchResults);
    Assertions.assertTrue(searchResults.size() > 0);

    driver.quit();
  }
}
