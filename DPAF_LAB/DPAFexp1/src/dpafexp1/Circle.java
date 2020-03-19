/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpafexp1;

/**
 *
 * @author Yash
 */
public class Circle extends Shape implements Rollable {

    private Point center; // Circle "contains" a Point object
    private int radius;

    public Circle(int x, int y, int r) {
        center = new Point(x, y);
        radius = r;
    }

    public String toString() {
        return "center = " + center + " and radius = " + radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void roll(float degree) {
        // implement rolling functionality here
        System.out.println("Circle rolled "+degree+" degrees");
    }

}
