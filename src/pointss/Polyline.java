package pointss;
import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline() {
        this.points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void addAllPoints(List<Point> points) {
        this.points.addAll(points);
    }

    @Override
    public String toString() {
        return "Линия " + points.toString();
    }
}