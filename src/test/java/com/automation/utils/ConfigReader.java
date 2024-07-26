package com.automation.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;
    public static void initConfig() throws IOException {
         prop = new Properties();
        prop.load(new FileInputStream("src/test/resources/config/config.properties"));

    }
    public static String getConfig(String key)
    {
      return prop.getProperty(key);
    }
}
