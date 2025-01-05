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

public class AddBookToList {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();

    driver.get("https://sharereads.xyz/");

    WebElement bookSearchInput = driver.findElement(By.id("book-search-input"));
    bookSearchInput.sendKeys("ispy");

    WebElement bookSearchButton = driver.findElement(By.id("book-search-button"));
    bookSearchButton.click();
  
    // Add logic here to add book to list and verify those results

    driver.quit();

  }
}
