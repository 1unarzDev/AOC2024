import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Twelve {
    private static Map<Point, Integer> groups = new HashMap<>();
    private static ArrayList<Integer> areas = new ArrayList<>();
    private static ArrayList<Integer> perimeters = new ArrayList<>();
    private static List<String> garden;
    public static void main(String[] args) throws IOException {
        garden = Files.readAllLines(Paths.get("twelve.txt"));
        int group = 0;
        int total = 0;
        for(int i = 0; i < garden.size(); i++){
            for(int j = 0; j < garden.get(i).length(); j++){
                Point pt = new Point(i, j);
                if (!groups.containsKey(pt)) {
                    findGroup(pt, new Point(-1, -1), group);
                    group++;
                }
            }
        }

        for(int i = 0; i < group; i++) total += areas.get(i) * perimeters.get(i);
        System.out.println(total);
    }

    private static void findGroup(Point pt, Point prevPt, int group) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if(!groups.containsKey(pt)) groups.put(pt, group);
        for (int[] direction : directions) { 
            Point nextPt = new Point(pt.y + direction[0], pt.x + direction[1]);
            if (nextPt.y < 0 || garden.size() <= nextPt.y || nextPt.x < 0 || garden.get(nextPt.y).length() <= nextPt.x) continue;
            if (nextPt.equals(prevPt)) continue;
            if (garden.get(nextPt.y).charAt(nextPt.x) != garden.get(pt.y).charAt(nextPt.x)) continue;
            findGroup(nextPt, pt, group);
        }
    }

    private static class Point {
        int x, y;

        Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
