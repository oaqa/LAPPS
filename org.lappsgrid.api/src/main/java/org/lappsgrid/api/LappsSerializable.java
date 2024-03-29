package org.lappsgrid.api;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A Serializable interface that includes readObject and writeObject methods.
 * <p>
 * LAPPS objects that are serialized should never rely on the default Java
 * serialization mechanism and should explicitly read and write their
 * data to/from object streams.
 * <p>
 * <b>NOTE</b> No LAPPS service should rely on Java serialization and this
 * interface will be deprecated in an upcoming release.
 *
 * @author Keith Suderman
 */
public interface LappsSerializable extends Serializable {
  void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException;

  void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException;
}
