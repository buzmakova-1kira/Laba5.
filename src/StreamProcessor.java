import java.util.List;
import java.util.stream.Collectors;

class StreamProcessor {
    public static Polyline processPoints(List<Point> points) {
        List<Point> processedPoints = points.stream()
                .distinct()
                .sorted((p1, p2) -> p1.getX() - p2.getX())
                .map(p -> {
                    if (p.getY() < 0) {
                        return new Point(p.getX(), -p.getY());
                    }
                    return p;
                })
                .collect(Collectors.toList());

        Polyline polyline = new Polyline();
        polyline.addAllPoints(processedPoints);
        return polyline;
    }
}