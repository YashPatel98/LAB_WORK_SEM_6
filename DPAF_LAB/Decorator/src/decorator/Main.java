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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pizza pizza = new Margherita(); 
        System.out.println( pizza.getDescription() + "\n Cost :" + pizza.getCost()); 
        pizza = new Tomato(pizza);
        System.out.println( pizza.getDescription() + "\n Cost :" + pizza.getCost());

        Pizza pizza2 = new FarmHouse();
        pizza2 = new Jalapeno(pizza2);
         System.out.println( pizza2.getDescription() + "\n Cost :" + pizza2.getCost());
        pizza2 = new Paneer(pizza2);          
        System.out.println( pizza2.getDescription() + "\n Cost :" + pizza2.getCost()); 
    }
    
}
