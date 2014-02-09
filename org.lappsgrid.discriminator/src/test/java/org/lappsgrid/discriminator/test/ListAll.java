package org.lappsgrid.discriminator.test;

import org.junit.Test;
import org.lappsgrid.discriminator.DiscriminatorRegistry;

import java.util.Arrays;

/**
 * @author Keith Suderman
 */
public class ListAll
{
   public ListAll()
   {

   }

   @Test
   public void listAll()
   {
      long[] types = DiscriminatorRegistry.types();
      Arrays.sort(types);
      System.out.println("| Discriminator | Name |");
      System.out.println("|:--------------|:-----|");
      for (long type : types)
      {
         String name = DiscriminatorRegistry.get(type);
         System.out.println("| " + type + " | " + name + " |");
      }
   }
}
