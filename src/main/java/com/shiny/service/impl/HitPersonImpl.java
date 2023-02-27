package com.shiny.service.impl;

import com.shiny.dao.HitPersonDao;
import com.shiny.entity.HitPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class HitPersonImpl implements HitPersonDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveHitPerson(HitPerson hitPerson){
        mongoTemplate.save(hitPerson);
    }
}
