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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Circle circle = new Circle(10,10,20);
        circle.roll(45);
        System.out.println("Area of Circle: "+circle.area());
        
        Rectangle rect = new Rectangle(10,20);
        rect.rotate(20);
        System.out.println("Area of Rectangle: "+rect.area());
        
    }
    
}
