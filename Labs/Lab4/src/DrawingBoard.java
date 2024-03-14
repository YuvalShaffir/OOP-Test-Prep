public class DrawingBoard {

    public static void main(String[] args) {
        DrawingBoard board = new DrawingBoard();
        board.draw(new Circle(7));
        board.draw(new Square(4));
    }

    public void draw(Shape shape) {
        shape.draw();
    }
}

interface Drawable {
    void draw();
}


class Shape implements Drawable{
    private final int length;

    public Shape(int length){
        this.length = length;
    }

    public int getShapeLength(){
        return length;
    }

    public void draw(){

    }
}

class Circle extends Shape {

    public Circle(int radius) {
        super(radius);
    }

    @Override
    public int getShapeLength(){
        return super.getShapeLength();
    }

    @Override
    public void draw(){
        System.out.println("Drawing circle with radius " + getShapeLength());
    }
}

class Square extends Shape{
    public Square(int width) {
        super(width);
    }

    @Override
    public int getShapeLength(){
        return super.getShapeLength();
    }

    @Override
    public void draw(){
        System.out.println("Drawing square with width " + getShapeLength());
    }
}
