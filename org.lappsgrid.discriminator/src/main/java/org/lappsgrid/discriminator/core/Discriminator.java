package org.lappsgrid.discriminator.core;


import java.util.Set;

/**
 * Discriminator objects are used to provide type information about
 * Data objects returned by a DataSource.
 * <p>
 * Discriminator objects are never exposed directly to users. Rather
 * the user interacts with a DiscriminatorRegistry to
 * obtain discriminator id values and to map between discriminator
 * names and discriminator values.
 * 
 * @author Keith Suderman
 *
 */
public interface Discriminator extends java.io.Serializable
{   
   long getId();
   boolean isa(Discriminator discriminator);
   Set<Discriminator> getAncestors();
}
