package com.example.sharereadsautomation.practicetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://selenium.dev");

        driver.get("https://sharereads.xyz/");
        
        driver.quit();
    }
}
