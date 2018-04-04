package com.itplace.java.impl;

import com.itplace.java.api.HtmlCreator;
import com.itplace.java.api.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.io.*;

@Component
public class HtmlCreatorImpl implements HtmlCreator {

    @Autowired
    @Qualifier("propertyServiceImpl")
    private PropertyService propertyservice;

    @Override
    public void createHtml(String outputFile) {
        Properties fileProp =  this.propertyservice.getFile();
        //fileProp.getProperty("FIO");

        String html = "<!DOCTYPE html>\n"
                + "<html lang=\"ru\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "    <title>Резюме</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "        <h4 class=\"text-center\"><strong>Резюме</strong><p>на должность Java-стажер</p></h4>\n"
                + "                    <dt>Дата рождения:</dt><dd>" + fileProp.getProperty("DOB") + "</dd>\n"
                + "                    <dt>Телефон:</dt><dd>" + fileProp.getProperty("phone") + "</dd>\n"
                + "                    <dt>e-mail:</dt><dd>" + fileProp.getProperty("email") + "</dd>\n"
                + "                    <dt>Skype:</dt><dd>" + fileProp.getProperty("skype") + "</dd>\n"
                + "            <h4 class=\"card-title\"><strong>Цель:</strong></h4>\n"
                + "            <p class=\"card-text\">" + fileProp.getProperty("target") + "</p>\n"
                + "            <h4 class=\"card-title\"><strong>Опыт работы:</strong></h4>\n"
                + "            <ol class=\"card-text\">\n" + fileProp.getProperty("experiences") + "</ol>\n"
                + "            <h4 class=\"card-title\"><strong>Образование:</strong></h4>\n"
                + "            <p class=\"card-text\">" + fileProp.getProperty("educations") + "</p>\n"
                + " </body>\n"
                + " </html>";

        try {
            File file = new File(outputFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter (outputFile, false);
            writer.write(html);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}