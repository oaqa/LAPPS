package edu.cmu.lti.oaqa.cseweb.model;

import java.io.Serializable;

public class LappsServiceDescriptor implements Serializable {

  private static final long serialVersionUID = 1L;

  String resourceName;
  String endpoint;

  public String getResourceName() {
    return resourceName;
  }
  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }
  public String getEndpoint() {
    return endpoint;
  }
  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }
}
