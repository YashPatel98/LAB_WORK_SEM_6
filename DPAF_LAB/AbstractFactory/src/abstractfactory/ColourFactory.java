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
public class ColourFactory extends AbstractFactory {

    @Override
    Colour getColour(String colour) {
        if (colour == null) {
            return null;
        }
        if (colour.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (colour.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else {
            return null;
        }
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
