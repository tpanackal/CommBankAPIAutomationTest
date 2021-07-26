package com.utils;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.Random;

public class TestUtils {

    public static File getSchemaDetails(String jsonFileName){
        String fileSeparator = System.getProperty("file.separator");
        File getSchemaDetails = new File(System.getProperty("user.dir")+fileSeparator+"src"+fileSeparator+"test"+fileSeparator+"java"+fileSeparator+"com"+fileSeparator+"schema"+fileSeparator+jsonFileName);
        return getSchemaDetails;
    }

    public static String getUserName(){
        Faker faker = new Faker();
        String userName = (faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber()).substring(0,8);
        return userName;
    }

    public static Integer getScore(){
        Random randomNum = new Random();
        int min = 1;
        int generatedNumber = min + randomNum.nextInt(100);
        return generatedNumber;
    }


}
