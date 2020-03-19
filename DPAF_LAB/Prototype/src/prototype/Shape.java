/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

/**
 *
 * @author Yash
 */
public abstract class Shape implements Cloneable {

    private String shapeID;
    protected String type;

    abstract void draw();

    public String getShapeID() {
        return shapeID;
    }

    public String getType() {
        return type;
    }

    public void setShapeID(String shapeID) {
        this.shapeID = shapeID;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
