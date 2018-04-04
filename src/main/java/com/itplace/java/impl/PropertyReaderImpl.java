package com.itplace.java.impl;

import com.itplace.java.api.PropertyReader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;


@Component
public class PropertyReaderImpl implements PropertyReader {
    private Properties prop;

    @Override
    public void loadFile() {
        String configFileInput = "resources/person.properties";
        this.prop = new Properties();
        try {
            this.prop.load(new BufferedReader(new InputStreamReader(new FileInputStream(configFileInput), "UTF-8")));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Properties getFile() {
        return this.prop;
    }
}