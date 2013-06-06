package org.lapps.datasource;

/**
 * Defines how to cache data source based on {@link DataQuery} and {@link ViewOptions}.
 *  
 * @author Di Wang
 */
public interface DataSourceCachingStrategy {

  /**
   * Adds a corpus to the cache.
   *
   * @param query the query
   * @param option the option
   * @param corpus the corpus
   */
  public void addToCache(DataQuery query, ViewOptions option, DataSource corpus);

  /**
   * Gets a corpus the from cache.
   *
   * @param query the query
   * @param option the option
   * @return the from cache
   */
  public DataSource getFromCache(DataQuery query, ViewOptions option);

}