package org.lappsgrid.vocabulary;

/**
 * @author Keith Suderman
 */
public class Features
{
   private Features()
   {

   }

   public static final String PART_OF_SPEECH = "pos";
   public static final String LEMMA = "lemma";
   public static final String WORD = "word";
   public static final String CATEGORY = "category";
   public static final String NER = "ner";

   public static class Token
   {
      public static final String ID = "id";
      public static final String START = "start";
      public static final String END = "end";
      public static final String PART_OF_SPEECH = "pos";
      public static final String LEMMA = "lemma";
      public static final String WORD = "string";
      public static final String TYPE = "type";
      public static final String ORTH = "orth";
      public static final String NER = "namedEntity";

   }

   public static class Sentence
   {
      public static final String ID = "id";
      public static final String START = "start";
      public static final String END = "end";
      public static final String TYPE = "type";
   }
}
