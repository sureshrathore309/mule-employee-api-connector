package org.mule.extention.employeeapiextention.internal.connection.provider;

import org.mule.extention.employeeapiextention.internal.connection.EasyNoteAPIConnection;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.CachedConnectionProvider;

import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class (as it's name implies) provides connection instances and the funcionality to disconnect and validate those
 * connections.
 * <p>
 * All connection related parameters (values required in order to create a connection) must be
 * declared in the connection providers.
 * <p>
 * This particular example is a {@link PoolingConnectionProvider} which declares that connections resolved by this provider
 * will be pooled and reused. There are other implementations like {@link CachedConnectionProvider} which lazily creates and
 * caches connections or simply {@link ConnectionProvider} if you want a new connection each time something requires one.
 */
public class EasyNoteAPIConnectionProvider implements PoolingConnectionProvider<EasyNoteAPIConnection> {

  private final Logger LOGGER = LoggerFactory.getLogger(EasyNoteAPIConnectionProvider.class);

 /**
  * A parameter that is always required to be configured.
  */
 @Parameter
 @Placement(tab = "Advanced")
 @Optional(defaultValue = "5000")
 int connectionTimeout;

    @Override
    public EasyNoteAPIConnection connect() throws ConnectionException {
        System.out.println("EmployeeAPIConnectionProvider.connect");
        return new EasyNoteAPIConnection(connectionTimeout);
    }

    @Override
    public void disconnect(EasyNoteAPIConnection connection) {
        try {
            System.out.println("EmployeeAPIConnectionProvider.disconnect");
            connection.invalidate();
        } catch (Exception e) {
            LOGGER.error("Error while disconnecting [ "+ e.getMessage()+" ]", e);
        }
    }

    @Override
    public ConnectionValidationResult validate(EasyNoteAPIConnection connection) {
        System.out.println("EmployeeAPIConnectionProvider.validate");
        return ConnectionValidationResult.success();
    }
}
