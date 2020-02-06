package org.mule.extention.employeeapiextention.internal.constants.Url;

public class EasyNoteAPIURL {

    private static final String LIST_ALL_EMPLOYEES_URL="http://employee-info-api-proxy.us-e2.cloudhub.io/employee";
    private static final String POST_EMPLOYEE_URL="http://employee-info-api-proxy.us-e2.cloudhub.io/employee";
    private static final String GET_EMPLOYEE_BY_ID_URL="http://employee-info-api-proxy.us-e2.cloudhub.io/employee/";
    private static final String PUT_EMPLOYEE_URL="http://employee-info-api-proxy.us-e2.cloudhub.io/employee/";
    private static final String DELETE_EMPLOYEE_URL="http://employee-info-api-proxy.us-e2.cloudhub.io/employee/";

    public static String getListAllEmployeesUrl() {
        return LIST_ALL_EMPLOYEES_URL;
    }

    public static String getPostEmployeeUrl() {
        return POST_EMPLOYEE_URL;
    }

    public static String getGetEmployeeByIdUrl() {
        return GET_EMPLOYEE_BY_ID_URL;
    }

    public static String getPutEmployeeUrl() {
        return PUT_EMPLOYEE_URL;
    }

    public static String getDeleteEmployeeUrl() {
        return DELETE_EMPLOYEE_URL;
    }
}
