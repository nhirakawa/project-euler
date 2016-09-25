package com.github.nhirakawa.problems;

import static com.github.nhirakawa.MathUtils.max;
import static com.github.nhirakawa.MathUtils.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;
import com.google.common.collect.Lists;

public class Problem11 extends Problem {

  private final List<List<Long>> matrix;

  public Problem11() {
    super();
    this.matrix = Lists.newArrayList(
        resource.stream().map(s -> Stream.of(s.split(" ")).map(Long::parseLong).collect(Collectors.toList())).collect(Collectors.toList())
    );
  }

  @Override
  public Answer solve() {
    long maxProduct = Long.MIN_VALUE;
    for (int i = 3; i < matrix.size(); i++) {
      for (int j = 3; j < matrix.get(i).size(); j++) {
        List<Long> horizontal = new ArrayList<>();
        for (int x = 0; x < 4; x++) {
          horizontal.add(matrix.get(i - x).get(j));
        }
        List<Long> vertical = new ArrayList<>();
        for (int y = 0; y < 4; y++) {
          vertical.add(matrix.get(i).get(j - y));
        }
        List<Long> diagonal = new ArrayList<>();
        for (int d = 0; d < 4; d++) {
          vertical.add(matrix.get(i - d).get(j - d));
        }
        maxProduct = max(product(horizontal), product(vertical), product(diagonal));
      }
    }
    return new Answer<>(maxProduct);
  }

}
