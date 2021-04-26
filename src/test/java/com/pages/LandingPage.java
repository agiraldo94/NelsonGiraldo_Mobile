package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class LandingPage {
    public LandingPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(id = "com.trivago:id/fragmentHomeExpandedDealformSearchTextView")
    public MobileElement btnSearch;

    @FindBy(id = "com.trivago:id/fragmentHomeExpandedDealformDestinationTextView")
    public MobileElement txtSearch;

    @FindBy(id = "com.trivago:id/activitySearchDestinationSearchEditText")
    public MobileElement txtEditSearch;

    @FindBys(@FindBy(className = "android.widget.TextView"))
    public List<MobileElement> cities;

    @FindBy(id = "com.trivago:id/activityDatesSelectionToolbar")
    public MobileElement titleCalendar;

    @FindBy(id = "com.trivago:id/activityDatesSelectionCalendarApplyTextView")
    public MobileElement btnConfirmDate;

    @FindBys(@FindBy(className = "android.widget.TextView"))
    public List<MobileElement> days;

    @FindBy(id = "com.trivago:id/fragmentHotelSearchResultsExpandedDealformDestinationTextView")
    public MobileElement cityReady;

    @FindBy(id = "com.trivago:id/fragmentHotelSearchResultsExpandedDealformCalendarTextView")
    public MobileElement dateReady;

    @FindBys(@FindBy(className = "android.widget.TextView"))
    public List<MobileElement> menu;

}
