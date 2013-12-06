package org.lappsgrid.discriminator.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Ignore;
import org.junit.Test;
import org.lappsgrid.discriminator.DiscriminatorRegistry;
import org.lappsgrid.discriminator.Types;

public class TypesTest
{
   final static long EXPECTED_GET_VALUE = 3073L;
   final static long EXPECTED_LIST_VALUE = 3075L;

    @Test
    public void testRegex()
    {
        long code = DiscriminatorRegistry.get("regex");
        assertTrue(code > 0);
    }

   @Test
   public void testTypes() throws IllegalArgumentException, IllegalAccessException
   {
      assertTrue(Types.ERROR == 0);
      Field[] fields = Types.class.getDeclaredFields();
      for (Field field : fields)
      {
         long value = field.getLong(null);
         assertTrue("Invalid value for " + field.getName(), value >= 0);
      }
   }

   @Test
   public void testTextIsNotaDocument()
   {
      assertFalse(DiscriminatorRegistry.isa(Types.TEXT, Types.DOCUMENT));
   }

   @Test
   public void testGateIsaDocument()
   {
      assertTrue(DiscriminatorRegistry.isa(Types.GATE, Types.DOCUMENT));
   }

   @Test
   public void testQueryGetValue()
   {
      long actual = DiscriminatorRegistry.get("get");
      assertTrue("Discriminator for GET has changed!", EXPECTED_GET_VALUE == actual);
   }

   @Test
   public void testQueryListValue()
   {
      long actual = DiscriminatorRegistry.get("list");
      assertTrue("Discriminator for LIST has changed!", EXPECTED_LIST_VALUE == actual);
   }
}
