package com.patterns.singleton;


public final class Settings {

    private String fileName = "";

    public Settings() {

    }

    public String getFileName() {
        return fileName;
    }

    public void open(final String fileName) {
        this.fileName = fileName;
        System.out.println("Opening the settings");
    }

    public void close() {
        this.fileName = fileName;
        System.out.println("Closing the settings");
    }

    public boolean loadSettings() {
        System.out.println("Loading settings from file");
        return true;
    }
    public boolean saveSettings() {
        System.out.println("Saving settings to file");
        return true;
    }
}
