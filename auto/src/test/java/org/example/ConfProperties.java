package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Struct;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static {
        try{
            //указание пути до файла с настройками
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        }catch (IOException e){
            e.printStackTrace();
            //обработка возможеого исклюбчкеия (нет файла и т.п.)
        }finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    public static String getProperty(String key){return PROPERTIES.getProperty(key);}
}

