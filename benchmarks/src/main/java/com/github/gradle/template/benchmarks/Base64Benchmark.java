package com.github.gradle.template.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class Base64Benchmark {

  private static final String SAMPLE = "abclaksdflj2lkj3l24jlksdmlm324lkjfsdlj";

  Base64.Encoder encoder = Base64.getEncoder();

  @Benchmark
  @Fork(value = 1, warmups = 2)
  @BenchmarkMode(Mode.Throughput)
  @Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
  @Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
  public void encodingTest(final Blackhole blackhole) {
    blackhole.consume(encoder.encodeToString(SAMPLE.getBytes(StandardCharsets.UTF_8)));
  }
}
