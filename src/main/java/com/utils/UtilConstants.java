package com.utils;

import java.util.Properties;

public class UtilConstants {

    private static Properties env_properties = null;

    public static Properties ENV_PROPERTIES() throws Exception {
        if(env_properties == null){
            try{
                env_properties = PropertiesFileReader.getInstance().getProperties("env.properties");
            }
            catch (Exception ex){
                ex.printStackTrace();
                throw new Exception(ex.getMessage());
            }
        }
        return env_properties;
    }


    private static String GetPropertyValue(String propName) {
        String propertyValue = "";
        try{
            propertyValue = PropertiesFileReader.getInstance().getPropertyValue(ENV_PROPERTIES(), propName);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return propertyValue;
    }


    public static String getBaseUrl(){
        return GetPropertyValue("baseUrl");
    }

    public static String getPathParameter(){
        return GetPropertyValue("pathParameter");
    }

    public static String getInvalidGetUserPathParameter(){
        return GetPropertyValue("invalidGetUserPathParameter");
    }


}
