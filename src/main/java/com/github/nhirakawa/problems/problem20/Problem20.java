package com.github.nhirakawa.problems.problem20;

import java.math.BigInteger;
import java.util.stream.Stream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem20 extends Problem {

  @Override
  public Answer solve() {
    BigInteger factorial = BigInteger.ONE;
    for(int i = 2; i < 101; i++){
      factorial = factorial.multiply(BigInteger.valueOf(i));
    }
    long sum = Stream.of(factorial.toString().split("")).mapToLong(Long::parseLong).sum();
    return new Answer<>(sum);
  }

}
