package com.shiny.util;

import com.alibaba.fastjson.JSONObject;
import com.shiny.entity.HitVehicle;
import com.shiny.service.impl.HitVehicleImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component
public class SaveHitVehicleToMongoDB {
    @Autowired
    HitVehicleImpl hitVehicleImpl;

    public void saveDataToMongoDB(String KafkaStr) {
        // 将接收到的String类型转换为Json类型
        JSONObject KafkaJson = null;
        try {
            KafkaJson = JSONObject.parseObject(KafkaStr);
        }catch (Exception e){
            log.info("程序执行String -> Json失败: " + e);
        }

        if(KafkaJson != null) {
            HitVehicle hitVehicle = new HitVehicle();
            hitVehicle.setCameraId(KafkaJson.getString("cameraId"));
            hitVehicle.setVehicleId(KafkaJson.getString("vehicleId"));
            hitVehicle.setVehicleNum(KafkaJson.getString("vehicleNum"));
            hitVehicle.setCameraName(KafkaJson.getString("cameraName"));
            hitVehicle.setPlace(KafkaJson.getString("place"));
            hitVehicle.setUrl(KafkaJson.getString("url"));
            hitVehicle.setLicensePlateText(KafkaJson.getString("licensePlateText"));
            hitVehicle.setCaptureId(KafkaJson.getString("captureId"));
            hitVehicle.setCameraLatitude(KafkaJson.getBigDecimal("cameraLatitude"));
            hitVehicle.setCameraLongitude(KafkaJson.getBigDecimal("cameraLongitude"));
            hitVehicle.setCaptureTime(Timestamp.valueOf(KafkaJson.getString("captureTime")));

            System.out.println(hitVehicle.toString());
        }else {
            log.error("Kafka Json 为 null！");
        }
    }
}
