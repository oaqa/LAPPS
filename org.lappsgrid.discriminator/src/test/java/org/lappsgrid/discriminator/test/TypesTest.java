package org.lappsgrid.discriminator.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Ignore;
import org.junit.Test;
import org.lappsgrid.discriminator.DiscriminatorRegistry;
import org.lappsgrid.discriminator.Types;
import org.lappsgrid.discriminator.core.Discriminator;

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
         assertTrue("Invalid value (" + value + ") for " + field.getName(), value >= 0);
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

   @Test
   public void testOnePerLine()
   {
      long actual = DiscriminatorRegistry.get("one-per-line");
      assertTrue(actual == Types.ONE_PER_LINE);
      assertTrue(DiscriminatorRegistry.isa("one-per-line", "text"));
   }

   @Test
   public void testStanford()
   {
      long stanford = DiscriminatorRegistry.get("stanford");
      long onePerLine = DiscriminatorRegistry.get("one-per-line");
      assertTrue(DiscriminatorRegistry.isa(stanford, onePerLine));
      assertTrue(DiscriminatorRegistry.isa("stanford", "one-per-line"));
      assertTrue(DiscriminatorRegistry.isa("stanford", "document"));
   }

   @Test
   public void testOpenNlp()
   {
      long opennlp = DiscriminatorRegistry.get("opennlp");
      long onePerLine = DiscriminatorRegistry.get("one-per-line");
      assertTrue(DiscriminatorRegistry.isa(opennlp, onePerLine));
      assertTrue(DiscriminatorRegistry.isa("opennlp", "one-per-line"));
      assertTrue(DiscriminatorRegistry.isa("opennlp", "document"));
   }

   @Test
   public void testJsonTypes()
   {
      long doc = DiscriminatorRegistry.get("document");
      long json = DiscriminatorRegistry.get("json");
      long jsonld = DiscriminatorRegistry.get("json-ld");
      assertTrue(DiscriminatorRegistry.isa(json, doc));
      assertTrue(DiscriminatorRegistry.isa(jsonld, json));
      assertTrue(DiscriminatorRegistry.isa(jsonld, doc));

      jsonld = DiscriminatorRegistry.get("jsonld");
      assertTrue(DiscriminatorRegistry.isa(jsonld, json));
      assertTrue(DiscriminatorRegistry.isa(jsonld, doc));
   }
}
