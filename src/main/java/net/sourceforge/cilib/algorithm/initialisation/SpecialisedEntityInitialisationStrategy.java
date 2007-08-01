/*
 * SpecialisedEntityInitialisationStrategy.java
 * 
 * Created on unknown
 *
 * Copyright (C) 2003 - 2007
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
 *
 */
package net.sourceforge.cilib.algorithm.initialisation;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.cilib.algorithm.InitialisationException;
import net.sourceforge.cilib.entity.Entity;
import net.sourceforge.cilib.entity.Topology;
import net.sourceforge.cilib.problem.OptimisationProblem;

public class SpecialisedEntityInitialisationStrategy extends InitialisationStrategy {
	private static final long serialVersionUID = -9146471282965793922L;
	private List<Entity> entityList;

	public SpecialisedEntityInitialisationStrategy() {
		this.entityList = new ArrayList<Entity>(40);
	}

	public SpecialisedEntityInitialisationStrategy(SpecialisedEntityInitialisationStrategy copy) {
		this.entityList = new ArrayList<Entity>(copy.entityList.size());
		for (Entity entity : copy.entityList) {
			this.entityList.add(entity.clone());
		}
	}

	public SpecialisedEntityInitialisationStrategy clone() {
		return new SpecialisedEntityInitialisationStrategy(this);
	}

	@Override
	public Entity getEntityType() {
		// this needs to be looked at... generalisation breaks here
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialise(Topology topology, OptimisationProblem problem) {
		if (problem == null)
			throw new InitialisationException("No problem has been specified");

		if (this.entityList.size() == 0)
			throw new InitialisationException("No prototype Entity object has been defined for the clone operation in the entity constrution process.");

		for (Entity entity : entityList) {
			entity.initialise(problem);
			topology.add(entity);
		}
	}

	@Override
	public void setEntityType(Entity entity) {
		this.entityList.add(entity);
	}
}