package com.zor07.services.appium;

import com.zor07.domain.AppiumSettings;
import com.zor07.repositories.AppiumSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppiumSettingsService implements SettingsService {
    private AppiumSettingsRepository repository;

    @Autowired
    public void setRepository(AppiumSettingsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<AppiumSettings> listAll() {
        return null;
    }

    @Override
    public AppiumSettings get(){
        AppiumSettings settings = repository.findOne(1);
        if (settings == null) return new AppiumSettings();
        return settings;
    }

    @Override
    public AppiumSettings save(AppiumSettings obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }


}
