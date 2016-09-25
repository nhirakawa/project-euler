package com.github.nhirakawa.problems;

import static com.github.nhirakawa.problems.MathUtils.getFactors;
import static com.github.nhirakawa.problems.MathUtils.sum;

import java.util.Collection;
import java.util.Set;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class Problem21 extends Problem {

  @Override
  public Answer solve() {
    Multimap<Long, Long> amicableNumbers = HashMultimap.create();
    for (long l = 2; l < 10001; l++) {
      amicableNumbers.put(sum(getProperDivisors(l)), l);
    }
    amicableNumbers.removeAll(0L);
    amicableNumbers.removeAll(1L);
    long result = amicableNumbers.asMap().values().stream().filter(c -> c.size() > 1).flatMap(Collection::stream).reduce((a, b) -> a + b).get();
    return new Answer<>(result);
  }

  private static Collection<Long> getProperDivisors(long l) {
    Set<Long> factors = getFactors(l);
    factors.remove(1L);
    factors.remove(l);
    return factors;
  }
}
