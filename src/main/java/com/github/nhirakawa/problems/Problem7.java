package com.github.nhirakawa.problems;

import static com.github.nhirakawa.MathUtils.isPrime;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem7 extends Problem {

  @Override
  public Answer solve() {
    long index = 1;
    long lastPrime = 2;
    while (index < 10001) {
      lastPrime++;
      if (isPrime(lastPrime)) {
        index += 1;
      }
    }
    return new Answer<>(lastPrime);
  }

}
