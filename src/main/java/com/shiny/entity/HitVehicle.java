package com.shiny.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * collection 为集合名字
 */
@Document(collection = "HitVehicle")
public class HitVehicle {
    @Id
    private String id;

    private String cameraId;
    private String cameraName;
    private BigDecimal cameraLatitude;
    private BigDecimal cameraLongitude;
    private String captureId;
    private Timestamp captureTime;
    private String vehicleId;
    private String vehicleNum;
    private String url;
    private String licensePlateText;
    private String place;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BigDecimal getCameraLatitude() {
        return cameraLatitude;
    }

    public void setCameraLatitude(BigDecimal cameraLatitude) {
        this.cameraLatitude = cameraLatitude;
    }

    public BigDecimal getCameraLongitude() {
        return cameraLongitude;
    }

    public void setCameraLongitude(BigDecimal cameraLongitude) {
        this.cameraLongitude = cameraLongitude;
    }

    public String getCaptureId() {
        return captureId;
    }

    public void setCaptureId(String captureId) {
        this.captureId = captureId;
    }

    public Timestamp getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Timestamp captureTime) {
        this.captureTime = captureTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLicensePlateText() {
        return licensePlateText;
    }

    public void setLicensePlateText(String licensePlateText) {
        this.licensePlateText = licensePlateText;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "HitVehicle{" +
                "id='" + id + '\'' +
                ", cameraId='" + cameraId + '\'' +
                ", cameraName='" + cameraName + '\'' +
                ", cameraLatitude=" + cameraLatitude +
                ", cameraLongitude=" + cameraLongitude +
                ", captureId='" + captureId + '\'' +
                ", captureTime=" + captureTime +
                ", vehicleId='" + vehicleId + '\'' +
                ", vehicleNum='" + vehicleNum + '\'' +
                ", url='" + url + '\'' +
                ", licensePlateText='" + licensePlateText + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
