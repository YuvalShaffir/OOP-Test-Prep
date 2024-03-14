
/*Part 1*/
enum EqualSidedShape{
    /* Declare your enum constants, field constructor and getter*/
    TRIANGLE(3), SQUARE(4), PENTAGON(5);

    private int shape;

    EqualSidedShape(int shape){
        this.shape = shape;
    }

    public int getNumOfEdges() {
        return shape;
    }
}

/*Part 2*/
public class ShapeOperator {

    /*DO NOT CHANGE!!!*/
    public void printShapeEdges(EqualSidedShape shape){
        System.out.println("shape " + shape + " has "
                + shape.getNumOfEdges() + " edges");
    }

    /*add your getShapePerimeter method here*/
    public double getShapePerimeter(EqualSidedShape shape, int length){
        return shape.getNumOfEdges() * length;
    }

    /*DO NOT CHANGE!!!*/
    public static void main(String[] args) {
        ShapeOperator calculator = new ShapeOperator();
        for(EqualSidedShape shape: EqualSidedShape.values()){
            calculator.printShapeEdges(shape);
            System.out.println(calculator.getShapePerimeter(shape, 2));
        }
    }
}



