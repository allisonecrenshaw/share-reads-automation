package com.example.sharereadsautomation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;;

public class SearchForBooks {
  public static void main(String[] args) {
    // May later add some utils like constants class, setup functions, etc.
    WebDriver driver = new ChromeDriver();

    driver.get("https://sharereads.xyz/");

    WebElement bookSearchInput = driver.findElement(By.id("book-search-input"));
    bookSearchInput.sendKeys("ispy");

    WebElement bookSearchButton = driver.findElement(By.id("book-search-button"));
    bookSearchButton.click();

    driver.quit();
  }
}
