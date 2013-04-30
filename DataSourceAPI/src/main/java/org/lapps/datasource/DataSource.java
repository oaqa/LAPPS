package org.lapps.datasource;

/**
 * Represents a ranked list of documents with annotations.
 * 
 * The implementation of this interface may store document id (and/or spans) itself and/or caching with {@link DataSourceCachingStrategy}.
 * 
 * @author Di Wang
 * 
 */
public interface DataSource {

  /**
   * Gets a subset of corpus selected by input query.
   *
   * @param query the input query
   * @return a subset of annotated corpus
   */
  public DataSource subCorpus(Query query);

  /**
   * Gets the document stream reader of current corpus.
   *
   * @param options the options that specify how to present each document such as returning "doc
id", "doc content", "annotation", "annotation spans", etc.
   * @return the document stream reader
   */
  public DocumentStreamReader getDocumentStreamReader(ViewOptions options);

  /**
   * Gets one document by documentID.
   *
   * @param options the options that specify how to present each document such as returning "doc
id", "doc content", "annotation", "annotation spans", etc.
   * @param documentID the document id
   * @return the document
   */
  public Document getDocument(ViewOptions options, String documentID);

}
