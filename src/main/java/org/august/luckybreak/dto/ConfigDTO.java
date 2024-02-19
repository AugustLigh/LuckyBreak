package org.august.luckybreak.dto;

import java.io.Serializable;

public class ConfigDTO implements Serializable {
    private boolean activated;
    private DropSettings dropSettings = new DropSettings();

    public ConfigDTO() {}

    public ConfigDTO(boolean activated, DropSettings dropSettings) {
        this.activated = activated;
        this.dropSettings = dropSettings;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public DropSettings getDropSettings() {
        return dropSettings;
    }

    public void setDropSettings(DropSettings dropSettings) {
        this.dropSettings = dropSettings;
    }
}

