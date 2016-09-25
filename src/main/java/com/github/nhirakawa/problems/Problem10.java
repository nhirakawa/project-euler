package com.github.nhirakawa.problems;

import java.util.stream.LongStream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem10 extends Problem {

  @Override
  public Answer solve() {
    return new Answer<>(LongStream.range(2, 2_000_000).filter(MathUtils::isPrime).sum());
  }

}
