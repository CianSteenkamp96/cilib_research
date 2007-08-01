/*
 * LBestTopology.java
 *
 * Created on January 17, 2003, 6:34 PM
 *
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
 *   
 */

package net.sourceforge.cilib.entity.topologies;

import java.util.Iterator;
import java.util.NoSuchElementException;

import net.sourceforge.cilib.entity.Entity;


/**
 * <p>
 * Implementation of the lbest neighbourhood topology
 * </p><p>
 * References:
 * </p><p><ul><li>
 * R.C. Eberhart, P. Simpson, and R. Drobbins, "Computational Intelligence PC Tools,"
 * chapter 6, pp. 212-226. Academic Press Professional, 1996.
 * </li></ul></p>
 *
 * @author  Edwin Peer
 */
public class LBestTopology<E extends Entity> extends GBestTopology<E> {
	private static final long serialVersionUID = 93039445052676571L;

	/**
     * Creates a new instance of <code>LBestTopology</code>.
     */
    public LBestTopology() {
        super();
        neighbourhoodSize = 3;
    }
    
    public LBestTopology(LBestTopology<E> copy) {
    	super(copy);
    	this.neighbourhoodSize = copy.neighbourhoodSize;
    }
    
    public LBestTopology<E> clone() {
    	return new LBestTopology<E>(this);
    }
    
    
    @SuppressWarnings("unchecked")
	public Iterator<E> neighbourhood(Iterator<? extends Entity> iterator) {
        return new LBestNeighbourhoodIterator<E>(this, (ArrayIterator<E>) iterator);
    }
    
    
    /**
     * Sets the number particles in the neighbourhood of each particle. The default is 3.
     *
     * @param neighbourhoodSize The size of the neighbourhood.
     */
    public void setNeighbourhoodSize(int neighbourhoodSize) {
        this.neighbourhoodSize = neighbourhoodSize;
    }
    
    
    /**
     * Accessor for the number of particles in a neighbourhood.
     *
     * @return The size of the neighbourhood.
     */
    public int getNeighbourhoodSize() {
    	if (super.size() == 0) { // to show a sensible default value in CiClops
    		return neighbourhoodSize;
    	}
        else if (neighbourhoodSize > super.size()) {
            return super.size();
        }
        else {
            return neighbourhoodSize;
        }
    }
    
    private int neighbourhoodSize;
    
    private class LBestNeighbourhoodIterator<T extends Entity> implements ArrayIterator<T> {
        
        public LBestNeighbourhoodIterator(LBestTopology<T> topology, ArrayIterator iterator) {
            if (iterator.getIndex() == -1) {
                throw new IllegalStateException();
            }
            this.topology = topology;
            index = iterator.getIndex() - (topology.getNeighbourhoodSize() / 2) - 1; // TODO: get ediwn to explain this
            if (index < 0) {
                index += topology.size();
            }
            count = 0;
        }
        
        public int getIndex() {
            return index;
        }
        
        public boolean hasNext() {
            return (count != topology.getNeighbourhoodSize());
        }
        
        public T next() {
            if (count == topology.getNeighbourhoodSize()) {
                throw new NoSuchElementException();
            }
            ++index;
            ++count;
            if (index == topology.size()) {
               index = 0; 
            }
            return topology.entities.get(index);
        }
        
        public void remove() {
            topology.entities.remove(index);
            --index;
            if (index < 0) {
            	index += topology.size();
            }
        }
        
        private LBestTopology<T> topology;
        private int index;
        private int count;
    }
}