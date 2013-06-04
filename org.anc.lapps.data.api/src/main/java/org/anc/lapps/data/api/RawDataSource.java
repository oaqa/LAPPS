package org.anc.lapps.data.api;

import jp.go.nict.langrid.commons.rpc.intf.Service;

/**
 * A RawDataSource returns {@link Data} objects. 
 * <p>
 * The type of Data returned by a data source depends on the data 
 * source implementation. Possibilities include, but are not limited
 * to, entire documents, segments of documents, XML documents (or
 * fragments), single words, or lists of annotations.
 * 
 * @author Keith Suderman
 * @author Di Wang
 */
@Service(namespace="lapps:raw-datasource")
public interface RawDataSource {
	Data query(String query);
}