package com.github.nhirakawa.problems;

import static com.github.nhirakawa.MathUtils.getDivisors;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem12 extends Problem {

  @Override
  public Answer solve() {
    long index = 1;
    long triangle = 1;
    while (getDivisors(triangle).size() < 500) {
      index++;
      triangle += index;
    }
    return new Answer<>(triangle);
  }

}
