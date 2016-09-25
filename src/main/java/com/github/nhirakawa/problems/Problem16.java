package com.github.nhirakawa.problems;

import java.math.BigInteger;
import java.util.stream.Stream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem16 extends Problem {

  @Override
  public Answer solve() {
    long result = Stream.of(BigInteger.ONE.add(BigInteger.ONE).pow(1000).toString().split("")).mapToLong(Long::parseLong).sum();
    return new Answer<>(result);
  }

}
