/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw05.entity;

/**
 *
 * @author user
 */
public class Gun {
    private String model;
    private String handy;
    private String origin;
    private String serial;
    private int distance;
    private boolean optics;

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the handy
     */
    public String getHandy() {
        return handy;
    }

    /**
     * @param handy the handy to set
     */
    public void setHandy(String handy) {
        this.handy = handy;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * @return the range
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param range the range to set
     */
    public void setDistance(int range) {
        this.distance = range;
    }

    /**
     * @return the optics
     */
    public boolean isOptics() {
        return optics;
    }

    /**
     * @param optics the optics to set
     */
    public void setOptics(boolean optics) {
        this.optics = optics;
    }
    
}
