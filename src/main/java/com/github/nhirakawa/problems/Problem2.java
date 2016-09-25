package com.github.nhirakawa.problems;

import static com.github.nhirakawa.problems.MathUtils.fibonacci;

import java.math.BigInteger;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem2 extends Problem {

  @Override
  public Answer solve() {
    int i = 1;
    BigInteger fib = BigInteger.ZERO;
    int sum = 0;
    while (fib.intValue() < 4_000_000) {
      fib = fibonacci(i++);
      if (fib.intValue() % 2 == 0) {
        sum += fib.intValue();
      }
    }
    return new Answer<>(sum);
  }

}
