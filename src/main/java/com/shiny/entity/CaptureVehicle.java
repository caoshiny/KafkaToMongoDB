package com.shiny.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * collection 为集合名字
 */
@Document(collection = "CaptureVehicle")
public class CaptureVehicle {
    @Id
    private String index;

    private String id;
    private String detectType;
    private String capturedTime;
    private String cameraId;
    private String cameraName;
    private String place;
    private String url;
    private String fullUrl;
    private String motorAuxSeatHasPerson;
    private String vehicleColor;
    private String licensePlateColor;
    private String licensePlateText;
    private String vehicleSunroof;
    private String motorBrand;
    private String vehicleRack;
    private String motorAuxSeatbelt;
    private String motorCategory;
    private String motorAuxSunvisor;
    private String motorAnnualInspection;
    private String vehicleSpray;
    private String motorDecoration;
    private String motorPendant;
    private String motorMainSunvisor;
    private String vehicleOrientation;
    private String motorMainSeatbelt;
    private String motorPhone;
    private String albumImgId;

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

    public String getMotorAuxSeatHasPerson() {
        return motorAuxSeatHasPerson;
    }

    public void setMotorAuxSeatHasPerson(String motorAuxSeatHasPerson) {
        this.motorAuxSeatHasPerson = motorAuxSeatHasPerson;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getLicensePlateColor() {
        return licensePlateColor;
    }

    public void setLicensePlateColor(String licensePlateColor) {
        this.licensePlateColor = licensePlateColor;
    }

    public String getLicensePlateText() {
        return licensePlateText;
    }

    public void setLicensePlateText(String licensePlateText) {
        this.licensePlateText = licensePlateText;
    }

    public String getVehicleSunroof() {
        return vehicleSunroof;
    }

    public void setVehicleSunroof(String vehicleSunroof) {
        this.vehicleSunroof = vehicleSunroof;
    }

    public String getMotorBrand() {
        return motorBrand;
    }

    public void setMotorBrand(String motorBrand) {
        this.motorBrand = motorBrand;
    }

    public String getVehicleRack() {
        return vehicleRack;
    }

    public void setVehicleRack(String vehicleRack) {
        this.vehicleRack = vehicleRack;
    }

    public String getMotorAuxSeatbelt() {
        return motorAuxSeatbelt;
    }

    public void setMotorAuxSeatbelt(String motorAuxSeatbelt) {
        this.motorAuxSeatbelt = motorAuxSeatbelt;
    }

    public String getMotorCategory() {
        return motorCategory;
    }

    public void setMotorCategory(String motorCategory) {
        this.motorCategory = motorCategory;
    }

    public String getMotorAuxSunvisor() {
        return motorAuxSunvisor;
    }

    public void setMotorAuxSunvisor(String motorAuxSunvisor) {
        this.motorAuxSunvisor = motorAuxSunvisor;
    }

    public String getMotorAnnualInspection() {
        return motorAnnualInspection;
    }

    public void setMotorAnnualInspection(String motorAnnualInspection) {
        this.motorAnnualInspection = motorAnnualInspection;
    }

    public String getVehicleSpray() {
        return vehicleSpray;
    }

    public void setVehicleSpray(String vehicleSpray) {
        this.vehicleSpray = vehicleSpray;
    }

    public String getMotorDecoration() {
        return motorDecoration;
    }

    public void setMotorDecoration(String motorDecoration) {
        this.motorDecoration = motorDecoration;
    }

    public String getMotorPendant() {
        return motorPendant;
    }

    public void setMotorPendant(String motorPendant) {
        this.motorPendant = motorPendant;
    }

    public String getMotorMainSunvisor() {
        return motorMainSunvisor;
    }

    public void setMotorMainSunvisor(String motorMainSunvisor) {
        this.motorMainSunvisor = motorMainSunvisor;
    }

    public String getVehicleOrientation() {
        return vehicleOrientation;
    }

    public void setVehicleOrientation(String vehicleOrientation) {
        this.vehicleOrientation = vehicleOrientation;
    }

    public String getMotorMainSeatbelt() {
        return motorMainSeatbelt;
    }

    public void setMotorMainSeatbelt(String motorMainSeatbelt) {
        this.motorMainSeatbelt = motorMainSeatbelt;
    }

    public String getMotorPhone() {
        return motorPhone;
    }

    public void setMotorPhone(String motorPhone) {
        this.motorPhone = motorPhone;
    }

    public String getAlbumImgId() {
        return albumImgId;
    }

    public void setAlbumImgId(String albumImgId) {
        this.albumImgId = albumImgId;
    }

    @Override
    public String toString() {
        return "CaptureVehicle{" +
                "index='" + index + '\'' +
                ", id='" + id + '\'' +
                ", detectType='" + detectType + '\'' +
                ", capturedTime='" + capturedTime + '\'' +
                ", cameraId='" + cameraId + '\'' +
                ", cameraName='" + cameraName + '\'' +
                ", place='" + place + '\'' +
                ", url='" + url + '\'' +
                ", fullUrl='" + fullUrl + '\'' +
                ", motorAuxSeatHasPerson='" + motorAuxSeatHasPerson + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", licensePlateColor='" + licensePlateColor + '\'' +
                ", licensePlateText='" + licensePlateText + '\'' +
                ", vehicleSunroof='" + vehicleSunroof + '\'' +
                ", motorBrand='" + motorBrand + '\'' +
                ", vehicleRack='" + vehicleRack + '\'' +
                ", motorAuxSeatbelt='" + motorAuxSeatbelt + '\'' +
                ", motorCategory='" + motorCategory + '\'' +
                ", motorAuxSunvisor='" + motorAuxSunvisor + '\'' +
                ", motorAnnualInspection='" + motorAnnualInspection + '\'' +
                ", vehicleSpray='" + vehicleSpray + '\'' +
                ", motorDecoration='" + motorDecoration + '\'' +
                ", motorPendant='" + motorPendant + '\'' +
                ", motorMainSunvisor='" + motorMainSunvisor + '\'' +
                ", vehicleOrientation='" + vehicleOrientation + '\'' +
                ", motorMainSeatbelt='" + motorMainSeatbelt + '\'' +
                ", motorPhone='" + motorPhone + '\'' +
                ", albumImgId='" + albumImgId + '\'' +
                '}';
    }
}
