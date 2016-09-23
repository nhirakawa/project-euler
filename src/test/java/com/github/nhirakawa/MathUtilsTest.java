package com.github.nhirakawa;

import static com.github.nhirakawa.problems.MathUtils.getFactors;
import static com.github.nhirakawa.problems.MathUtils.isPrime;
import static com.github.nhirakawa.problems.MathUtils.square;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MathUtilsTest {

  @Test
  public void testSquare() {
    assertThat(square(2)).isEqualTo(4);
    assertThat(square(4)).isEqualTo(16);
    assertThat(square(5)).isEqualTo(25);
    assertThat(square(10)).isEqualTo(100);
  }

  @Test
  public void testGetFactors() {
    assertThat(getFactors(2)).contains(1L, 2L);
    assertThat(getFactors(25)).contains(1L, 5L, 25L);
    assertThat(getFactors(19)).contains(1L, 19L);
    assertThat(getFactors(24)).contains(1L, 2L, 3L, 4L, 6L, 8L, 12L, 24L);
  }

  @Test
  public void testIsPrime() {
    assertTrue(isPrime(2));
    assertTrue(isPrime(19));
    assertFalse(isPrime(25));
    assertFalse(isPrime(300));
  }
}
