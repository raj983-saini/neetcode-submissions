
class CountSquares {

    private Map<String, Integer> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];

        points.put(key, points.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];

        int result = 0;

        for (String key : points.keySet()) {
            String[] coordinates = key.split(",");

            int x2 = Integer.parseInt(coordinates[0]);
            int y2 = Integer.parseInt(coordinates[1]);

            // The points must be diagonally opposite
            if (Math.abs(x1 - x2) == Math.abs(y1 - y2)
                    && x1 != x2) {

                int diagonalCount = points.get(key);
                int verticalCount =
                    points.getOrDefault(x1 + "," + y2, 0);
                int horizontalCount =
                    points.getOrDefault(x2 + "," + y1, 0);

                result += diagonalCount
                        * verticalCount
                        * horizontalCount;
            }
        }

        return result;
    }
}
