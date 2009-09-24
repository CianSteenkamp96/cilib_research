/*
 * Copyright (C) 2003 - 2009
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package net.sourceforge.cilib.measurement.single.dynamic;

import net.sourceforge.cilib.algorithm.Algorithm;
import net.sourceforge.cilib.measurement.Measurement;
import net.sourceforge.cilib.problem.FunctionOptimisationProblem;
import net.sourceforge.cilib.type.types.Real;
import net.sourceforge.cilib.type.types.Type;

/**
 * Give the current value of the global optimum of the
 * function.
 *
 * @author Julien Duhain
 *
 */
public class GlobalMaximum implements Measurement {

    private static final long serialVersionUID = 2658868675629949642L;
    public GlobalMaximum() {}
    public GlobalMaximum(GlobalMaximum rhs) {}

    @Override
    public GlobalMaximum clone() {
        return new GlobalMaximum(this);
    }

    @Override
    public String getDomain() {
        return "R";
    }

    @Override
    public Type getValue(Algorithm algorithm) {
        FunctionOptimisationProblem problem = (FunctionOptimisationProblem) algorithm.getOptimisationProblem();
        return new Real(problem.getFunction().getMaximum());
    }

    @Override
    public Measurement getClone() {
        return new GlobalMaximum(this);
    }
}
