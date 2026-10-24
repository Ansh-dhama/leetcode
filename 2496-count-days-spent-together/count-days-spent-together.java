class Solution {
    public int countDaysTogether(
            String arriveAlice, String leaveAlice,
            String arriveBob, String leaveBob) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 31);
        map.put(2, 28);
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);

        int aliceStart = dayNumber(arriveAlice, map);
        int aliceEnd = dayNumber(leaveAlice, map);

        int bobStart = dayNumber(arriveBob, map);
        int bobEnd = dayNumber(leaveBob, map);
        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        return Math.max(0, end - start + 1);
    }

    private int dayNumber(String date, Map<Integer, Integer> map) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int total = day;
        for (int m = 1; m < month; m++) {
            total += map.get(m);
        }

        return total;
    }
}