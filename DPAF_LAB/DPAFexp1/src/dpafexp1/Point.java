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
public class Point {

    private int xPos;
    private int yPos;

    public Point(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public String toString() {
        return "(" + xPos + "," + yPos + ")";
    }
}
