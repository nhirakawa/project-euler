package com.github.nhirakawa.problems;

import static com.github.nhirakawa.MathUtils.isPrime;
import static com.github.nhirakawa.MathUtils.square;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem27 extends Problem {

  @Override
  public Answer solve() {
    long maxIndex = Long.MIN_VALUE;
    long product = Long.MIN_VALUE;
    for (int a = -999; a < 1000; a++) {
      for (int b = -1000; b < 1001; b++) {
        int index = 0;
        try {
          while (isPrime(quadratic(a, b, index))) {
            index++;
          }
        } catch (IllegalArgumentException e) {
          continue;
        }
        if (index > maxIndex) {
          maxIndex = index;
          product = a * b;
        }
      }
    }
    return new Answer<>(product);
  }

  private static long quadratic(long a, long b, long n) {
    return square(n) + a * n + b;
  }

}
