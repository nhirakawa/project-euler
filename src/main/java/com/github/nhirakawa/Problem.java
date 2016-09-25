package com.github.nhirakawa;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

import com.google.common.io.Resources;

public abstract class Problem {

  protected final List<String> resource;

  public Problem() {
    List<String> list = Collections.emptyList();
    try {
      URL url = Resources.getResource(String.format("%s.txt", getClass().getSimpleName().toLowerCase()));
      list = Resources.readLines(url, Charset.defaultCharset());
    } catch (IllegalArgumentException e){
      // do nothing
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      resource = list;
    }
  }

  public abstract Answer solve();
}
