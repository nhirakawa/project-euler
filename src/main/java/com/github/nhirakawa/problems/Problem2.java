package com.github.nhirakawa.problems;

import static com.github.nhirakawa.problems.MathUtils.fibonacci;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem2 extends Problem {

  @Override
  public Answer solve() {
    int i = 1;
    long fib = 0;
    int sum = 0;
    while (fib < 4_000_000) {
      fib = fibonacci(i++);
      if (fib % 2 == 0) {
        sum += fib;
      }
    }
    return new Answer<>(sum);
  }

}
