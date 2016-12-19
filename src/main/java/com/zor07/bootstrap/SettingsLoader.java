package com.zor07.bootstrap;

import com.zor07.domain.AppiumSettings;
import com.zor07.services.appium.AppiumSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "appiumSettings")
public class SettingsLoader implements ApplicationListener<ContextRefreshedEvent> {
    private AppiumSettingsService appiumSettingsService;

    private String applicationPath;
    private String applicationPackage;
    private String applicationActivity;
    private String androidVersion;
    private String deviceName;
    private String buttonOne;
    private String buttonTwo;
    private String buttonThree;
    private String buttonFour;
    private String buttonFive;
    private String buttonSix;
    private String buttonSeven;
    private String buttonEight;
    private String buttonNine;
    private String buttonZero;
    private String buttonEquals;
    private String buttonSubtract;
    private String buttonAdd;
    private String buttonDivide;
    private String buttonMultiply;
    private String buttonBrackets;
    private String buttonPoint;
    private String result;

    @Autowired
    public void setAppiumSettingsService(AppiumSettingsService appiumSettingsService) {
        this.appiumSettingsService = appiumSettingsService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        AppiumSettings appiumSettings = appiumSettingsService.get();
        if (appiumSettings.getId() == null){
            appiumSettings = new AppiumSettings();
            appiumSettings.setApplicationPath(applicationPath);
            appiumSettings.setApplicationPackage(applicationPackage);
            appiumSettings.setApplicationActivity(applicationActivity);
            appiumSettings.setAndroidVersion(androidVersion);
            appiumSettings.setDeviceName(deviceName);
            appiumSettings.setOne(buttonOne);
            appiumSettings.setTwo(buttonTwo);
            appiumSettings.setThree(buttonThree);
            appiumSettings.setFour(buttonFour);
            appiumSettings.setFive(buttonFive);
            appiumSettings.setSix(buttonSix);
            appiumSettings.setSeven(buttonSeven);
            appiumSettings.setEight(buttonEight);
            appiumSettings.setNine(buttonNine);
            appiumSettings.setZero(buttonZero);
            appiumSettings.setEquals(buttonEquals);
            appiumSettings.setSubtract(buttonSubtract);
            appiumSettings.setAdd(buttonAdd);
            appiumSettings.setDivide(buttonDivide);
            appiumSettings.setMultiply(buttonMultiply);
            appiumSettings.setBrackets(buttonBrackets);
            appiumSettings.setResult(result);
            appiumSettings.setPoint(buttonPoint);
            appiumSettingsService.save(appiumSettings);
        }
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    public void setApplicationPackage(String applicationPackage) {
        this.applicationPackage = applicationPackage;
    }

    public void setApplicationActivity(String applicationActivity) {
        this.applicationActivity = applicationActivity;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setButtonOne(String buttonOne) {
        this.buttonOne = buttonOne;
    }

    public void setButtonTwo(String buttonTwo) {
        this.buttonTwo = buttonTwo;
    }

    public void setButtonThree(String buttonThree) {
        this.buttonThree = buttonThree;
    }

    public void setButtonFour(String buttonFour) {
        this.buttonFour = buttonFour;
    }

    public void setButtonFive(String buttonFive) {
        this.buttonFive = buttonFive;
    }

    public void setButtonSix(String buttonSix) {
        this.buttonSix = buttonSix;
    }

    public void setButtonSeven(String buttonSeven) {
        this.buttonSeven = buttonSeven;
    }

    public void setButtonEight(String buttonEight) {
        this.buttonEight = buttonEight;
    }

    public void setButtonNine(String buttonNine) {
        this.buttonNine = buttonNine;
    }

    public void setButtonZero(String buttonZero) {
        this.buttonZero = buttonZero;
    }

    public void setButtonEquals(String buttonEquals) {
        this.buttonEquals = buttonEquals;
    }

    public void setButtonSubtract(String buttonSubtract) {
        this.buttonSubtract = buttonSubtract;
    }

    public void setButtonAdd(String buttonAdd) {
        this.buttonAdd = buttonAdd;
    }

    public void setButtonDivide(String buttonDivide) {
        this.buttonDivide = buttonDivide;
    }

    public void setButtonMultiply(String buttonMultiply) {
        this.buttonMultiply = buttonMultiply;
    }

    public void setButtonBrackets(String buttonBrackets) {
        this.buttonBrackets = buttonBrackets;
    }

    public void setButtonPoint(String buttonPoint) {
        this.buttonPoint = buttonPoint;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
