package org.mule.extention.employeeapiextention.internal.extention;

import org.mule.extention.employeeapiextention.internal.configuration.EasyNoteAPIConfiguration;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;


/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Xml(prefix = "employee-api")
@Extension(name = "Employee API")
@Configurations(EasyNoteAPIConfiguration.class)
public class EasyNoteAPIExtension {

}
