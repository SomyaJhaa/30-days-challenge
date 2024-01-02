class Solution {
  public int[][] highestPeak(int[][] isWater) {
    final int r = isWater.length;
    final int c = isWater[0].length;
    final int[] disha = {0, 1, 0, -1, 0};
    int[][] jawab = new int[r][c];
    Queue<Pair<Integer, Integer>> Q = new ArrayDeque<>();
    Arrays.stream(jawab).forEach(A -> Arrays.fill(A, -1));

    for (int i = 0; i < r; i++){
      for (int j = 0; j < c; j++){
        if (isWater[i][j] == 1) {
            jawab[i][j] = 0;
            Q.offer(new Pair<>(i, j));
        }
       }
    }
    while (!Q.isEmpty()) {
      int i = Q.peek().getKey();
      int j = Q.poll().getValue();
      for (int k = 0; k < 4; ++k) {
        int x = i + disha[k];
        int y = j + disha[k + 1];
        if (x < 0 || y < 0 || x == r || y == c || jawab[x][y] != -1){
          continue;
        }
        Q.offer(new Pair<>(x, y));
        jawab[x][y] = jawab[i][j] + 1;
      }
    }
    return jawab;
  }
}