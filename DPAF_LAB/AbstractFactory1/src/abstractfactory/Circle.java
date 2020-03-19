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
public class Circle implements Shape {

    private int rad;
    private double area, perimeter;

    public Circle(int rad) {
        this.rad = rad;
    }

    @Override
    public void area() {
        area = 3.14 * rad * rad;
        System.out.println("Area of circle: " + area);
    }

    @Override
    public void perimeter() {
        perimeter = 2 * 3.14 * rad;
        System.out.println("Perimeter of circle: " + perimeter);
    }
}
