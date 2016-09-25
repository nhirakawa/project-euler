package com.github.nhirakawa.problems.problem6;

import java.util.stream.LongStream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;
import com.github.nhirakawa.problems.MathUtils;

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
