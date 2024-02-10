package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Point getBeginPoint() {
        return beginPoint;
    }

    public void setBeginPoint(Point beginPoint) {
        this.beginPoint = beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Point getMidPoint() {
        int x1 = beginPoint.getX();
        int y1 = beginPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();

        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        return new Point(midX, midY);
    }

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }
}
// END
