package com.masterclass.oldcontent.section07.challenges.room;

public class Lamp {

    private String style;
    private boolean battery;
    private int globalRating;
    
    public Lamp(String style, boolean battery, int globalRating) {
        this.style = style;
        this.battery = battery;
        this.globalRating = globalRating;
    }

    public void turnOn() {

        System.out.println("Lamp -> Turning on.");
    }
    
    public String getStyle() {
        return style;
    }

    public boolean isBattery() {
        return battery;
    }

    public int getGlobalRating() {
        return globalRating;
    }

    
    
}
