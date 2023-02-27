package com.shiny.service.impl;

import com.shiny.dao.CapturePersonDao;
import com.shiny.entity.CapturePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CapturePersonImpl implements CapturePersonDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveCapturePerson(CapturePerson capturePerson){
        mongoTemplate.save(capturePerson);
    }
}
