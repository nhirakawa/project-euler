package com.github.nhirakawa.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.LongStream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.MathUtils;
import com.github.nhirakawa.Problem;

public class Problem23 extends Problem {

  private static final long LIMIT = 28123L;

  @Override
  public Answer solve() {
    List<Long> abundantNumbers = LongStream.range(2L, LIMIT + 1).filter(MathUtils::isAbundant).distinct().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    Set<Long> abundantSums = new HashSet<>();
    for (int i = 0; i < abundantNumbers.size(); i++) {
      for (int j = i; j < abundantNumbers.size(); j++) {
        abundantSums.add(abundantNumbers.get(i) + abundantNumbers.get(j));
      }
    }
    long sum = 0;
    for (long l = 0; l < LIMIT; l++) {
      if (!abundantSums.contains(l)) {
        sum += l;
      }
    }
    return new Answer<>(sum);
  }

}
