package com.testeryou.bdd.generic;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RestProperties {
    private static final String FILE_NAME = "rest.properties";
    private static final String RESOURCES_ROOT_DIR= "./src/test/resources/";
    private static Properties properties;


    public static Properties getProperties() {
        File propertiesFile = FileUtils.getFile(new String[]{RESOURCES_ROOT_DIR,FILE_NAME});
        if (properties == null) {
            properties = loadPropertiesFromFile(propertiesFile);
        }
        return properties;
    }

    static Properties loadPropertiesFromFile (File propertiesFile) {
        Properties properties = new Properties();
        try {
            FileInputStream stream = FileUtils.openInputStream(propertiesFile);
            try{
                properties.load(stream);
            } catch (Throwable e1) {
                if (stream != null) {
                    stream.close();
                }
                throw e1;
            }

            if (stream != null) {
                stream.close();
            }
            return properties;

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
