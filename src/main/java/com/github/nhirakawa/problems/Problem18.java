package com.github.nhirakawa.problems;

import static com.github.nhirakawa.problems.MathUtils.max;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem18 extends Problem {

  private final List<List<Long>> numbers;

  public Problem18() {
    this.numbers = resource.stream().map(s -> Stream.of(s.split(" ")).map(Long::parseLong).collect(Collectors.toList())).collect(Collectors.toList());
  }

  @Override
  public Answer solve() {
    for (int i = numbers.size() - 1; i > 0; i--) {
      for (int j = 0; j < numbers.get(i).size() - 1; j++) {
        numbers.get(i - 1).set(j, numbers.get(i - 1).get(j) + max(numbers.get(i).get(j), numbers.get(i).get(j + 1)));
      }
    }
    return new Answer<>(numbers.get(0).get(0));
  }

}
