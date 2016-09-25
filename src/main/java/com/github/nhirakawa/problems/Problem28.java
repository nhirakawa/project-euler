package com.github.nhirakawa.problems;

import static com.github.nhirakawa.problems.MathUtils.square;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem28 extends Problem {

  @Override
  public Answer solve() {
    long sum = 1;
    for (long level = 2; level < 1001; level += 2) {
      sum += getCornersSum(level);
    }
    return new Answer<>(sum);
  }

  private static long getMaxCorner(long level) {
    return square((level) + 1);
  }

  private static long getCornersSum(long level) {
    long cornersSum = 0;
    long maxCorner = getMaxCorner(level);
    for (int i = 0; i < 4; i++) {
      long corner = (maxCorner - (level * i));
      cornersSum += corner;
    }
    return cornersSum;
  }

}
