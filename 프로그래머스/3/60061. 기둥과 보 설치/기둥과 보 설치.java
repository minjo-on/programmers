import java.util.*;

public class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> builds = new ArrayList<>();

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int type = build[2];
            int action = build[3];

            if (action == 1) {
                builds.add(new int[]{x, y, type});
                if (!canRemain(builds)) {
                    builds.remove(builds.size() - 1);
                }
            } else {
                builds.removeIf(b -> b[0] == x && b[1] == y && b[2] == type);
                if (!canRemain(builds)) {
                    builds.add(new int[]{x, y, type});
                }
            }
        }

        builds.sort((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        return builds.toArray(new int[builds.size()][]);
    }

    private boolean canRemain(List<int[]> builds) {
        for (int[] build : builds) {
            int x = build[0];
            int y = build[1];
            int type = build[2];

            if (type == 0) {
                if (!(y == 0 || contains(builds, x, y - 1, 0) || contains(builds, x - 1, y, 1) || contains(builds, x, y, 1))) {
                    return false;
                }
            } else {
                if (!(contains(builds, x, y - 1, 0) || contains(builds, x + 1, y - 1, 0) || (contains(builds, x - 1, y, 1) && contains(builds, x + 1, y, 1)))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean contains(List<int[]> builds, int x, int y, int type) {
        for (int[] b : builds) {
            if (b[0] == x && b[1] == y && b[2] == type) {
                return true;
            }
        }
        return false;
    }
}
