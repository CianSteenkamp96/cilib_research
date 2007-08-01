/*
 * Topology.java
 * 
 * Created on Aug 5, 2005
 *
 * Copyright (C) 2003, 2004, 2005 - CIRG@UP 
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
package net.sourceforge.cilib.entity;

import java.util.Iterator;
import java.util.List;

import net.sourceforge.cilib.container.visitor.Visitor;
import net.sourceforge.cilib.entity.visitor.TopologyVisitor;

/**
 * This an abstract class which extends from the abstract Topology class.
 * All PSO Topologies must inherit from this class.
 * 
 * @author Gary Pampara
 * @author otter
 */
public abstract class Topology<E extends Entity> extends EntityCollection<E> {
	
	public abstract Topology<E> clone();
    
    /**
     * Returns an <code>Iterator</code> over all particles in the neighbourhood of
     * the particle referred to by the given <code>Iterator</code>.
     * 
     * @param An iterator that refers to a particle in this topology.
     * @return A particle iterator.
     */
    public abstract Iterator<E> neighbourhood(Iterator<? extends Entity> iterator);
    
    
    /**
     * Accept a vistitor and perform the visitor actions on this 
     * <tt>Topology</tt>.
     * 
     * @param visitor The {@see net.sourceforge.cilib.container.visitor.Visitor} to accept
     */
    public void accept(Visitor<E> visitor) {
        for (Iterator<E> i = this.iterator(); i.hasNext(); ) {
            visitor.visit(i.next());
        }
    }    
    
    public void accept(TopologyVisitor visitor) {
    	visitor.visit(this);
    }
    
    /**
     * Get all the entities witin the topology. 
     * @return Collection. Data collection of all the entities
     */
    public abstract List<Entity> asList();
    
    
    /**
     * Mainly for use in Co-Evolution, CCGA, Island GA and so on... where there is multiple populations.
     * Returns the topology identifier. 
     * 
     * @return A <tt>String</tt> representing the identifier.
     */
    public abstract String getId();
    
    
    /**
     * Set the identifier for this <tt>Topology</tt>.
     * 
     * @param id The identifier to set
     */
    public abstract void setId(String id);
}