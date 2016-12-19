package com.zor07.services.appium;

import com.zor07.domain.AppiumSettings;

public interface SettingsService{
    Iterable<AppiumSettings> listAll();

    AppiumSettings get();

    AppiumSettings save(AppiumSettings settings);

    void delete(Integer id);
}
