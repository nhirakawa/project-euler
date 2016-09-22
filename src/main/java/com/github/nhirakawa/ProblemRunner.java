package com.github.nhirakawa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.reflections.Reflections;

import com.google.inject.Guice;
import com.google.inject.Key;

public class ProblemRunner {

  private ProblemRunner() {
  }

  public void run(String... args) throws Exception {
    Map<String, Key<? extends Problem>> injectables = getInjectables();

    Options options = new Options();
    for (String classArg : injectables.keySet()) {
      options.addOption(classArg, false, classArg);
    }

    CommandLineParser parser = new DefaultParser();
    CommandLine commandLine = parser.parse(options, args);

    Optional<Key<? extends Problem>> key = Optional.empty();
    for (Option option : commandLine.getOptions()) {
      if (injectables.containsKey(option.getOpt())) {
        key = Optional.ofNullable(injectables.get(option.getOpt()));
        break;
      }
    }

    if (!key.isPresent()) {
      HelpFormatter helpFormatter = new HelpFormatter();
      helpFormatter.printHelp(200, getClass().getName(), null, options, null);
      System.exit(1);
    }

    Problem problem = Guice.createInjector(new ProjectEulerModule()).getInstance(key.get());
    String problemName = problem.getClass().getSimpleName();
    long start = System.currentTimeMillis();
    Answer answer = problem.solve();
    long end = System.currentTimeMillis();
    System.out.printf("Solved %s in %d ms [%d]%n", problemName, end - start, answer.get());
  }

  private static Map<String, Key<? extends Problem>> getInjectables() {
    Map<String, Key<? extends Problem>> injectables = new HashMap();
    Reflections reflections = new Reflections("com.github.nhirakawa.problems");
    Set<Class<? extends Problem>> problems = reflections.getSubTypesOf(Problem.class);
    for (Class<? extends Problem> c : problems) {
      injectables.put(c.getSimpleName().toLowerCase(), Key.get(c));
    }
    return injectables;
  }

  public static void main(String... args) throws Exception {
    new ProblemRunner().run(args);
  }
}
