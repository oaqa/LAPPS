package org.lappsgrid.serialization

/**
 * @author Keith Suderman
 */
class Context {
    public static final String REMOTE = "http://vocab.lappsgrid.org/context-1.0.0.jsonld";

    public static final Map LOCAL = [
            '@vocab':'http://vocab.lappsgrid.org/',
            'meta':'http://vocab.lappsgrid.org/metadata/',
            'lif':'http://vocab.lappsgrid.org/interchange/',
            'types':'http://vocab.lappsgrid.org/types/',
            'metadata': 'meta:metadata',
            'contains': 'meta:contains',
            'producer': 'meta:producer',
            'url': ['@id':'meta:url', '@type':'@id'],
            'type':['@id':'meta:type', '@type':'@id'],
            'version':'meta:version',
            'text':'lif:text',
            'steps': 'lif:steps',
            'annotations': 'lif:annoations',
            'tokenization': 'types:tokenization/',
            'tagset': 'types:posType/',
            'ner': 'types:ner/',
            'coref': "types:coref/",
            'chunk': "types:chunk/",
            'lookup': "types:lookup/"

    ]
}
