/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

import java.util.Hashtable;

/**
 *
 * @author Yash
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setShapeID("1");
        shapeMap.put(circle.getShapeID(), circle);
        Square square = new Square();
        square.setShapeID("2");
        shapeMap.put(square.getShapeID(), square);
        Rectangle rectangle = new Rectangle();
        rectangle.setShapeID("3");
        shapeMap.put(rectangle.getShapeID(), rectangle);
    }
}
