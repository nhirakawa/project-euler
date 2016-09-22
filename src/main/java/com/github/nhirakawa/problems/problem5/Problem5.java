package com.github.nhirakawa.problems.problem5;

import java.util.stream.IntStream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;
import com.github.nhirakawa.problems.MathUtils;

public class Problem5 implements Problem {

  @Override
  public Answer solve() {
    int num = IntStream.range(3, 20).filter(MathUtils::isPrime).reduce((i, j) -> i * j).getAsInt();
    while (!isDivisible(num)) {
      num++;
    }
    return new Answer(num);
  }

  private static boolean isDivisible(int num) {
    for (int i = 1; i <= 20; i++) {
      if (num % i != 0) {
        return false;
      }
    }
    return true;
  }

}
