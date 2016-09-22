package com.github.nhirakawa.problems.problem2;

import java.util.HashMap;
import java.util.Map;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem2 implements Problem {

  private final Map<Integer, Long> memo;

  public Problem2() {
    this.memo = new HashMap<>();
  }

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
    return new Answer(sum);
  }

  public long fibonacci(int i) {
    if (i < 1) {
      throw new IllegalArgumentException(String.format("%d is less than 1", i));
    }
    if (i == 1 || i == 2) {
      return i;
    }
    return memo.computeIfAbsent(i, integer -> fibonacci(i - 1) + fibonacci(i - 2));
  }

}
