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
public class Rectangle extends Shape implements Rotatable {

    private int length, height;

    public Rectangle(int l, int h) {
        length = l;
        height = h;
    }

    public double area() {
        return length * height;
    }

    @Override
    public void rotate(float degree) {
        // implement rotating functionality here
        System.out.println("Rectangle rotated "+degree+" degrees");
    }
}
