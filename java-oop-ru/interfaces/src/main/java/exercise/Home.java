package exercise;

// BEGIN
public interface Home {
    double getArea();

    default int compareTo(Home flat) {
        int result = 0;
        if (this.getArea() > flat.getArea()) {
            result = 1;
        } else if (this.getArea() < flat.getArea()) {
            result = -1;
        }
        return result;
    }
}
// END
