package com.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

    private PropertiesFileReader(){};
    private static PropertiesFileReader instance = null;

    public static PropertiesFileReader getInstance(){
        if (instance == null)
            instance = new PropertiesFileReader();

        return instance;
    }

    public Properties getProperties(String propFileName) throws Exception {

        InputStream inputStream = null;
        Properties prop = null;

        try {
            prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            throw new Exception("Unable to read properties file " + propFileName);
        } finally {
            inputStream.close();
            return prop;
        }

    }

    public String getPropertyValue(Properties prop, String propName) throws Exception {

        String result = "";
        try {
            result = prop.getProperty(propName);
        } catch (Exception e) {
            throw new Exception("Property Not Found" + propName);
        }
        return result;
    }
}
