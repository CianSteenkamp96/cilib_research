/*
 * Entity.java
 * 
 * Created on Aug 3, 2005
 *
 * Copyright (C) 2003 - 2006 
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
package net.sourceforge.cilib.entity;

import java.io.Serializable;
import java.util.Map;

import net.sourceforge.cilib.problem.Fitness;
import net.sourceforge.cilib.problem.OptimisationProblem;
import net.sourceforge.cilib.type.types.Type;

/**
 * This is the super interface which all correpsonding entity implementation and extending interfaces,
 * for use in population based algorithms, must implement/extend from. 
 */
public interface Entity extends Comparable<Entity>, Serializable {
	
	/**
	 * Make a clone of the Entity the exact semantics of the clone method will be defined by the classes
	 * that implements this interface.
	 * @return the cloned object
	 */
	public Entity clone();

	
	/**
	 * This method compares two Entities with each other. And either return 0, -1 or 1 based on
	 * some characteristic of an Entity. Usually this characteristic will be the fitness of the Entity.
	 * @precondition The two entities must have their fitnesses evaluated
	 * for this method to give the correct result.
	 */
	public int compareTo(Entity o);
	
	
	/**
	 * Get the contents (candidate solution) of the entity. The conents will depend on the subclass.
	 * Eg. genes for Individual
	 *     position for Particle
	 *     tour for Ant
	 *     etc...
	 */ 
	public Type getContents();
	
	
	/**
	 * 
	 * @param type
	 */
	public void setContents(Type type);
	
	
	/**
	 * Returns the ID of the entity.
	 * @return String - ID
	 */
	//public String getId();
	
	
	/**
	 * Sets the ID of the Entity with the passed String value
	 * @param ID
	 */
	//public void setId(String Id);
	
	
	/**
	 * Caclulate the fitness of the <code>Entity</code>. This method will increment the
	 * number of fitness evaluations for the algorithm
	 */
	public void calculateFitness();
	
	/**
	 * Calculate the fitness of the <code>Entity</code>. This method may or may not
	 * increment the number of fitness evaluations of the algorithm.
	 * @param count Add or do not add this fitness evaluation to the algorithm global count.
	 */
	public void calculateFitness(boolean count);
	
	/**
	 * Returns the Entities fitness
	 * @return Fitness
	 */
	public Fitness getFitness();
	
	
	/**
	 * Intialise the Entity to something meaningful and within the problem space.
	 * The exact semantics of this method is defined by the classes that implements this interface.
	 * @param problem
	 * @param Take note. The Intialiser is obsolete the new Type System handles it now. Init can be left out now.
	 */
	public void initialise(OptimisationProblem problem);
	
	
	/**
	 * Returns the dimension of the Entity
	 * @return
	 */
	public int getDimension();
	
	
	/**
	 * 
	 *
	 */
	public void reinitialise();
	
	public boolean equals(Object o);


	/**
	 * Get the properties associate with the <code>Entity</code>
	 * @return
	 */
	public Map<String, Type> getProperties();


	/**
	 * Set the properties for the current <code>Entity</code>
	 * @param properties
	 */
	public void setProperties(Map<String, Type> properties);
}