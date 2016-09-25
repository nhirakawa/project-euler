package com.github.nhirakawa.problems;

import static com.github.nhirakawa.MathUtils.getFactors;
import static com.github.nhirakawa.MathUtils.sum;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class Problem21 extends Problem {

  @Override
  public Answer solve() {
    Multimap<Long, Long> properDivisorSums = HashMultimap.create();
    for (long l = 2; l < 10000; l++) {
      long sum = sum(getProperDivisors(l));
      if (sum > 1) {
        properDivisorSums.put(sum, l);
      }
    }

    Set<Long> amicableNumbers = new TreeSet<>();
    for (long l = 2; l < 10000; l++) {
      if(properDivisorSums.containsKey(l)){
        for(long possibleAmicable : properDivisorSums.get(l)){
          if(l != possibleAmicable && properDivisorSums.get(possibleAmicable).contains(l)){
            amicableNumbers.add(l);
            amicableNumbers.add(possibleAmicable);
          }
        }
      }
    }
    return new Answer<>(sum(amicableNumbers));
  }

  private static Collection<Long> getProperDivisors(long l) {
    Set<Long> factors = getFactors(l);
    factors.remove(l);
    return factors;
  }
}
