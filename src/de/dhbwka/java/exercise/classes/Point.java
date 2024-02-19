package de.dhbwka.java.exercise.classes;

public class Point {
    private double x, y;

    public static void main(String[] args) {
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: "
                + pointA.distance(pointB));
        pointA = pointA.mirror();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: "
                + pointA.distance(pointB));
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    public double distance(Point point) {
        return Math.sqrt((x - point.getX()) * (x - point.getX()) + (y - point.getY()) * (y - point.getY()));
    }

    public Point mirrorX() {
        return new Point(x, -y);
    }

    public Point mirrorY() {
        return new Point(-x, y);
    }

    public Point mirror() {
        return new Point(-x, -y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
