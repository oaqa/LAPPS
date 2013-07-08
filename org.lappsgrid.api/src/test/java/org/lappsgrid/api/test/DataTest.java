package org.lappsgrid.api.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.lappsgrid.api.Data;

import java.io.*;

/**
 * @author Keith Suderman
 */
public class DataTest {

  @Test
  public void testSerialization() throws IOException, ClassNotFoundException {
    // Round trip a Data object through the serialization process.
    runSerializationTest(new Data(0, "message"));
    runSerializationTest(new Data(999, "another message"));
    runSerializationTest(new Data(-1, "a negative discriminator"));
  }

  @Test
  public void testBase64Constructor() {
    byte[] expected = { 0, 1, 2, 3, 4 };
    Data data = new Data(-1, expected);
    byte[] actual = data.asBytes();
    assertTrue(actual.length == expected.length);
    for (int i = 0; i < expected.length; ++i) {
     assertTrue(actual[i] == expected[i]);
    }
  }

  @Test
  public void testAsBytes() {
    byte[] expected = { 0, 1, 2, 3, 4 };
    Data data = new Data(-1);
    data.asBytes(expected);
    byte[] actual = data.asBytes();
    assertTrue(actual.length == expected.length);
    for (int i = 0; i < expected.length; ++i) {
      assertTrue(actual[i] == expected[i]);
    }
  }

  @Test
  public void testStringAsBytes() throws UnsupportedEncodingException {
    byte[] expected = "hello world".getBytes("UTF-8");
    Data data = new Data(-1);
    data.asBytes(expected);
    byte[] actual = data.asBytes();
    assertTrue(actual.length == expected.length);
    for (int i = 0; i < expected.length; ++i) {
      assertTrue(actual[i] == expected[i]);
    }
  }

  private void runSerializationTest(Data expected) throws IOException, ClassNotFoundException {
    Data actual = roundTrip(expected);
    assertTrue(expected.getDiscriminator() == actual.getDiscriminator());
    assertTrue(expected.getPayload().equals(actual.getPayload()));
    // Make sure the payloads do not point to the same string object.
    assertFalse(expected.getPayload() == actual.getPayload());
  }

  private Data roundTrip(Data data) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream ostream = new ObjectOutputStream(out);
    ostream.writeObject(data);
    ostream.close();

    ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
    ObjectInputStream istream = new ObjectInputStream(in);
    return (Data) istream.readObject();
  }
}
