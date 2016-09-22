package com.github.nhirakawa.problems.problem11;

import static com.github.nhirakawa.problems.MathUtils.getFactors;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem11 implements Problem {

  @Override
  public Answer solve() {
    long index = 1;
    long triangle = 1;
    while (getFactors(triangle).size() < 500) {
      index++;
      triangle += index;
    }
    return new Answer(triangle);
  }

}
