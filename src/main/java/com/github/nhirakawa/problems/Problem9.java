package com.github.nhirakawa.problems;

import static com.github.nhirakawa.MathUtils.isPythagorean;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem9 extends Problem {

  @Override
  public Answer solve() {
    for (int i = 1; i < 1000; i++) {
      for (int j = 1; j < 1000; j++) {
        for (int k = 1; k < 1000; k++) {
          if (i + j + k > 1000) {
            break;
          }
          if (i + j + k == 1000 && isPythagorean(i, j, k)) {
            return new Answer<>(i * j * k);
          }
        }
      }
    }
    return null;
  }

}
