package com.github.nhirakawa.problems;

import java.util.stream.IntStream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem1 extends Problem {

  public Answer solve() {
    long result = IntStream.range(0, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
    return new Answer<>(result);
  }

}
