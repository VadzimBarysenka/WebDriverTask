package com.yandex;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement pswdField;

    @FindBy(name = "track_id")
    private WebElement trackId;

    @FindBy(id = "passp-field-login")
    private WebElement loginField;

    @FindBy(className = "Button2 Button2_size_l Button2_view_action Button2_width_max Button2_type_submit")
    private WebElement loginButton;

    @FindBy(linkText = "Log in with QR-code")
    private WebElement qrButton;

    @FindBy(partialLinkText = "Enter")
    private WebElement pasLabel;

    @FindBy(css = ".Logo_ya.Logo_en")
    private WebElement logo;
}

