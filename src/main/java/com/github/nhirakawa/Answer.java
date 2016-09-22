package com.github.nhirakawa;

public class Answer {

  private final long value;

  public Answer(long value) {
    this.value = value;
  }

  public long get() {
    return value;
  }

  @Override
  public String toString() {
    return Long.toString(value);
  }
}
