package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class PrivacyPage {
    public PrivacyPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy (id = "com.trivago:id/activityCookieConsentContentTitleTextView")
    public MobileElement title;

    @FindBys({@FindBy(className = "android.widget.TextView")})
    public List<MobileElement> body;

    @FindBy(id = "com.trivago:id/activityCookieConsentContentAcceptButton")
    public MobileElement btnAccept;
}
