package org.august.luckybreak;

import org.august.luckybreak.dto.ConfigDTO;


public class ConfigManager {
    private static ConfigManager instance;
    private ConfigDTO configDTO;

    private ConfigManager() {
        configDTO = new ConfigDTO();
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public ConfigDTO getConfig() {
        return configDTO;
    }
}


