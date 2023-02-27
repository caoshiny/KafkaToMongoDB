package com.shiny.util;

import com.alibaba.fastjson.JSONObject;
import com.shiny.entity.HitPerson;
import com.shiny.service.impl.HitPersonImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class SaveHitPersonToMongoDB {
    @Autowired
    HitPersonImpl hitPersonImpl;

    @Autowired
    DownloadPicByUrl downloadPicByUrl;

    @Autowired
    GetInfoFromYml getInfoFromYml;

    public void saveDataToMongo(String KafkaStr) throws IOException {
        // 将接收到的String类型转换为Json类型
        JSONObject KafkaJson = null;
        try {
            KafkaJson = JSONObject.parseObject(KafkaStr);
        }catch (Exception e){
            log.info("程序执行String -> Json失败: " + e);
        }

        if(KafkaJson != null) {
            // 解析Json字符串并存入MongoDB
            HitPerson hitPerson = new HitPerson();
            hitPerson.setPersonId(KafkaJson.getString("personId"));
            hitPerson.setPersonNum(KafkaJson.getString("personNum"));
            hitPerson.setCaptureId(KafkaJson.getString("captureId"));
            hitPerson.setVideoUrl(KafkaJson.getString("videoUrl"));
            hitPerson.setScore(KafkaJson.getFloat("score"));
            hitPerson.setCaptureTime(Timestamp.valueOf(KafkaJson.getString("captureTime")));
            hitPerson.setCameraId(KafkaJson.getString("cameraId"));
            hitPerson.setCameraName(KafkaJson.getString("cameraName"));
            hitPerson.setLongitude(KafkaJson.getBigDecimal("cameraLongitude"));
            hitPerson.setLatitude(KafkaJson.getBigDecimal("cameraLatitude"));
            hitPerson.setHit(true);
            hitPerson.setDataType("Camera");

            Map<String, Object> UrlMap = new HashMap<>();
            UrlMap.put("type", 0);
            // 根据fileUrl获取文件名全名 fileAllName 中标时间 captureTime
            String [] strArray = KafkaJson.getString("url").split("/");
            String fileAllName = strArray[strArray.length - 1];
            String captureTime = KafkaJson.getString("captureTime").split(" ")[0];
            captureTime = captureTime.replace("-","");
            String url = "file/upload/business/hit/" + captureTime + "/" + fileAllName;
            UrlMap.put("url", url);

            Map<String, Object> FullUrlMap = new HashMap<>();
            FullUrlMap.put("type", 1);
            strArray = KafkaJson.getString("fullUrl").split("/");
            fileAllName = strArray[strArray.length - 1];
            String fullUrl = "file/upload/business/hit/" + captureTime + "/" + fileAllName;
            FullUrlMap.put("url", fullUrl);

            // 把两条url信息转成Json格式
            JSONObject jsonUrl = (JSONObject) JSONObject.toJSON(UrlMap);
            JSONObject jsonFullUrl = (JSONObject) JSONObject.toJSON(FullUrlMap);

            // 把两条Json存入数组
            JSONObject[] UrlArray = new JSONObject[2];
            UrlArray[0] = jsonUrl;
            UrlArray[1] = jsonFullUrl;
            hitPerson.setProtoList(UrlArray);

            // 根据url保存图片到本地
            downloadPicByUrl.downloadPic(KafkaJson.getString("url"), captureTime);
            downloadPicByUrl.downloadPic(KafkaJson.getString("fullUrl"), captureTime);

            // 录入到数据库
            try {
                hitPersonImpl.saveHitPerson(hitPerson);
                log.info("==============存入到MongoDB成功！！！==============");
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
        }else {
            log.error("Kafka Json 为 null！");
        }
    }
}
