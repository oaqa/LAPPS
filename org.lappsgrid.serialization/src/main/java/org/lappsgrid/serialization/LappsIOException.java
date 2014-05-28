package org.lappsgrid.serialization;

import java.io.IOException;

/**
 * @author Keith Suderman
 */
public class LappsIOException extends IOException
{
   public LappsIOException(String s)
   {
      super(s);
   }

   public LappsIOException(String s, Throwable throwable)
   {
      super(s, throwable);
   }

   public LappsIOException(Throwable throwable)
   {
      super(throwable);
   }

   public LappsIOException()
   {

   }
}
