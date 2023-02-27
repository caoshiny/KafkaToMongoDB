package com.shiny;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KafkaTest {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Test
    public void sendMessages(){
        String demo = "{\"personId\":\"5489425\" , \"personNum\":\"1111\" , \"captureId\":\"2222\" , \"url\":\"www.baidu.com\" , \"fullUrl\":\"www.taobao.com\" , \"video\":\"www.jingdong.com\" , \"score\":\"87.5\" , \"captureTime\":\"2010-11-04 16:19:42\" , \"cameraId\":\"3333\" , \"cameraName\" : \"simple\" , \"cameraLongitude\":\"104.2\" , \"cameraLatitude\":\"89.1\"}";
        kafkaTemplate.send("shiny", demo);
    }
}
