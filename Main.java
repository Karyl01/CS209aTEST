public class Main {
    // 计算两点之间的距离的平方
    public static double distanceSquared(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    // 暴力搜索最近点对
    public static PointPair findClosestPair(Point[] points) {
        double minDistance = Double.MAX_VALUE;
        PointPair closestPair = null;

        // 检查所有点对
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distanceSquared(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPair = new PointPair(points[i], points[j]);
                }
            }
        }

        return closestPair;
    }

    // 辅助类，表示点
    public static class Point {
        public final double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // 辅助类，表示点对
    public static class PointPair {
        public final Point p1, p2;

        public PointPair(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    // 测试暴力搜索算法
    public static void main(String[] args) {
        // 创建一些测试点
        Point[] points = {
                new Point(1, 1),
                new Point(1, 9),
                new Point(9, 1),
                new Point(9, 9),
                new Point(0, 10),

        };

        PointPair closestPair = findClosestPair(points);
        System.out.println("Closest pair: (" + closestPair.p1.x + ", " + closestPair.p1.y + ") and (" + closestPair.p2.x + ", " + closestPair.p2.y + ")");
        System.out.println("Distance squared: " + distanceSquared(closestPair.p1, closestPair.p2));
    }
}