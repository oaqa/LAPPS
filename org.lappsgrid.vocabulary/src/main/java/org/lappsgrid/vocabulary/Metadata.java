package org.lappsgrid.vocabulary;

/**
 * @author Keith Suderman
 */
public final class Metadata
{
   private Metadata()
   {

   }

//   public static final String PRODUCED_BY = "producedBy";
//   public static final String CONTAINS = "contains";

   public static class Contains
   {
      public static final String URL = "url";
      public static final String PRODUCER = "producer";
      public static final String TYPE = "type";
   }

   // These type definitions assume that the "type" prefix has been
   // defined in the LAPPS JSON-LD @context.
   public static class Types
   {
      public static final String TOKENIZATION = "type:tokenization";
      public static final String PART_OF_SPEECH = "type:part-of-speech";
      public static final String NAMED_ENTITIES = "type:named-entities";
      public static final String COREFERENCE = "type:coreference";
      public static final String SENTENCE = "type:sentence";
      public static final String LOOKUP = "type:lookup";
   }
}
