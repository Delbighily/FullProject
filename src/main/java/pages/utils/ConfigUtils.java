package pages.utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;
    public ConfigUtils(){
        properties =PropertiesUtils.loadProperties("C:\\Users\\East-Sound\\fullAutoProject\\src\\main\\java\\pages\\config\\production.properties");
    }

    public static ConfigUtils getInstance(){
        if(configUtils==null){
            configUtils=new ConfigUtils();
        }
        return configUtils;
    }

    public String getEmail(){
        return properties.getProperty("email");
    }
    public String getPassword(){
        return properties.getProperty("password");
    }
    public String getFname(){
        return properties.getProperty("firstname");
    }
    public String getLname(){
        return properties.getProperty("lastname");
    }
    public String getCountry(){
        return properties.getProperty("country");
    }
    public String getCity(){
        return properties.getProperty("city");
    }
    public String getBuilding(){
        return properties.getProperty("building");
    }
    public String getFloor(){
        return properties.getProperty("floor");
    }
    public String getStreet(){
        return properties.getProperty("street");
    }
    public String getZip(){
        return properties.getProperty("zipcode");
    }
    public String getPhone(){
        return properties.getProperty("phone");
    }
}

