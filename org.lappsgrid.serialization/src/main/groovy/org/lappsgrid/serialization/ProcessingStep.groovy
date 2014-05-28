package org.lappsgrid.serialization
import com.fasterxml.jackson.annotation.JsonPropertyOrder

/**
 * @author Keith Suderman
 */
@JsonPropertyOrder(['metadata', 'annotations'])
public class ProcessingStep {
    Map metadata
    List<Annotation> annotations

    public ProcessingStep() {
        metadata = [:]
        annotations = []
    }

    public ProcessingStep(Map map) {
        metadata = map.metadata
        annotations = map.annotations
    }

    void addMetaData(String name, Object value) {
        metadata[name] = value
    }

    void addAnnotation(Annotation annotation) {
        annotations << annotation
    }

    void add(Annotation annotation) {
        annotations << annotation
    }

    boolean contains(String name) {
        return metadata.contains[name] != null
    }

    Contains getContains(String name) {
        return metadata?.contains[name]
    }

    void addContains(String name, String producer, String type) {
//        ValueObject containsType = new ValueObject(type:type, value:value)
        if (metadata.contains == null) {
            metadata.contains = [:]
        }
        metadata.contains[name] = new Contains(producer:producer, type:type)
    }

}
