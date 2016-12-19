package com.zor07.services.appium;

import com.zor07.domain.AppiumSettings;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
class AppiumSetup {
    AndroidDriver driver;

    Map<String, WebElement> controls;

    private AppiumSettingsService appiumSettingsService;

    void prepareAndroidForAppium() throws MalformedURLException {
        AppiumSettings settings = appiumSettingsService.get();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", settings.getAndroidVersion());
        capabilities.setCapability("deviceName", settings.getDeviceName());
        capabilities.setCapability("app", settings.getApplicationPath());
        capabilities.setCapability("appPackage", settings.getApplicationPackage());
        capabilities.setCapability("appActivity", settings.getApplicationActivity());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        controls = null;
        controls = new HashMap<>();
        controls.put("1", driver.findElement(By.id(settings.getOne())));
        controls.put("2", driver.findElement(By.id(settings.getTwo())));
        controls.put("3", driver.findElement(By.id(settings.getThree())));
        controls.put("4", driver.findElement(By.id(settings.getFour())));
        controls.put("5", driver.findElement(By.id(settings.getFive())));
        controls.put("6", driver.findElement(By.id(settings.getSix())));
        controls.put("7", driver.findElement(By.id(settings.getSeven())));
        controls.put("8", driver.findElement(By.id(settings.getEight())));
        controls.put("9", driver.findElement(By.id(settings.getNine())));
        controls.put("0", driver.findElement(By.id(settings.getZero())));
        controls.put("=", driver.findElement(By.id(settings.getEquals())));
        controls.put("-", driver.findElement(By.id(settings.getSubtract())));
        controls.put("+", driver.findElement(By.id(settings.getAdd())));
        controls.put("/", driver.findElement(By.id(settings.getDivide())));
        controls.put("*", driver.findElement(By.id(settings.getMultiply())));
        controls.put("(", driver.findElement(By.id(settings.getBrackets())));
        controls.put(")", driver.findElement(By.id(settings.getBrackets())));
        controls.put(".", driver.findElement(By.id(settings.getPoint())));
        controls.put("result", driver.findElement(By.id(settings.getResult())));

    }

    @Autowired
    public void setAppiumSettingsService(AppiumSettingsService appiumSettingsService) {
        this.appiumSettingsService = appiumSettingsService;
    }

    void finish() {
        driver.quit();
    }
}
