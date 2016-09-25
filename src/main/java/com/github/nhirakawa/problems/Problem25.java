package com.github.nhirakawa.problems;

import static com.github.nhirakawa.MathUtils.fibonacci;

import java.math.BigInteger;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem25 extends Problem {

  @Override
  public Answer solve() {
    long index = 0;
    BigInteger current = fibonacci(index);
    while (current.toString().length() < 1000) {
      current = fibonacci(index++);
    }
    return new Answer<>(index);
  }

}
