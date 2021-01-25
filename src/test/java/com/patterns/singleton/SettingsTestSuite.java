package com.patterns.singleton;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SettingsTestSuite {

    private static Settings settings;

    @BeforeClass
    public static void openSettings() {
        settings = new Settings();
        settings.open("myApp.settings");
    }

    @AfterClass
    public static void closeSettingsFile() {
        settings.close();
    }

    @Test
    public void testGetFileName() {
        //Given
        //When
        String fileName = settings.getFileName();
        System.out.println("Oppened: " + fileName);
        //Then
       assertEquals("myApp.settings", fileName);
    }
}
