/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory;

/**
 *
 * @author Yash
 */
public class Rectangle implements Shape {

    private int l, w;
    private double area, perimeter;

    public Rectangle(int l, int w) {
        this.l = l;
        this.w = w;
    }

    @Override
    public void area() {
        area = l * w;
        System.out.println("Area of rectangle:" + area);
    }

    @Override
    public void perimeter() {
        perimeter = 2 * (l + w);
        System.out.println("Perimeter of Rectangle: " + perimeter);
    }
}
