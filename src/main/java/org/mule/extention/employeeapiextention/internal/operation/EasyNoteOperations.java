package org.mule.extention.employeeapiextention.internal.operation;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;
import org.mule.extention.employeeapiextention.api.EasyNoteDTO;
import org.mule.extention.employeeapiextention.internal.configuration.EasyNoteAPIConfiguration;
import org.mule.extention.employeeapiextention.internal.connection.EasyNoteAPIConnection;
import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.metadata.fixed.InputJsonType;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import java.io.InputStream;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class EasyNoteOperations {

  @MediaType(value = ANY,strict = false)
  public InputStream listAllEmployees(@Connection EasyNoteAPIConnection connection, @Config EasyNoteAPIConfiguration configuration)throws  Exception{
    System.out.println("EmployeeAPIOperations.listAllEmployees");
    return connection.callHttpListAllEmployees(configuration);
  }

  @MediaType(value = ANY,strict = false)
  public InputStream insertEmployee(@Expression(ExpressionSupport.REQUIRED)@Content @InputJsonType(schema= "metadata/createEmployeeDTO") EasyNoteDTO easyNoteDTO, @Connection EasyNoteAPIConnection connection, @Config EasyNoteAPIConfiguration configuration)throws  Exception{
    System.out.println("EmployeeAPIOperations.listAllEmployees");
    System.out.println(easyNoteDTO);
    return connection.callHttpPostEmployee(easyNoteDTO,configuration);
  }

  @MediaType(value = ANY,strict = false)
  public InputStream getEmployeeById(@Expression(ExpressionSupport.SUPPORTED) String employeeId, @Connection EasyNoteAPIConnection connection, @Config EasyNoteAPIConfiguration configuration)throws  Exception{
    System.out.println("EmployeeAPIOperations.listAllEmployees");
    return connection.callHttpGetEmployeeById(employeeId,configuration);
  }

  @MediaType(value = ANY,strict = false)
  public InputStream insertOrReplaceEmployee(@Expression(ExpressionSupport.SUPPORTED) String employeeId, @Expression(ExpressionSupport.REQUIRED)@Content @InputJsonType(schema= "metadata/createEmployeeDTO") EasyNoteDTO easyNoteDTO, @Connection EasyNoteAPIConnection connection, @Config EasyNoteAPIConfiguration configuration)throws  Exception{
    System.out.println("EmployeeAPIOperations.listAllEmployees");
    return connection.callHttpPutEmployee(employeeId, easyNoteDTO,configuration);
  }

  @MediaType(value = ANY,strict = false)
  public InputStream deleteEmployee(@Expression(ExpressionSupport.SUPPORTED) String employeeId, @Connection EasyNoteAPIConnection connection, @Config EasyNoteAPIConfiguration configuration)throws  Exception{
    System.out.println("EmployeeAPIOperations.listAllEmployees");
    return connection.callHttpDeleteEmployeeById(employeeId,configuration);
  }
}
