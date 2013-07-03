package org.lappsgrid.api;

import javax.jws.WebService;

import jp.go.nict.langrid.commons.rpc.intf.*;


/**
 * A DataSource returns {@link Data} objects based on an input query.
 * <p>
 * The type of Data returned by a data source depends on the data 
 * source implementation. Possibilities include, but are not limited
 * to, entire documents, segments of documents, XML documents (or
 * fragments), single words, or lists of annotations.
 * 
 * @author Keith Suderman
 *
 */
@Service(namespace="lapps:datasource")
@WebService
public interface DataSource
{
   /**
    * Returns a data object corresponding to the given query.
    * the given query.  
    * 
    * @param query
    * @return
    */
   Data query(Data query);
}
