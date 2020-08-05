package cilib
package research

import cilib.research.core.BenchmarkSuite
import cilib.research.mgpso.LambdaStrategy
import cilib.research.simulation.Simulation
import scalaz._
import scalaz.effect.IO._
import scalaz.effect.{IO, SafeApp}

// To create jars see readmes/jar_creation on MSc HD

// Intellij -> right click run main -> error -> click on Main (next to green hammer) -> edit configs -> add command line args to 'Program arguments:' -> apply -> run
// command line args example => MGPSO 3 30 WFG
object Main extends SafeApp {

  override def run(args: ImmutableArray[String]): IO[Unit] = {
    // These checks are specific for my research
    // Not sure if asserts will be better
    // Throwing exceptions not pure - maybe improve at a later stage
    if (args.length != 4 && args.length != 5)
      throw new Exception(
        "Number of CL params needs to be at least 4 separated by spaces including: algoName (MGPSO, PMGPSO, RW-PMGPSO, or KnMGPSO) numObjs (3, 5, 8, 10, or 15) numDims (30, 100, 500, or 1000) problemSuite (WFG or DTLZ) problemNum (Note this parameter is optional - if left unspecified the entire problem suite will be included. For WFG: 1, 2, ..., or 9; For DTLZ: 1, 2, ..., or 7).\n")
    else if ((args(0) != "MGPSO" && args(0) != "PMGPSO" && args(0) != "RW-PMGPSO"&& args(0) != "KnMGPSO") ||
             (args(1).toInt != 3 && args(1).toInt != 5 && args(1).toInt != 8 && args(1).toInt != 10 && args(
               1).toInt != 15) ||
             (args(2).toInt != 30 && args(2).toInt != 100 && args(2).toInt != 500 && args(2).toInt != 1000) ||
             (args(3) != "WFG" && args(3) != "DTLZ"))
      throw new Exception(
        "CL params needs to be: algoName (MGPSO, PMGPSO, RW-PMGPSO, or KnMGPSO) numObjs (3, 5, 8, 10, or 15) numDims (30, 100, 500, or 1000) problemSuite (WFG or DTLZ) problemNum (Note this parameter is optional - if left unspecified the entire problem suite will be included. For WFG: 1, 2, ..., or 9; For DTLZ: 1, 2, ..., or 7).\n")

    if (args.length == 5)
      if (args(3) == "WFG") {
        if (args(4).toInt != 1 && args(4).toInt != 2 && args(4).toInt != 3 && args(4).toInt != 4 && args(
              4).toInt != 5 && args(4).toInt != 6 && args(4).toInt != 7 && args(4).toInt != 8 && args(
              4).toInt != 9)
          throw new Exception(
            "The fifth CL parameter (the problem number), for WFG, should be: 1, 2, ..., or 9.\n")
      } else if (args(3) == "DTLZ") {
        if (args(4).toInt != 1 && args(4).toInt != 2 && args(4).toInt != 3 && args(4).toInt != 4 && args(
              4).toInt != 5 && args(4).toInt != 6 && args(4).toInt != 7)
          throw new Exception(
            "The fifth CL parameter (the problem number), for DTLZ, should be: 1, 2, ..., or 7.\n")
      } else if (args(3) == "ZDT") { // No chance of executing due to check above
        if (args(4).toInt != 1 && args(4).toInt != 2 && args(4).toInt != 3 && args(4).toInt != 4 && args(
              4).toInt != 6)
          throw new Exception(
            "The fifth CL parameter (the problem number), for ZDT, should be: 1, 2, 3, 4, or 6.\n")
      } else
        throw new Exception(
          "Test suite should be one of the following: \"WFG\", \"DTLZ\", or \"ZDT\".\n")

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! CONFIG CHANGES HERE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This (or at least some of it) will be passed in through the CLI as CL params. Some fixed for convenience of research. But the code can easily be changed to set everything through the CL.
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val lambdaStrategy: String = "R" // lambda strategy: 'R', 'STD', 'LI', 'LD', 'RI', or 'RIJ'
    val iterations: Int = 20 // #iterations per independent sample/run !!! NB HERE !!!
    val independentRuns: Int = 30 // #independent samples: 30 !!! NB HERE !!!
//    val desired_ratio_KPs_2_ND_sols: Double = -1.0
    val desired_ratio_KPs_2_ND_sols: Double = 0.25 // !!! NB HERE !!!
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val algoName: String = args(0) // algorithm name: 'MGPSO', 'PMGPSO', 'RW-PMGPSO', or 'KnMGPSO'
    assert(if (algoName != "KnMGPSO") desired_ratio_KPs_2_ND_sols == -1.0 else if (algoName == "KnMGPSO") desired_ratio_KPs_2_ND_sols > 0 && desired_ratio_KPs_2_ND_sols < 1 else 1 == 1)
    val numObj: Int = args(1).toInt // #obj: 3, 5, 8, 10, or 15
    val numDecisionVariables: Int = args(2).toInt
    // #dimensions in the decision space: 30, 100, 500, or 1000
    val subswarms3obj: NonEmptyList[Int] = NonEmptyList(51, 51, 51) // 153
    val subswarms5obj: NonEmptyList[Int] = NonEmptyList(25, 25, 25, 25, 26) // 126
    val subswarms8obj: NonEmptyList[Int] = NonEmptyList(19, 19, 19, 19, 19, 19, 19, 20) // 156
    val subswarms10obj
      : NonEmptyList[Int] = NonEmptyList(11, 11, 11, 11, 11, 11, 11, 11, 11, 11) // 110
    val subswarms15obj: NonEmptyList[Int] =
      NonEmptyList(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9) // 135
    val problemNum: Int = if (args.length == 5) args(4).toInt else -1
    // NonEmptyList of sub swarm divisions;
    // number of objectives equal to the size of the swarms NonEmptyList,
    // that is, each element in the NEL represents a sub swarm's size
    val swarms: NonEmptyList[Int] =
      if (numObj == 3) subswarms3obj
      else if (numObj == 5) subswarms5obj
      else if (numObj == 8) subswarms8obj
      else if (numObj == 10) subswarms10obj
      else if (numObj == 15) subswarms15obj
      else throw new Exception("Number of objectives supported: 3, 5, 8, 10 or 15.\n")
    val benchmarkSuiteName: String = args(3) // problem suite: 'WFG' or 'DTLZ'
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    val numObjectives: Int = swarms.size // #dimensions in the objective/solution space

    val benchmarkSuite =
      if (benchmarkSuiteName == "WFG")
        BenchmarkSuite.wfgObj(numObjectives, numDecisionVariables, swarms, problemNum)
      else if (benchmarkSuiteName == "DTLZ")
        BenchmarkSuite.dtlzObj(numObjectives, numDecisionVariables, swarms, problemNum)
      // No chance of executing due to check at top
      else if (benchmarkSuiteName == "ZDT") // Checks at top does not allow ZDT or 2 objectives to be specified.
        if (numObjectives != 2)
          throw new Exception("ZDT is bi-objective.\n")
        else
          BenchmarkSuite.zdtObj(swarms, problemNum) // ZDT is only bi-objective and has its own specific number of decision variables
      else
        throw new Exception(
          "Test suite should be one of the following: \"WFG\", \"DTLZ\", or \"ZDT\".\n")

    val simulationsIO = benchmarkSuite.benchmarks.traverse1(b => {
      val bounds = b.bounds
      val ls =
        if (lambdaStrategy == "STD")
          LambdaStrategy.Standard(bounds)
        else if (lambdaStrategy == "LI")
          LambdaStrategy.LinearIncreasing(bounds)
        else if (lambdaStrategy == "LD")
          LambdaStrategy.LinearDecreasing(bounds)
        else if (lambdaStrategy == "R")
          LambdaStrategy.Random(bounds)
        else if (lambdaStrategy == "RI")
          LambdaStrategy.RandomI(bounds)
        else if (lambdaStrategy == "RIJ")
          LambdaStrategy.RandomIJ(bounds)
        else
          throw new Exception(
            "Lambda strategy can only be one of the following: \"STD\", \"LI\", \"LD\", \"R\", \"RI\", or \"RIJ\".\n")

      Simulation.runIO(algoName,
                       numObjectives,
                       numDecisionVariables,
                       ls,
                       b,
                       iterations,
                       independentRuns,
                       desired_ratio_KPs_2_ND_sols)
    })

    for {
      _ <- putStrLn("Starting")
      _ <- simulationsIO
      _ <- putStrLn("Done")
    } yield ()
  }
}
