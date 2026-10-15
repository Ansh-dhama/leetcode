class Solution {
    public int minBitFlips(int start, int goal) {
      int different = start ^ goal;

      return Integer.bitCount(different);

    }
}