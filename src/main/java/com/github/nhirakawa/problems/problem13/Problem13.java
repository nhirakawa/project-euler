package com.github.nhirakawa.problems.problem13;

import java.math.BigInteger;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem13 extends Problem {

  @Override
  public Answer solve() {
    BigInteger sum = BigInteger.ZERO;
    for (String number : resource) {
      sum = sum.add(new BigInteger(number));
    }
    String prefix = sum.toString().substring(0, 10);
    return new Answer(Long.parseLong(prefix));
  }
}
