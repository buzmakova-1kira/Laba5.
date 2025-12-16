package pointss;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamProcessor {
    public static Polyline processPoints(List<Point> points) {
        List<Point> processedPoints = points.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .collect(Collectors.toList());

        Polyline polyline = new Polyline();  // ← Теперь работает!
        polyline.addAllPoints(processedPoints);
        return polyline;
    }
}