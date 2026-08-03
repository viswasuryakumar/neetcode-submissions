class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // closest to target first
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double slowestAhead = 0;

        for (double[] car : cars) {
            if (car[1] > slowestAhead) {   // can't catch the fleet ahead
                fleets++;
                slowestAhead = car[1];
            }
            // else: merges, nothing changes
        }

        return fleets;
    }
}