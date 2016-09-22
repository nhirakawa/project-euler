package com.github.nhirakawa.problems.problem10;

import java.util.stream.LongStream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;
import com.github.nhirakawa.problems.MathUtils;

public class Problem10 implements Problem {

  @Override
  public Answer solve() {
    return new Answer(LongStream.range(2, 2_000_000).filter(MathUtils::isPrime).sum());
  }

}
