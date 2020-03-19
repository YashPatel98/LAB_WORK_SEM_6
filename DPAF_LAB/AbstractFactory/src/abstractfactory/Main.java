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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");
        //get an object of Shape Circle
        Shape shape1 = shapeFactory.getShape("Circle");
        //call draw method of Shape Circle
        shape1.area();
        shape1.perimeter();
        //get an object of Shape Rectangle
        Shape shape2 = shapeFactory.getShape("Rectangle");
        //call draw method of Shape Rectangle
        shape2.area();
        shape2.perimeter();
        AbstractFactory colorFactory = FactoryProducer.getFactory("Colour");
        //get an object of Color Red
        Colour color1 = colorFactory.getColour("Red");
        //call fill method of Red
        color1.fill();
        //get an object of Color Green
        Colour color2 = colorFactory.getColour("Green");
        //call fill method of Green
        color2.fill();
    }
}    
