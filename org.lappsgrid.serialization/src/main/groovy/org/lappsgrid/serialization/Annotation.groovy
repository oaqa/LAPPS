package org.lappsgrid.serialization
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonSerialize

/**
 * Information about a standoff annotation.
 *
 * @author Keith Suderman
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder(['type', 'id', 'start', 'end', 'features', 'metadata'])
public class Annotation {
    /** A unique ID assigned to this annotation.
     * <p>
     * <em>Note:</em> This ID value is assigned to the annotation by the framework
     * and is not to be confused with an ID (xml:id, etc) value that the annotation
     * itself might contain.
     */
    String id

    /** The label used for the annotation, e.g. tok, s, etc. */
    @JsonProperty('@type')
    String type

    /** The start offset of the annotation. */
    long start = -1
    /** The end offset of the annotation. */
    long end = -1

    /** Features of the annotation. */
    Map features = [:]

    /** Features assigned by the framework to the annotation. E.g. a confidence
     * score, the processor that generated the annotation etc.
     */
    Map metadata = [:]

    public Annotation() { }
    public Annotation(Map map) {
        map.each { key, value ->
            switch(key) {
                case 'label':
                case 'type':
                    this.type = value
                    break
                case 'start':
                    this.start = value as Long
                    break
                case 'end':
                    this.end = value as Long
                    break
                case 'id':
                    this.id = value
                    break
                case 'features':
                    this.features << value
                    break
                case 'metadata':
                    this.metadata << value
                    break
                default:
                    //println "${key} = ${value}"
                    features[key] = value
                    break
            }
        }
    }

    @JsonIgnore
    void setLabel(String label) {
        this.type = label
    }

    @JsonIgnore
    String getLabel() { return this.type }

    String toString() {
        return "${label} (${start}-${end}) ${features}"
    }

}
