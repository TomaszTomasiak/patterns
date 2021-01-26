package com.patterns.singleton;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SettingsTestSuite {

    @BeforeClass
    public static void openSettings() {

        Settings.getInstance().open("myApp.settings");
    }

    @AfterClass
    public static void closeSettingsFile() {
        Settings.getInstance().close();
    }

    @Test
    public void testGetFileName() {
        //Given
        //When
        String fileName = Settings.getInstance().getFileName();
        System.out.println("Oppened: " + fileName);
        //Then
       assertEquals("myApp.settings", fileName);
    }

    @Test
    public void testLoadSettings() {
        //Given
        //When
        boolean result = Settings.getInstance().loadSettings();
        //Then
        assertTrue(result);
    }

    @Test
    public void testSaveSettings() {
        //Given
        //When
        boolean result = Settings.getInstance().saveSettings();
        //Then
        assertTrue(result);
    }

}
