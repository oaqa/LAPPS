package org.lappsgrid.serialization

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Keith Suderman
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Content {
    @JsonProperty('@value')
    String value
    @JsonProperty('@language')
    String language

    public Content() { }
}
