package com.github.nhirakawa.problems;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

@FixMethodOrder(MethodSorters.JVM)
public class ProblemTest {

  @Test
  public void testProblem1() {
    testProblem(new Problem1(), new Answer<>(233168L));
  }

  @Test
  public void testProblem2() {
    testProblem(new Problem2(), new Answer<>(4613732));
  }

  @Test
  public void testProblem3() {
    testProblem(new Problem3(), new Answer<>(6857L));
  }

  @Test
  public void testProblem4() {
    testProblem(new Problem4(), new Answer<>(906609));
  }

  @Test
  public void testProblem5() {
    testProblem(new Problem5(), new Answer<>(232792560));
  }

  @Test
  public void testProblem6() {
    testProblem(new Problem6(), new Answer<>(25164150L));
  }

  @Test
  public void testProblem7() {
    testProblem(new Problem7(), new Answer<>(104743L));
  }

  @Test
  public void testProblem8() {
    testProblem(new Problem8(), new Answer<>(23514624000L));
  }

  @Test
  public void testProblem9() {
    testProblem(new Problem9(), new Answer<>(31875000));
  }

  @Test
  public void testProblem10() {
    testProblem(new Problem10(), new Answer<>(142913828922L));
  }

  @Test
  @Ignore
  public void testProblem11() {
    testProblem(new Problem11(), new Answer<>(70600674L));
  }

  @Test
  public void testProblem12() {
    testProblem(new Problem12(), new Answer<>(76576500L));
  }

  @Test
  public void testProblem13() {
    testProblem(new Problem13(), new Answer<>("5537376230"));
  }

  @Test
  public void testProblem14() {
    testProblem(new Problem14(), new Answer<>(837799L));
  }

  @Test
  public void testProblem16() {
    testProblem(new Problem16(), new Answer<>(1366L));
  }

  @Test
  public void testProblem18() {
    testProblem(new Problem18(), new Answer<>(1074L));
  }

  @Test
  public void testProblem19() {
    testProblem(new Problem19(), new Answer<>(171));
  }

  @Test
  public void testProblem20() {
    testProblem(new Problem20(), new Answer<>(648L));
  }

  @Test
  public void testProblem21() {
    testProblem(new Problem21(), new Answer<>(31626L));
  }

  @Test
  public void testProblem22() {
    testProblem(new Problem22(), new Answer<>(871198282L));
  }

  @Test
  public void testProblem23() {
    testProblem(new Problem23(), new Answer<>(4179871L));
  }

  @Test
  public void testProblem25() {
    testProblem(new Problem25(), new Answer<>(4782L));
  }

  @Test
  public void testProblem27(){
    testProblem(new Problem27(), new Answer<>(-59231L));
  }

  @Test
  public void testProblem28() {
    testProblem(new Problem28(), new Answer<>(669171001L));
  }

  @Test
  public void testProblem67() {
    testProblem(new Problem67(), new Answer<>(7273L));
  }

  private static void testProblem(Problem problem, Answer<?> answer) {
    assertThat(problem.solve()).isEqualTo(answer);
  }
}
