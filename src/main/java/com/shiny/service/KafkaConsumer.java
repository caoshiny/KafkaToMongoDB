package com.shiny.service;

import com.shiny.util.SaveCapturePersonToMongoDB;
import com.shiny.util.SaveCaptureVehicleToMongoDB;
import com.shiny.util.SaveHitPersonToMongoDB;
import com.shiny.util.SaveHitVehicleToMongoDB;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {
    @Autowired
    SaveHitPersonToMongoDB saveHitPersonToMongoDB;

    @Autowired
    SaveHitVehicleToMongoDB saveHitVehicleToMongoDB;

    @Autowired
    SaveCapturePersonToMongoDB saveCapturePersonToMongoDB;

    @Autowired
    SaveCaptureVehicleToMongoDB saveCaptureVehicleToMongoDB;

    // 消费监听 VT_ALERT_PITCH_PERSON 队列
    @KafkaListener(topics = {"VT_ALERT_PITCH_PERSON"})
    public void getPitchPersonMessages(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        log.info("______________________监听到-[VT_ALERT_PITCH_PERSON]-队列新消息______________________");
        log.info("监听到的消息为: " + record.value());
        try{
            saveHitPersonToMongoDB.saveDataToMongo((String) record.value());
            log.info("此消息: [" + record.value() + "] 处理完毕！");
        }catch (Exception e){
            log.error("此消息: [" + record.value() + "] 处理失败！");
        }
    }

    // 消费监听 VT_ALERT_PITCH_VEHICLE 队列
    @KafkaListener(topics = {"VT_ALERT_PITCH_VEHICLE"})
    public void getPitchVehicleMessages(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        log.info("______________________监听到-[VT_ALERT_PITCH_VEHICLE]-队列新消息______________________");
        log.info("监听到的消息为: " + record.value());
        saveHitVehicleToMongoDB.saveDataToMongoDB((String) record.value());

    }

    // 消费监听 VT_ALERT_CAPTURE_PERSON 队列
    @KafkaListener(topics = {"VT_ALERT_CAPTURE_PERSON"})
    public void getCapturePersonMessages(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        log.info("______________________监听到-[VT_ALERT_CAPTURE_PERSON]-队列新消息______________________");
        log.info("监听到的消息为: " + record.value());
        saveCapturePersonToMongoDB.saveDataToMongoDB((String) record.value());
    }

    // 消费监听 VT_ALERT_CAPTURE_VEHICLE 队列
    @KafkaListener(topics = {"VT_ALERT_CAPTURE_VEHICLE"})
    public void getCaptureVehicleMessages(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        log.info("______________________监听到-[VT_ALERT_CAPTURE_VEHICLE]-队列新消息______________________");
        log.info("监听到的消息为: " + record.value());
        saveCaptureVehicleToMongoDB.saveDataToMongoDB((String) record.value());
    }

}
