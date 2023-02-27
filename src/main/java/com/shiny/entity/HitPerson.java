package com.shiny.entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * collection 为集合名字
 */
@Document(collection = "HitPerson")
public class HitPerson {
    @Id
    private String id;

    private String personId;
    private String personNum;
    private String captureId;
    private JSONObject[] protoList;
    private String videoUrl;
    private Float score;
    private Timestamp captureTime;
    private String cameraId;
    private String cameraName;
    private BigDecimal Longitude;
    private BigDecimal Latitude;
    private boolean hit;
    private String dataType;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonNum() {
        return personNum;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public String getCaptureId() {
        return captureId;
    }

    public void setCaptureId(String captureId) {
        this.captureId = captureId;
    }

    public JSONObject[] getProtoList() {
        return protoList;
    }

    public void setProtoList(JSONObject[] protoList) {
        this.protoList = protoList;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Timestamp getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Timestamp captureTime) {
        this.captureTime = captureTime;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public BigDecimal getLongitude() {
        return Longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        Longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return Latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        Latitude = latitude;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
