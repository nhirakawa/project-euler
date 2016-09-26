package com.github.nhirakawa.problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem29 extends Problem {

  @Override
  public Answer solve() {
    Set<BigInteger> terms = new HashSet<>();
    for (long a = 2; a <= 100; a++) {
      for (int b = 2; b <= 100; b++) {
        terms.add(BigInteger.valueOf(a).pow(b));
      }
    }
    return new Answer<>(terms.size());
  }

}
