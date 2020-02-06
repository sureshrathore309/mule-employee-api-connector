package org.mule.extention.employeeapiextention.internal.configuration;

import org.mule.extention.employeeapiextention.internal.operation.EasyNoteOperations;
import org.mule.extention.employeeapiextention.internal.connection.provider.EasyNoteAPIConnectionProvider;
import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;

/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations(EasyNoteOperations.class)
@ConnectionProviders(EasyNoteAPIConnectionProvider.class)
public class EasyNoteAPIConfiguration {

  @Parameter
  @Expression(ExpressionSupport.SUPPORTED)
  private String clientId;

  @Parameter
  @Expression(ExpressionSupport.SUPPORTED)
  private String clientSecret;

  public String getClientId() {
    System.out.println(clientId);
    return clientId;
  }

  public String getClientSecret() {
    System.out.println(clientSecret);
    return clientSecret;
  }
}
