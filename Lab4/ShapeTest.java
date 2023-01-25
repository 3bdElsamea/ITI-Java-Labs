import java.util.ArrayList;

abstract class Shape {
    public abstract void draw();
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a  Rectangle");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

public class ShapeTest {

    public static void drawShapes(ArrayList<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void main(String[] args) {
        ArrayList<Rectangle> rectanglesList = new ArrayList<Rectangle>();
        rectanglesList.add(new Rectangle());
        rectanglesList.add(new Rectangle());
        rectanglesList.add(new Rectangle());

        ArrayList<Circle> circlesList = new ArrayList<Circle>();
        circlesList.add(new Circle());
        circlesList.add(new Circle());
        circlesList.add(new Circle());

        drawShapes(rectanglesList);
        drawShapes(circlesList);
    }
}
