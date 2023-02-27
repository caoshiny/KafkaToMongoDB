package com.shiny.service.impl;

import com.shiny.dao.HitVehicleDao;
import com.shiny.entity.HitVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class HitVehicleImpl implements HitVehicleDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveHitVehicle(HitVehicle hitVehicle) {
        mongoTemplate.save(hitVehicle);
    }
}
