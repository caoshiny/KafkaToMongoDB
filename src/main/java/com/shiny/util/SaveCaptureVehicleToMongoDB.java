package com.shiny.util;

import com.alibaba.fastjson.JSONObject;
import com.shiny.entity.CaptureVehicle;
import com.shiny.service.impl.CaptureVehicleImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SaveCaptureVehicleToMongoDB {
    @Autowired
    CaptureVehicleImpl captureVehicleImpl;

    public void saveDataToMongoDB(String KafkaStr) {
        // 将接收到的String类型转换为Json类型
        JSONObject KafkaJson = null;
        try {
            KafkaJson = JSONObject.parseObject(KafkaStr);
        }catch (Exception e){
            log.info("程序执行String -> Json失败: " + e);
        }

        if(KafkaJson != null) {
            CaptureVehicle captureVehicle = new CaptureVehicle();
            captureVehicle.setId(KafkaJson.getString("id"));
            captureVehicle.setDetectType(KafkaJson.getString("detectType"));
            captureVehicle.setCapturedTime(KafkaJson.getString("capturedTime"));
            captureVehicle.setCameraId(KafkaJson.getString("cameraId"));
            captureVehicle.setCameraName(KafkaJson.getString("cameraName"));
            captureVehicle.setPlace(KafkaJson.getString("place"));
            captureVehicle.setUrl(KafkaJson.getString("url"));
            captureVehicle.setFullUrl(KafkaJson.getString("fullUrl"));
            captureVehicle.setMotorAuxSeatHasPerson(KafkaJson.getString("motorAuxSeatHasPerson"));
            captureVehicle.setVehicleColor(KafkaJson.getString("vehicleColor"));
            captureVehicle.setLicensePlateColor(KafkaJson.getString("licensePlateColor"));
            captureVehicle.setLicensePlateText(KafkaJson.getString("licensePlateText"));
            captureVehicle.setVehicleSunroof(KafkaJson.getString("vehicleSunroof"));
            captureVehicle.setMotorBrand(KafkaJson.getString("motorBrand"));
            captureVehicle.setVehicleRack(KafkaJson.getString("vehicleRack"));
            captureVehicle.setMotorAuxSeatbelt(KafkaJson.getString("motorAuxSeatbelt"));
            captureVehicle.setMotorCategory(KafkaJson.getString("motorCategory"));
            captureVehicle.setMotorAuxSunvisor(KafkaJson.getString("motorAuxSunvisor"));
            captureVehicle.setMotorAnnualInspection(KafkaJson.getString("motorAnnualInspection"));
            captureVehicle.setVehicleRack(KafkaJson.getString("vehicleSpray"));
            captureVehicle.setMotorDecoration(KafkaJson.getString("motorDecoration"));
            captureVehicle.setMotorPendant(KafkaJson.getString("motorPendant"));
            captureVehicle.setMotorMainSunvisor(KafkaJson.getString("motorMainSunvisor"));
            captureVehicle.setVehicleOrientation(KafkaJson.getString("vehicleDecoration"));
            captureVehicle.setMotorMainSeatbelt(KafkaJson.getString("motorMainSeatbelt"));
            captureVehicle.setMotorPhone(KafkaJson.getString("motorPhone"));
            captureVehicle.setAlbumImgId(KafkaJson.getString("albumImgId"));

            System.out.println(captureVehicle.toString());

        }else {
            log.error("Kafka Json 为 null！");
        }
    }
}
