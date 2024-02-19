package org.august.luckybreak.dto;

import java.io.Serializable;

public class DropSettings implements Serializable {
    private boolean dropEgs;
    private boolean dropRequested;

    public DropSettings() {}
    public DropSettings(boolean dropEgs, boolean dropRequested) {
        this.dropEgs = dropEgs;
        this.dropRequested = dropRequested;
    }

    public void setDropEgs(boolean dropEgs) {
        this.dropEgs = dropEgs;
    }

    public void setDropRequested(boolean dropRequested) {
        this.dropRequested = dropRequested;
    }

    public boolean isDropEgs() {
        return dropEgs;
    }

    public boolean isDropRequested() {
        return dropRequested;
    }
}
