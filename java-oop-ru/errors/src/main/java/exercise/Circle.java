package exercise;

// BEGIN
public class Circle {
    Point point;
    Integer radius;

    public Circle(Point point, Integer radius)  {
        this.point = point;
        this.radius = radius;
    }

    public Integer getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) throw new NegativeRadiusException("");
        return radius * radius * Math.PI;
    }
}
// END
