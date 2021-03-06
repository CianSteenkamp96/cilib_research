package cilib.research.core
import cilib.research.benchmarks.wfg._
import cilib.research.benchmarks.dtlz._

import scalaz.NonEmptyList

case class BenchmarkSuite(name: String, benchmarks: NonEmptyList[Benchmark])

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! HERE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
object BenchmarkSuite {

  val wfg3obj = BenchmarkSuite(
    "wfg3obj",
    NonEmptyList(
      Benchmark("WFG1",
                WFG.WFG1(3),
                WFG.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(50, 50, 50))),
      Benchmark("WFG2",
                WFG.WFG2(3),
                WFG.bounds,
                ControlParameters(0.275, 1.25, 1.40, 1.70, NonEmptyList(50, 50, 50))),
      Benchmark("WFG3",
                WFG.WFG3(3),
                WFG.bounds,
                ControlParameters(0.525, 1.65, 1.75, 0.75, NonEmptyList(50, 50, 50))),
      Benchmark("WFG4",
                WFG.WFG4(3),
                WFG.bounds,
                ControlParameters(0.275, 1.75, 0.50, 1.05, NonEmptyList(50, 50, 50))),
      Benchmark("WFG5",
                WFG.WFG5(3),
                WFG.bounds,
                ControlParameters(0.575, 0.60, 1.85, 1.75, NonEmptyList(50, 50, 50))),
      Benchmark("WFG6",
                WFG.WFG6(3),
                WFG.bounds,
                ControlParameters(0.300, 0.90, 0.90, 1.90, NonEmptyList(50, 50, 50))),
      Benchmark("WFG7",
                WFG.WFG7(3),
                WFG.bounds,
                ControlParameters(0.425, 1.45, 1.50, 1.40, NonEmptyList(50, 50, 50))),
      Benchmark("WFG8",
                WFG.WFG8(3),
                WFG.bounds,
                ControlParameters(0.425, 0.95, 1.75, 1.85, NonEmptyList(50, 50, 50))),
      Benchmark("WFG9",
                WFG.WFG9(3),
                WFG.bounds,
                ControlParameters(0.275, 1.25, 0.75, 1.50, NonEmptyList(50, 50, 50)))
    )
  )

  val wfg5obj = BenchmarkSuite(
    "wfg5obj",
    NonEmptyList(
      Benchmark("WFG1",
                WFG.WFG1(5),
                WFG.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("WFG2",
                WFG.WFG2(5),
                WFG.bounds,
                ControlParameters(0.275, 1.25, 1.40, 1.70, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("WFG3",
                WFG.WFG3(5),
                WFG.bounds,
                ControlParameters(0.525, 1.65, 1.75, 0.75, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("WFG4",
                WFG.WFG4(5),
                WFG.bounds,
                ControlParameters(0.275, 1.75, 0.50, 1.05, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("WFG5",
                WFG.WFG5(5),
                WFG.bounds,
                ControlParameters(0.575, 0.60, 1.85, 1.75, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("WFG6",
                WFG.WFG6(5),
                WFG.bounds,
                ControlParameters(0.300, 0.90, 0.90, 1.90, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("WFG7",
                WFG.WFG7(5),
                WFG.bounds,
                ControlParameters(0.425, 1.45, 1.50, 1.40, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("WFG8",
                WFG.WFG8(5),
                WFG.bounds,
                ControlParameters(0.425, 0.95, 1.75, 1.85, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("WFG9",
                WFG.WFG9(5),
                WFG.bounds,
                ControlParameters(0.275, 1.25, 0.75, 1.50, NonEmptyList(30, 30, 30, 30, 30)))
    )
  )

  val wfg8obj = BenchmarkSuite(
    "wfg8obj",
    NonEmptyList(
      Benchmark(
        "WFG1",
        WFG.WFG1(8),
        WFG.bounds,
        ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "WFG2",
        WFG.WFG2(8),
        WFG.bounds,
        ControlParameters(0.275, 1.25, 1.40, 1.70, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "WFG3",
        WFG.WFG3(8),
        WFG.bounds,
        ControlParameters(0.525, 1.65, 1.75, 0.75, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "WFG4",
        WFG.WFG4(8),
        WFG.bounds,
        ControlParameters(0.275, 1.75, 0.50, 1.05, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "WFG5",
        WFG.WFG5(8),
        WFG.bounds,
        ControlParameters(0.575, 0.60, 1.85, 1.75, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "WFG6",
        WFG.WFG6(8),
        WFG.bounds,
        ControlParameters(0.300, 0.90, 0.90, 1.90, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "WFG7",
        WFG.WFG7(8),
        WFG.bounds,
        ControlParameters(0.425, 1.45, 1.50, 1.40, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "WFG8",
        WFG.WFG8(8),
        WFG.bounds,
        ControlParameters(0.425, 0.95, 1.75, 1.85, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "WFG9",
        WFG.WFG9(8),
        WFG.bounds,
        ControlParameters(0.275, 1.25, 0.75, 1.50, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17)))
    )
  )

  val wfg10obj = BenchmarkSuite(
    "wfg10obj",
    NonEmptyList(
      Benchmark("WFG1",
                WFG.WFG1(10),
                WFG.bounds,
                ControlParameters(0.125,
                                  1.20,
                                  1.30,
                                  1.75,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("WFG2",
                WFG.WFG2(10),
                WFG.bounds,
                ControlParameters(0.275,
                                  1.25,
                                  1.40,
                                  1.70,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("WFG3",
                WFG.WFG3(10),
                WFG.bounds,
                ControlParameters(0.525,
                                  1.65,
                                  1.75,
                                  0.75,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("WFG4",
                WFG.WFG4(10),
                WFG.bounds,
                ControlParameters(0.275,
                                  1.75,
                                  0.50,
                                  1.05,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("WFG5",
                WFG.WFG5(10),
                WFG.bounds,
                ControlParameters(0.575,
                                  0.60,
                                  1.85,
                                  1.75,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("WFG6",
                WFG.WFG6(10),
                WFG.bounds,
                ControlParameters(0.300,
                                  0.90,
                                  0.90,
                                  1.90,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("WFG7",
                WFG.WFG7(10),
                WFG.bounds,
                ControlParameters(0.425,
                                  1.45,
                                  1.50,
                                  1.40,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("WFG8",
                WFG.WFG8(10),
                WFG.bounds,
                ControlParameters(0.425,
                                  0.95,
                                  1.75,
                                  1.85,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("WFG9",
                WFG.WFG9(10),
                WFG.bounds,
                ControlParameters(0.275,
                                  1.25,
                                  0.75,
                                  1.50,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15)))
    )
  )

  val wfg15obj = BenchmarkSuite(
    "wfg15obj",
    NonEmptyList(
      Benchmark("WFG1",
                WFG.WFG1(15),
                WFG.bounds,
                ControlParameters(0.125,
                                  1.20,
                                  1.30,
                                  1.75,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("WFG2",
                WFG.WFG2(15),
                WFG.bounds,
                ControlParameters(0.275,
                                  1.25,
                                  1.40,
                                  1.70,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("WFG3",
                WFG.WFG3(15),
                WFG.bounds,
                ControlParameters(0.525,
                                  1.65,
                                  1.75,
                                  0.75,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("WFG4",
                WFG.WFG4(15),
                WFG.bounds,
                ControlParameters(0.275,
                                  1.75,
                                  0.50,
                                  1.05,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("WFG5",
                WFG.WFG5(15),
                WFG.bounds,
                ControlParameters(0.575,
                                  0.60,
                                  1.85,
                                  1.75,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("WFG6",
                WFG.WFG6(15),
                WFG.bounds,
                ControlParameters(0.300,
                                  0.90,
                                  0.90,
                                  1.90,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("WFG7",
                WFG.WFG7(15),
                WFG.bounds,
                ControlParameters(0.425,
                                  1.45,
                                  1.50,
                                  1.40,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("WFG8",
                WFG.WFG8(15),
                WFG.bounds,
                ControlParameters(0.425,
                                  0.95,
                                  1.75,
                                  1.85,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark(
        "WFG9",
        WFG.WFG9(15),
        WFG.bounds,
        ControlParameters(0.275,
                          1.25,
                          0.75,
                          1.50,
                          NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))
    )
  )

  val dtlz3obj = BenchmarkSuite(
    "dtlz3obj",
    NonEmptyList(
      Benchmark("DTLZ1",
                DTLZ.DTLZ1F(3),
                DTLZ.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(50, 50, 50))),
      Benchmark("DTLZ2",
                DTLZ.DTLZ2F(3),
                DTLZ.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(50, 50, 50))),
      Benchmark("DTLZ3",
                DTLZ.DTLZ3F(3),
                DTLZ.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(50, 50, 50))),
      Benchmark("DTLZ4",
                DTLZ.DTLZ4F(3),
                DTLZ.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(50, 50, 50))),
      Benchmark("DTLZ5",
                DTLZ.DTLZ5F(3),
                DTLZ.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(50, 50, 50))),
      Benchmark("DTLZ6",
                DTLZ.DTLZ6F(3),
                DTLZ.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(50, 50, 50))),
      Benchmark("DTLZ7",
                DTLZ.DTLZ7F(3),
                DTLZ.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(50, 50, 50)))
    )
  )

  val dtlz5obj = BenchmarkSuite(
    "dtlz5obj",
    NonEmptyList(
      Benchmark("DTLZ1",
                DTLZ.DTLZ1F(5),
                DTLZ.bounds,
                ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("DTLZ2",
                DTLZ.DTLZ2F(5),
                DTLZ.bounds,
                ControlParameters(0.275, 1.25, 1.40, 1.70, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("DTLZ3",
                DTLZ.DTLZ3F(5),
                DTLZ.bounds,
                ControlParameters(0.525, 1.65, 1.75, 0.75, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("DTLZ4",
                DTLZ.DTLZ4F(5),
                DTLZ.bounds,
                ControlParameters(0.275, 1.75, 0.50, 1.05, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("DTLZ5",
                DTLZ.DTLZ5F(5),
                DTLZ.bounds,
                ControlParameters(0.575, 0.60, 1.85, 1.75, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("DTLZ6",
                DTLZ.DTLZ6F(5),
                DTLZ.bounds,
                ControlParameters(0.300, 0.90, 0.90, 1.90, NonEmptyList(30, 30, 30, 30, 30))),
      Benchmark("DTLZ7",
                DTLZ.DTLZ7F(5),
                DTLZ.bounds,
                ControlParameters(0.425, 1.45, 1.50, 1.40, NonEmptyList(30, 30, 30, 30, 30)))
    )
  )

  val dtlz8obj = BenchmarkSuite(
    "dtlz8obj",
    NonEmptyList(
      Benchmark(
        "DTLZ1",
        DTLZ.DTLZ1F(8),
        DTLZ.bounds,
        ControlParameters(0.125, 1.20, 1.30, 1.75, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "DTLZ2",
        DTLZ.DTLZ2F(8),
        DTLZ.bounds,
        ControlParameters(0.275, 1.25, 1.40, 1.70, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "DTLZ3",
        DTLZ.DTLZ3F(8),
        DTLZ.bounds,
        ControlParameters(0.525, 1.65, 1.75, 0.75, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "DTLZ4",
        DTLZ.DTLZ4F(8),
        DTLZ.bounds,
        ControlParameters(0.275, 1.75, 0.50, 1.05, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "DTLZ5",
        DTLZ.DTLZ5F(8),
        DTLZ.bounds,
        ControlParameters(0.575, 0.60, 1.85, 1.75, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "DTLZ6",
        DTLZ.DTLZ6F(8),
        DTLZ.bounds,
        ControlParameters(0.300, 0.90, 0.90, 1.90, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17))),
      Benchmark(
        "DTLZ7",
        DTLZ.DTLZ7F(8),
        DTLZ.bounds,
        ControlParameters(0.425, 1.45, 1.50, 1.40, NonEmptyList(19, 19, 19, 19, 19, 19, 19, 17)))
    )
  )

  val dtlz10obj = BenchmarkSuite(
    "dtlz10obj",
    NonEmptyList(
      Benchmark("DTLZ1",
                DTLZ.DTLZ1F(10),
                DTLZ.bounds,
                ControlParameters(0.125,
                                  1.20,
                                  1.30,
                                  1.75,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("DTLZ2",
                DTLZ.DTLZ2F(10),
                DTLZ.bounds,
                ControlParameters(0.275,
                                  1.25,
                                  1.40,
                                  1.70,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("DTLZ3",
                DTLZ.DTLZ3F(10),
                DTLZ.bounds,
                ControlParameters(0.525,
                                  1.65,
                                  1.75,
                                  0.75,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("DTLZ4",
                DTLZ.DTLZ4F(10),
                DTLZ.bounds,
                ControlParameters(0.275,
                                  1.75,
                                  0.50,
                                  1.05,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("DTLZ5",
                DTLZ.DTLZ5F(10),
                DTLZ.bounds,
                ControlParameters(0.575,
                                  0.60,
                                  1.85,
                                  1.75,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("DTLZ6",
                DTLZ.DTLZ6F(10),
                DTLZ.bounds,
                ControlParameters(0.300,
                                  0.90,
                                  0.90,
                                  1.90,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15))),
      Benchmark("DTLZ7",
                DTLZ.DTLZ7F(10),
                DTLZ.bounds,
                ControlParameters(0.425,
                                  1.45,
                                  1.50,
                                  1.40,
                                  NonEmptyList(15, 15, 15, 15, 15, 15, 15, 15, 15, 15)))
    )
  )

  val dtlz15obj = BenchmarkSuite(
    "dtlz15obj",
    NonEmptyList(
      Benchmark("DTLZ1",
                DTLZ.DTLZ1F(15),
                DTLZ.bounds,
                ControlParameters(0.125,
                                  1.20,
                                  1.30,
                                  1.75,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("DTLZ2",
                DTLZ.DTLZ2F(15),
                DTLZ.bounds,
                ControlParameters(0.275,
                                  1.25,
                                  1.40,
                                  1.70,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("DTLZ3",
                DTLZ.DTLZ3F(15),
                DTLZ.bounds,
                ControlParameters(0.525,
                                  1.65,
                                  1.75,
                                  0.75,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("DTLZ4",
                DTLZ.DTLZ4F(15),
                DTLZ.bounds,
                ControlParameters(0.275,
                                  1.75,
                                  0.50,
                                  1.05,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("DTLZ5",
                DTLZ.DTLZ5F(15),
                DTLZ.bounds,
                ControlParameters(0.575,
                                  0.60,
                                  1.85,
                                  1.75,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark("DTLZ6",
                DTLZ.DTLZ6F(15),
                DTLZ.bounds,
                ControlParameters(0.300,
                                  0.90,
                                  0.90,
                                  1.90,
                                  NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                    10, 10))),
      Benchmark(
        "DTLZ7",
        DTLZ.DTLZ7F(15),
        DTLZ.bounds,
        ControlParameters(0.425,
                          1.45,
                          1.50,
                          1.40,
                          NonEmptyList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))
    )
  )

}
