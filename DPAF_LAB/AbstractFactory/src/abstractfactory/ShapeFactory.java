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
public class ShapeFactory extends AbstractFactory {

    @Override
    Colour getColour(String colour) {
        return null;
    }

    @Override
    Shape getShape(String shape) {
        if (shape == null) {
            return null;
        } else if (shape.equals("Circle")) {
            return (new Circle(5));
        } else if (shape.equals("Rectangle")) {
            return (new Rectangle(3, 3));
        } else {
            return null;
        }
    }
}
