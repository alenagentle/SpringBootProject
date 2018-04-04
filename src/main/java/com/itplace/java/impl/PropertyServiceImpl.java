package com.itplace.java.impl;

import com.itplace.java.api.PropertyReader;
import com.itplace.java.api.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Component
public class PropertyServiceImpl implements PropertyService {
    @Autowired // аннотация внедрения зависимости
    @Qualifier("propertyReaderImpl") // аннотация иденификации внедрения зависимости (установка соответствия идентификатора класса, реализующего запрашиваемый интерфейс  и названия этого интерфейса)
    private PropertyReader propertyreader; // инжектим в переменную propertyreader бин propertyReaderImpl


    public  Properties getFile(){
        this.propertyreader.loadFile();
        return this.propertyreader.getFile();
    }
}