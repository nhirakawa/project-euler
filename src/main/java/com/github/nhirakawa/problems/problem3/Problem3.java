package com.github.nhirakawa.problems.problem3;

import static com.github.nhirakawa.problems.MathUtils.getFactors;

import java.util.Optional;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;
import com.github.nhirakawa.problems.MathUtils;

public class Problem3 implements Problem {

  @Override
  public Answer solve() {
    long constant = 600851475143L;
    Optional<Long> result = getFactors(constant).stream().filter(f -> f != 1 && f != constant).filter(MathUtils::isPrime).max(Long::compare);
    if (result.isPresent()) {
      return new Answer(result.get());
    }
    return null;
  }

}
