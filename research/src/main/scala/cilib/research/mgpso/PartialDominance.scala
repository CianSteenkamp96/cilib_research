package cilib.research.mgpso

import scalaz._
import Scalaz._
import cilib.research.core.GetIndices._

case class PartialDominance(freqs: NonEmptyList[Int], i123: (Int, Int, Int), normalMGPSO: Boolean) // ##################################################### NEW ####################################################################
{
		def set_randomIndices_and_updateFreqs: PartialDominance = {
			val probs: NonEmptyList[Double] = probFromFitness(fitnessFromFreq(freqs))
			val randomIndices: (Int, Int, Int) = get3Indices(probs)
				val newFreqs = freqs.zipWithIndex.map(el =>
					if ((el._2 == randomIndices._1) || (el._2 == randomIndices._2) || (el._2 == randomIndices._3))
						el._1 + 1
					else el._1)
			this.copy(freqs = newFreqs, i123 = randomIndices)
  }
}