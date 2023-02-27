package com.shiny.service.impl;

import com.shiny.dao.CaptureVehicleDao;
import com.shiny.entity.CaptureVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CaptureVehicleImpl implements CaptureVehicleDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveCaptureVehicle(CaptureVehicle captureVehicle){
        mongoTemplate.save(captureVehicle);
    }
}
