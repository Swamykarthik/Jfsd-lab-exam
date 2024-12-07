package com.klef.jfsd.exam;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "smartphone")
public class Smartphone extends Device {
    private String operatingSystem;
    private double cameraResolution;

    // Getters and setters
    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(double cameraResolution) {
        this.cameraResolution = cameraResolution;
    }
}
