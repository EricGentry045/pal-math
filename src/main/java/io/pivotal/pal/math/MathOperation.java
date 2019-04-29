package io.pivotal.pal.math;

public class MathOperation implements MathInterface{
    private double xNumber;
    private double yNumber;

    public MathOperation() {
    }

    public MathOperation(double xNumber, double yNumber) {
        this.xNumber = xNumber;
        this.yNumber = yNumber;
    }

    public double getxNumber() {
        return xNumber;
    }

    public void setxNumber(double xNumber) {
        this.xNumber = xNumber;
    }

    public double getyNumber() {
        return yNumber;
    }

    public void setyNumber(double yNumber) {
        this.yNumber = yNumber;
    }

    public double addition() { return xNumber + yNumber; }
    public double subtraction() { return xNumber - yNumber; }
    public double multiplication() { return xNumber * yNumber; }
    public double division() { return xNumber / yNumber; }
}
