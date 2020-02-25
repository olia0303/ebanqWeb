package com.ebanq.web.pageobjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.ebanq.web.other.Urls.LOGIN_PAGE;

public class LoginPage extends BasePage {
    public LoginPage openPage(){
        open(LOGIN_PAGE);
        return this;
    }

    public String login(String username, String password){
        $(By.xpath("//input[@type='email']")).sendKeys(username);
        $(By.xpath("//input[@type='password']")).sendKeys(password);
        $(By.xpath("//button[text()='Sign In']")).click();
        return url();
    }
    
    public void logOut() {
        $(By.xpath("//span[contains(text(),'Log Out')]")).click();
    }

    @Override
    public LoginPage isPageOpened(){
        $(By.xpath("//button[text()='Sign In']")).shouldBe(Condition.visible);
        return this;
    }
}
