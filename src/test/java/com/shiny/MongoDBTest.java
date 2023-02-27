package com.shiny;

import com.alibaba.fastjson.JSONObject;
import com.shiny.entity.HitPerson;
import com.shiny.service.impl.HitPersonImpl;
import com.shiny.util.GetInfoFromYml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBTest {
    @Autowired
    private HitPersonImpl hitPersonImpl;

    @Autowired
    private GetInfoFromYml getInfoFromYml;

    @Test
    public void saveHitPersonTest(){
        String demo = "{\"personId\":\"5489425\" , \"personNum\":\"1111\" , \"captureId\":\"2222\" , \"url\":\"https://img0.baidu.com/it/u=3101694723,748884042&fm=26&fmt=auto&gp=0.jpg\" , \"fullUrl\":\"https://img0.baidu.com/it/u=1387837532,3545765543&fm=11&fmt=auto&gp=0.jpg\" , \"video\":\"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4\" , \"score\":\"87.5\" , \"captureTime\":\"2010-11-04 16:19:42\" , \"cameraId\":\"3333\" , \"cameraName\" : \"simple\" , \"cameraLongitude\":\"104.2\" , \"cameraLatitude\":\"89.1\"}";
        // String -> Json
        JSONObject json = JSONObject.parseObject(demo);

        // 解析Json
        HitPerson hitPerson = new HitPerson();
        hitPerson.setPersonId(json.getString("personId"));
        hitPerson.setPersonNum(json.getString("personNum"));
        hitPerson.setCaptureId(json.getString("captureId"));

        Map<String, Object> UrlMap = new HashMap<>();
        UrlMap.put("type", 0);
        // 根据fileUrl获取文件名全名 fileAllName 中标时间 captureTime
        String [] strArray = json.getString("url").split("/");
        String fileAllName = strArray[strArray.length - 1];
        String captureTime = json.getString("captureTime").split(" ")[0];
        captureTime = captureTime.replace("-","");
        String url = "file/upload/business/hit/" + captureTime + "/" + fileAllName;
        UrlMap.put("url", url);

        Map<String, Object> FullUrlMap = new HashMap<>();
        FullUrlMap.put("type", 1);
        strArray = json.getString("fullUrl").split("/");
        fileAllName = strArray[strArray.length - 1];
        String fullUrl = "file/upload/business/hit/" + captureTime + "/" + fileAllName;
        FullUrlMap.put("url", fullUrl);

        hitPerson.setVideoUrl(json.getString("videoUrl"));
        hitPerson.setScore(json.getFloat("score"));
        hitPerson.setCaptureTime(Timestamp.valueOf(json.getString("captureTime")));
        hitPerson.setCameraId(json.getString("cameraId"));
        hitPerson.setCameraName(json.getString("cameraName"));
        hitPerson.setLongitude(json.getBigDecimal("cameraLongitude"));
        hitPerson.setLatitude(json.getBigDecimal("cameraLatitude"));

        // 把两条url信息转成Json格式
        JSONObject jsonUrl = (JSONObject) JSONObject.toJSON(UrlMap);
        JSONObject jsonFullUrl = (JSONObject) JSONObject.toJSON(FullUrlMap);

        // 把两条Json存入数组
        JSONObject[] UrlArray = new JSONObject[2];
        UrlArray[0] = jsonUrl;
        UrlArray[1] = jsonFullUrl;

        hitPerson.setProtoList(UrlArray);
        hitPerson.setHit(true);
        hitPerson.setDataType("Camera");

        hitPersonImpl.saveHitPerson(hitPerson);
    }
}
