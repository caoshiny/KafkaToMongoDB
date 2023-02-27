package com.shiny.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * collection 为集合名字
 */
@Document(collection = "CapturePerson")
public class CapturePerson {
    @Id
    private String index;

    private String id;
    private String position;
    private BigDecimal lon;
    private BigDecimal lat;
    private String passerbyId;
    private String detectType;
    private String capturedTime;
    private String cameraId;
    private String cameraName;
    private String place;
    private String url;
    private String fullUrl;
    private Integer gender;
    private Integer age;
    private Integer passerbyMinority;
    private Integer beardStatus;
    private Integer eyeStatus;
    private Integer headwearStatus;
    private Integer mouthStatus;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getPasserbyId() {
        return passerbyId;
    }

    public void setPasserbyId(String passerbyId) {
        this.passerbyId = passerbyId;
    }

    public String getDetectType() {
        return detectType;
    }

    public void setDetectType(String detectType) {
        this.detectType = detectType;
    }

    public String getCapturedTime() {
        return capturedTime;
    }

    public void setCapturedTime(String capturedTime) {
        this.capturedTime = capturedTime;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPasserbyMinority() {
        return passerbyMinority;
    }

    public void setPasserbyMinority(Integer passerbyMinority) {
        this.passerbyMinority = passerbyMinority;
    }

    public Integer getBeardStatus() {
        return beardStatus;
    }

    public void setBeardStatus(Integer beardStatus) {
        this.beardStatus = beardStatus;
    }

    public Integer getEyeStatus() {
        return eyeStatus;
    }

    public void setEyeStatus(Integer eyeStatus) {
        this.eyeStatus = eyeStatus;
    }

    public Integer getHeadwearStatus() {
        return headwearStatus;
    }

    public void setHeadwearStatus(Integer headwearStatus) {
        this.headwearStatus = headwearStatus;
    }

    public Integer getMouthStatus() {
        return mouthStatus;
    }

    public void setMouthStatus(Integer mouthStatus) {
        this.mouthStatus = mouthStatus;
    }

    @Override
    public String toString() {
        return "CapturePerson{" +
                "index='" + index + '\'' +
                ", id='" + id + '\'' +
                ", position='" + position + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", passerbyId='" + passerbyId + '\'' +
                ", detectType='" + detectType + '\'' +
                ", capturedTime='" + capturedTime + '\'' +
                ", cameraId='" + cameraId + '\'' +
                ", cameraName='" + cameraName + '\'' +
                ", place='" + place + '\'' +
                ", url='" + url + '\'' +
                ", fullUrl='" + fullUrl + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", passerbyMinority=" + passerbyMinority +
                ", beardStatus=" + beardStatus +
                ", eyeStatus=" + eyeStatus +
                ", headwearStatus=" + headwearStatus +
                ", mouthStatus=" + mouthStatus +
                '}';
    }
}
