package com.zor07.controllers;

import com.zor07.domain.AppiumSettings;
import com.zor07.services.appium.AppiumSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppiumSettingsController {

    private AppiumSettingsService appiumSettingsService;

    @Autowired
    public void setAppiumSettingsService(AppiumSettingsService appiumSettingsService) {
        this.appiumSettingsService = appiumSettingsService;
    }

    @RequestMapping("/settings")
    public String setup(Model model){
        model.addAttribute("settings", appiumSettingsService.get());
        return "settings";
    }

    @RequestMapping("settings/edit")
    public String edit(Model model){
        model.addAttribute("settings", appiumSettingsService.get());
        return "settingsform";
    }

    @RequestMapping(value = "savesettings", method = RequestMethod.POST)
    public String saveTestPlan(AppiumSettings setup){
        appiumSettingsService.save(setup);
        return "redirect:/settings";
    }

}
