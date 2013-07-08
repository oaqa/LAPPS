package org.lappsgrid.api;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Data objects passed between LAPPS web services.
 * <p/>
 * Data objects consist of a <code>discrimintator</code> and a
 * <code>payload</code>. The payload field carries the data and the discriminator is used to
 * hold any type information for the data.
 * <p/>
 * Discriminator values are represented as <code>long</code> values in
 * this implementation.  A central "Discriminator Registry" should be
 * consulted to map discriminator names to values and vice-versa.
 *
 * @author Keith Suderman
 * @author Di Wang
 */
public class Data implements LappsSerializable {
  private static final long serialVersionUID = 3L;
  private static final String UTF8 = "UTF-8";

  protected long discriminator;
  protected String payload;

  // Empty default constructor.
  public Data() {
  }

  public Data(long type) {
    this.discriminator = type;
  }

  public Data(long type, String payload) {
    this.discriminator = type;
    this.payload = payload;
  }

  public Data(long type, byte[] payload) {
    this.discriminator = type;
    this.payload = DatatypeConverter.printBase64Binary(payload);
  }

  public long getDiscriminator() {
    return discriminator;
  }

  public String getPayload() {
    if (payload == null) {
      return null;
    }
    return payload;
  }

  public void setDiscriminator(long discriminator) {
    this.discriminator = discriminator;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  /**
   * Encodes the byte array as a Base64 string and stores the string
   * as the payload.
   *
   * @param bytes the byte array to be encoded.
   */
  public void asBytes(byte[] bytes) {
    this.payload = DatatypeConverter.printBase64Binary(bytes);
  }

  /**
   * Retrieves the payload string as a byte array.
   * <p/>
   * The payload is assumed to be a Base64 encoded String that was set
   * using the {@link #asBytes(byte[])} method or the
   * {@link #Data(long, byte[])} constructor. This method is <em>not</em>
   * the same as calling {@link #getPayload()}.getBytes().
   *
   * @return a byte array obtained by Base64 decoding the payload string.
   */
  public byte[] asBytes() {
    return DatatypeConverter.parseBase64Binary(payload);
  }

  @Override
  public void readObject(ObjectInputStream stream) throws IOException,
                                                          ClassNotFoundException {
    discriminator = stream.readLong();
    payload = stream.readObject().toString();
  }

  @Override
  public void writeObject(ObjectOutputStream stream) throws IOException,
                                                            ClassNotFoundException {
    stream.writeLong(discriminator);
    stream.writeObject(payload);
  }


}
