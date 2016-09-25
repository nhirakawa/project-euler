package com.github.nhirakawa.problems;

import java.util.stream.LongStream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.MathUtils;
import com.github.nhirakawa.Problem;

public class Problem6 extends Problem {

  @Override
  public Answer solve() {
    long difference = Math.abs(sumOfSquares(LongStream.range(1, 101)) - squareOfSum(LongStream.range(1, 101)));
    return new Answer<>(difference);
  }

  private static long squareOfSum(LongStream numbers) {
    return MathUtils.square(numbers.sum());
  }

  private static long sumOfSquares(LongStream numbers) {
    return numbers.map(MathUtils::square).sum();
  }

}
