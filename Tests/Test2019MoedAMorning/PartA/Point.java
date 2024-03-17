import java.util.*;

class Point {
    private int x,y;
    public Point(int x, int y){
        this.x =x;
        this.y = y;
    }
    // the distance from the origin point
    public double norm(){ return Math.sqrt(x * x + y * y);}

    public Point add(Point other){ return new Point(this.x + other.x, this.y + other.y);}


    public int getX(){return x;}

    public int getY(){return y;}

}
class Origin {
    public static List<Point> getKClosestToOrigin(List<Point> points, int k) {
        TreeMap<Double, Point> distanceMap = new TreeMap<>();
        for (Point point : points) {
            distanceMap.put(point.norm(), point);
        }
        List<Point> res = new ArrayList<>(k);
        Iterator<Map.Entry<Double, Point>> entry = distanceMap.entrySet().iterator();
        for (int i = 0; i < k; i++) {
            res.add(entry.next().getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0,1));
        points.add(new Point(4,0));
        points.add(new Point(0,6));
        points.add(new Point(0,3));
        points.add(new Point(2,0));
        points.add(new Point(5,0));

        List<Point> res = getKClosestToOrigin(points, 3);
        for(var point: res){
            System.out.println("x = " + point.getX() + " y = " +point.getY());
        }
    }
}

