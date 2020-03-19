/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 *
 * @author Yash
 */
public class Margherita extends Pizza {

    public Margherita() {
        
    }

    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Margherita";
    }

}
