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
public abstract class AbstractFactory {

    abstract Colour getColour(String colour);

    abstract Shape getShape(String shape);
}
