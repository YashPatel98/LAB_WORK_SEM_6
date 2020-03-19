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
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if (choice.equals("Shape")) {
            return (new ShapeFactory());
        } else if (choice.equals("Colour")) {
            return (new ColourFactory());
        } else {
            return null;
        }
    }
}
