package org.lappsgrid.vocabulary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Keith Suderman
 */
public final class Annotations
{
   protected static final Map<String,String> index = new HashMap<String, String>();

   private Annotations()
   {

   }

   public static final String SENTENCE = "Sentence";
   public static final String TOKEN = "Token";
   public static final String NE = "NamedEntity";
   public static final String NE_PERSON = "Person";
   public static final String NE_LOCATION = "Location";
   public static final String NE_ORG = "Organization";
   public static final String PART_OF_SPEECH = "pos";
   public static final String NOMINAL_COREFERENCE = "alias";
   public static final String PRONOMINAL_CORREFERNCE = "coref";
   public static final String LOOKUP = "Lookup";
   public static final String NCHUNK = "NounChunk";
   public static final String VCHUNK = "VerbChunk";

   static {
      index.put("s", SENTENCE);
      index.put("sent", SENTENCE);
      index.put("tok", TOKEN);
      index.put("word", TOKEN);
      index.put("organization", NE_ORG);
   }


   public static String translate(String input)
   {
      String key = input.toLowerCase();
      String result = index.get(key);
      if (result != null)
      {
         return result;
      }
      return key;
   }
}
