package org.lappsgrid.api;

import java.lang.reflect.*;
import java.beans.*;

/**
 * @author Keith Suderman
 */
public class DataBeanInfo //extends SimpleBeanInfo
{
   public DataBeanInfo()
   {

   }

   public PropertyDescriptor[] getPropertyDescriptors()
   {
      Class[] stringClass = new Class[] { String.class };
      Class[] longClass = new Class[] { long.class };
      try
      {
         Method payloadGetter = Data.class.getMethod("getPayload", null);
         Method payloadSetter = Data.class.getMethod("setPayload", stringClass);
         Method discriminatorGetter = Data.class.getMethod("getDiscriminator", null);
         Method discriminatorSetter = Data.class.getMethod("setDiscriminator", longClass);

         PropertyDescriptor payloadDescriptor = new PropertyDescriptor("payload",
                 payloadGetter, payloadSetter);
         PropertyDescriptor discriminatorDescriptor = new PropertyDescriptor(
                 "discriminator", discriminatorGetter, discriminatorSetter);
         return new PropertyDescriptor[] {
                 payloadDescriptor, discriminatorDescriptor
         };
      }
      catch (Exception e)
      {
         throw new Error(e.getMessage());
      }
   }

//   pxrivate final static Class c = Foo.class;
//
//   public PropertyDescriptor[] getPropertyDescriptors()
//   {
//      try{
//         Class[] sp = new Class[] {String.class};
//         Method s_setter = c.getMethod( "_setS", sp );
//         Method s_getter = c.getMethod( "_getS", null );
//         PropertyDescriptor spd = new PropertyDescriptor("s", s_getter, s_setter);
//         PropertyDescriptor[] list = { spd };
//         return list;
//      }catch (IntrospectionException iexErr){
//         throw new Error(iexErr.toString());
//      }catch (NoSuchMethodException nsme){
//         throw new Error(nsme.toString());
//      }
//   }
}
