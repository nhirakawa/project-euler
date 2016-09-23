package com.github.nhirakawa.problems.problem14;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem14 implements Problem {

  @Override
  public Answer solve() {
    long num = 0;
    long length = 0;
    for (int i = 1; i < 1_000_000; i++) {
      long newLength = collatzLength(i);
      if (newLength > length) {
        length = newLength;
        num = i;
      }
    }
    return new Answer(num);
  }

  private static long collatzLength(long l) {
    long length = 0L;
    while (l > 1) {
      l = nextCollatz(l);
      length++;
    }
    return length;
  }

  private static long nextCollatz(long l) {
    if (l % 2 == 0) {
      return l / 2;
    }
    return (3 * l) + 1;
  }

}
