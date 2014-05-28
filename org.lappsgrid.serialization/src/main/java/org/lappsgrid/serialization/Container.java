package org.lappsgrid.serialization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Container objects associate a body of text with any annotations that have
 * been created for that text.
 *
 * This is the object that will eventually be serialized over the wire.
 *
 * @author Keith Suderman
 */
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({"context","metadata","text","steps"})
public class Container {

   /** The text that is to be annotated. */
   @JsonProperty("text")
   Content content = new Content();

   /** Any meta-data attached to this container. */
   Map<String,Object> metadata = new HashMap<String,Object>();

   /** The list of annotations that have been created for the text. */
   List<ProcessingStep> steps = new ArrayList<ProcessingStep>();

   private final ObjectMapper mapper = new ObjectMapper();

   @JsonProperty("@context")
   private Object context;


   /** Default (empty) constructor. Does nothing. */
   public Container() {
      this(true);
   }

   public Container(boolean local) {
      if (local) {
         context = Context.LOCAL;
      }
      else {
         context = Context.REMOTE;
      }
      mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
   }

   /** Constructs a Container object from the values stored in the Map. */
//   public Container(boolean local, Map map) {
//      this(local);
//      initFromMap(map);
//   }

   /** Constructs a Container object from the JSON representation. */
   public Container(String json) throws IOException
   {
      this(false);
      //Map map = new JsonSlurper().parseText(json)
      //initFromMap(map)
      Container proxy = mapper.readValue(json, Container.class);
      //this.text = new Text()
      //this.text.value = proxy.text.value
      //this.text.language = proxy.text.language
      this.content = proxy.content;
      this.metadata = proxy.metadata;
      this.steps = proxy.steps;
      this.context = proxy.context;
   }

   @JsonIgnore
   public void setLanguage(String lang) {
      content.setLanguage(lang);
   }

   @JsonIgnore
   public String getLanguage() {
      return content.getLanguage();
   }

   @JsonIgnore
   public void setText(String text) {
      this.content.setValue(text);
   }

   @JsonIgnore
   public String getText() {
      return this.content.getValue();
   }

//    private Content getContent() { return null }
//    private void setContent(Content ignored) { }

   public void define(String name, String iri) throws LappsIOException
   {
      if (!(this.context instanceof Map)) {
         throw new LappsIOException("Can not define a context field when a remote context is used.");
      }
      Map<String,Object> context = (Map<String,Object>) this.context;
      if (context.get(name) != null) {
         throw new LappsIOException("Context for " + name + " already defined.");
      }
      Map<String,String> value = new HashMap<String,String>();
      value.put("@id", iri);
      value.put("@type", "@id");
      context.put(name, value);
   }

   public String toJson() throws JsonProcessingException
   {
      mapper.disable(SerializationFeature.INDENT_OUTPUT);
      return mapper.writeValueAsString(this);
      //return new JsonLd(this).toString()
   }

   public String toPrettyJson() throws JsonProcessingException
   {
      mapper.enable(SerializationFeature.INDENT_OUTPUT);
      return mapper.writeValueAsString(this);
      //return new JsonLd(this).toPrettyString()
   }

   /** Calls toPrettyJson() */
   public String toString() {
      //return new JsonLd(this).toPrettyString()
//      return toJson()
      String json = null;
      try
      {
         json = toJson();
      }
      catch (JsonProcessingException e)
      {
         StringWriter writer = new StringWriter();
         e.printStackTrace(new PrintWriter(writer));
         return writer.toString();
      }
      return json;
   }

//   private void initFromMap(Map map) {
//      this.setText(map.get("text"));
//      map.metadata.each { name, value ->
//              this.metadata[name] = value
//      }
//      map.steps.each { step ->
//              ProcessingStep processingStep = new ProcessingStep()
//         step.metadata.each { key,value ->
//                 processingStep.metadata[key] = value
//         }
//         step.annotations.each { annotation ->
//                 processingStep.annotations << new Annotation(annotation)
//         }
//         this.steps << processingStep
//      }
//   }

}
