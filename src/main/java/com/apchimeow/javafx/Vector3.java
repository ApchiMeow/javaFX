package com.apchimeow.javafx;

public class Vector3 {
    private double x;
    private double y;
    private double z;

    Vector3(double x, double y, double z){
        setX(x);
        setY(y);
        setZ(z);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(" + getX() + "," + getZ() + "," + getY() + ")");
    }
}
