package com.github.nhirakawa.problems.problem8;

import static java.lang.Math.max;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem8 extends Problem {

  private static int LENGTH = 13;
  private final List<String> number;

  public Problem8(){
    super();
    this.number = resource.stream().map(String::trim).flatMap(s -> Stream.of(s.split(""))).collect(Collectors.toList());
  }

  @Override
  public Answer solve() {
    long maxProduct = -1;
    for (int i = 0; i < number.size() - LENGTH; i++) {
      maxProduct = max(maxProduct, product(number.subList(i, i + LENGTH)));
    }
    return new Answer(maxProduct);
  }

  public long product(List<String> digits) {
    return digits.stream().mapToLong(Long::parseLong).reduce(1, (a, b) -> a * b);
  }

}
