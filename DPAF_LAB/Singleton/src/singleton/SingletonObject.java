/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author Yash
 */
public class SingletonObject {

    private SingletonObject() {
    }
    private static SingletonObject sob = new SingletonObject();

    public static SingletonObject getInstance() {
        return sob;
    }

    public void printMessage() {
        System.out.println("Hello World");
    }
}
