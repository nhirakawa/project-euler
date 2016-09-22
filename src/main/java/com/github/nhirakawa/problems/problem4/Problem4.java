package com.github.nhirakawa.problems.problem4;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem4 implements Problem {

  @Override
  public Answer solve() {
    int result = 0;
    for (int i = 100; i < 999; i++) {
      for (int j = 100; j < 999; j++) {
        int product = i * j;
        if (isPalindrome(product)) {
          result = Math.max(result, product);
        }
      }
    }
    return new Answer(result);
  }

  private static boolean isPalindrome(long n) {
    return isPalindrome(Long.toString(n));
  }

  private static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

}
