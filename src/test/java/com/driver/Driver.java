package com.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private  AppiumDriver<MobileElement> driver;

    public Driver () throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Huawei");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.trivago");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.trivago.ft.main.frontend.MainActivity");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}
