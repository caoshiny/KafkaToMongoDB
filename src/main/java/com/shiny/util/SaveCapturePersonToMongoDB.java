package com.shiny.util;

import com.alibaba.fastjson.JSONObject;
import com.shiny.entity.CapturePerson;
import com.shiny.service.impl.CapturePersonImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SaveCapturePersonToMongoDB {
    @Autowired
    CapturePersonImpl capturePersonImpl;

    public void saveDataToMongoDB(String KafkaStr) {
        // 将接收到的String类型转换为Json类型
        JSONObject KafkaJson = null;
        try {
            KafkaJson = JSONObject.parseObject(KafkaStr);
        }catch (Exception e){
            log.info("程序执行String -> Json失败: " + e);
        }

        if(KafkaJson != null) {
            CapturePerson capturePerson = new CapturePerson();
            capturePerson.setId(KafkaJson.getString("id"));
            capturePerson.setPosition(KafkaJson.getString("position"));
            capturePerson.setLon(KafkaJson.getBigDecimal("lon"));
            capturePerson.setLat(KafkaJson.getBigDecimal("lat"));
            capturePerson.setPasserbyId(KafkaJson.getString("passerbyId"));
            capturePerson.setDetectType(KafkaJson.getString("detectType"));
            capturePerson.setCapturedTime(KafkaJson.getString("capturedTime"));
            capturePerson.setCameraId(KafkaJson.getString("cameraId"));
            capturePerson.setCameraName(KafkaJson.getString("cameraName"));
            capturePerson.setPlace(KafkaJson.getString("place"));
            capturePerson.setUrl(KafkaJson.getString("url"));
            capturePerson.setFullUrl(KafkaJson.getString("fullUrl"));
            capturePerson.setGender(KafkaJson.getInteger("gender"));
            capturePerson.setAge(KafkaJson.getInteger("age"));
            capturePerson.setPasserbyMinority(KafkaJson.getInteger("passerbyMinority"));
            capturePerson.setBeardStatus(KafkaJson.getInteger("beardStatus"));
            capturePerson.setEyeStatus(KafkaJson.getInteger("eyeStatus"));
            capturePerson.setHeadwearStatus(KafkaJson.getInteger("headwearStatus"));
            capturePerson.setMouthStatus(KafkaJson.getInteger("mouthStatus"));

            System.out.println(capturePerson.toString());

        }else {
            log.error("Kafka Json 为 null！");
        }
    }
}
