package cilib.research.mgpso
import cilib.research.core.Benchmark
import scalaz._
import Scalaz._

object PartiallyDominates { // ################################## CHANGED - no longer check for 3 obj since the way the random indices are astored caters for all number of obj already ########################
	def apply(envX: Benchmark)(particleA: MGParticle, particleB: MGParticle): Boolean =
		if (particleA.pos.fitness == particleB.pos.fitness){
			false
		} else {
			var check = false

			// the 3 random indices readily available (even if only 3 obj)
			val partialParticleA = List[Double](particleA.pos.fitness.toList(envX.controlParameters.freqs.get._2._1), particleA.pos.fitness.toList(envX.controlParameters.freqs.get._2._2), particleA.pos.fitness.toList(envX.controlParameters.freqs.get._2._3))
			val partialParticleB = List[Double](particleA.pos.fitness.toList(envX.controlParameters.freqs.get._2._1), particleA.pos.fitness.toList(envX.controlParameters.freqs.get._2._2), particleA.pos.fitness.toList(envX.controlParameters.freqs.get._2._3))

			partialParticleA.zip(partialParticleB).foldLeft(0)(
				(a, c) => a +
					{
						if (envX.compareDoubles(c._1, c._2)) {
							check = true
							0
						} else if (c._1 == c._2)
							0
						else
							1
					}
			) == 0 && check
		}
}