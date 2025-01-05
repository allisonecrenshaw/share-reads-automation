package com.example.sharereadsautomation.tests;

import java.time.Duration;
import java.util.List;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

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

    // Search for a book
    WebElement bookSearchInput = driver.findElement(By.id("book-search-input"));
    bookSearchInput.sendKeys("ispy");

    WebElement bookSearchButton = driver.findElement(By.id("book-search-button"));
    bookSearchButton.click();
  
    // Add book to list
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    WebElement addToListButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("book-search-result-add-button")));
    addToListButton.click();

    WebElement viewListButton = driver.findElement(By.id("view-book-list-button"));
    viewListButton.click();

    // Copy share link
    WebElement copyShareLinkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("copy-share-link-button")));
    copyShareLinkButton.click();
    
    // Get value from clipboard
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable clipboardContents = clipboard.getContents(clipboard);
    String bookListUrl = "";
    try {
      bookListUrl = (String)clipboardContents.getTransferData(DataFlavor.stringFlavor);
    } catch (UnsupportedFlavorException | IOException ex) {
      System.out.println(ex);
      ex.printStackTrace();
    }

    // Navigate to list and verify list is not empty
      // Note: Search results don't have unique ids, so only checking for now that list is not empty
    driver.get(bookListUrl);
    List<WebElement> bookListItems = driver.findElements(By.cssSelector("ul > li"));
    Assertions.assertTrue(bookListItems.size() > 0);

    driver.quit();

  }
}
