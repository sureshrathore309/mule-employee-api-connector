package org.mule.extention.employeeapiextention.internal.connection;


import org.mule.extention.employeeapiextention.api.EasyNoteDTO;
import org.mule.extention.employeeapiextention.internal.configuration.EasyNoteAPIConfiguration;
import org.mule.extention.employeeapiextention.internal.constants.Url.EasyNoteAPIURL;
import org.mule.extention.employeeapiextention.internal.util.EasyNoteUtil;
import org.mule.runtime.api.util.MultiMap;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.HttpService;
import org.mule.runtime.http.api.client.HttpClient;
import org.mule.runtime.http.api.client.HttpClientConfiguration;
import org.mule.runtime.http.api.domain.entity.InputStreamHttpEntity;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.request.HttpRequestBuilder;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import javax.inject.Inject;
import java.io.InputStream;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class EasyNoteAPIConnection {

  private int connectionTimeout;
  private HttpClient httpClient;
  private HttpRequestBuilder httpRequestBuilder;

  @Inject
  private HttpService httpService;

  public EasyNoteAPIConnection(int connectionTimeout) {
    System.out.println("EmployeeAPIConnection.EmployeeAPIConnection constructor()");
    this.connectionTimeout = connectionTimeout;
  }

  public void initHttpClient(){
    HttpClientConfiguration.Builder builder=null;

    System.out.println("EmployeeAPIConnection.initHttpClient");
    builder=new HttpClientConfiguration.Builder();
    builder.setName("Apisero-Employee-API-Connector");
    httpRequestBuilder= HttpRequest.builder();
    System.out.println(httpService==null);
    httpClient=httpService.getClientFactory().create(builder.build());
    httpClient.start();
  }

  public void invalidate() {
    System.out.println("EmployeeAPIConnection.invalidate");
    httpClient.stop();
  }

  public InputStream callHttpListAllEmployees(EasyNoteAPIConfiguration configuration){
    InputStream inputStream=null;
    HttpResponse response=null;
    String uri=null;
    HttpRequest httpRequest=null;
    MultiMap<String,String> headers=null;
    System.out.println("EmployeeAPIConnection.callhttpListFiles");
    try {
      if(httpClient==null) {
        this.initHttpClient();
      }
      headers = getHeaders(configuration);
      uri = EasyNoteAPIURL.getListAllEmployeesUrl();
      httpRequest = httpRequestBuilder
              .method(HttpConstants.Method.GET)
              .uri(uri)
              .headers(headers)
              .build();
      response = httpClient.send(httpRequest, connectionTimeout, false, null);
      inputStream=response.getEntity().getContent();
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return inputStream;
  }

  public InputStream callHttpPostEmployee(EasyNoteDTO easyNoteDTO, EasyNoteAPIConfiguration configuration){
    InputStream inputStream=null;
    HttpResponse response=null;
    String uri=null;
    HttpRequest httpRequest=null;
    MultiMap<String,String> headers=null;
    byte[] byteArray=null;
    System.out.println("EmployeeAPIConnection.callhttpPutEmployee");
    try {
      if(httpClient==null) {
        this.initHttpClient();
      }
      byteArray= EasyNoteUtil.getByteArrayDataJsonBody(easyNoteDTO);
      headers = getHeaders(configuration);
      uri = EasyNoteAPIURL.getPostEmployeeUrl();
      httpRequest = httpRequestBuilder
              .method(HttpConstants.Method.POST)
              .uri(uri)
              .headers(headers)
              .addHeader("Content-Type", MediaType.APPLICATION_JSON)
              .entity(new InputStreamHttpEntity(EasyNoteUtil.getInputStreamDataJsonBody(easyNoteDTO)))
              .build();
      response = httpClient.send(httpRequest, connectionTimeout, false, null);
      inputStream=response.getEntity().getContent();
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return inputStream;
  }

  public InputStream callHttpGetEmployeeById(String employeeId, EasyNoteAPIConfiguration configuration){
    InputStream inputStream=null;
    HttpResponse response=null;
    String uri=null;
    HttpRequest httpRequest=null;
    MultiMap<String,String> headers=null;
    System.out.println("EmployeeAPIConnection.callhttpGetEmployeeById");
    try {
      if(httpClient==null) {
        this.initHttpClient();
      }
      headers = getHeaders(configuration);
      uri = EasyNoteAPIURL.getGetEmployeeByIdUrl()+employeeId;
      httpRequest = httpRequestBuilder
              .method(HttpConstants.Method.GET)
              .uri(uri)
              .headers(headers)
              .build();
      response = httpClient.send(httpRequest, connectionTimeout, false, null);
      inputStream=response.getEntity().getContent();
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return inputStream;
  }

  public InputStream callHttpPutEmployee(String employeeId, EasyNoteDTO easyNoteDTO, EasyNoteAPIConfiguration configuration){
    InputStream inputStream=null;
    HttpResponse response=null;
    String uri=null;
    HttpRequest httpRequest=null;
    MultiMap<String,String> headers=null;
    byte[] byteArray=null;
    System.out.println("EmployeeAPIConnection.callhttpPutEmployee");
    try {
      if(httpClient==null) {
        this.initHttpClient();
      }
      byteArray= EasyNoteUtil.getByteArrayDataJsonBody(easyNoteDTO);
      headers = getHeaders(configuration);
      uri = EasyNoteAPIURL.getPutEmployeeUrl()+employeeId;
      httpRequest = httpRequestBuilder
              .method(HttpConstants.Method.PUT)
              .uri(uri)
              .headers(headers)
              .addHeader("Content-Type", MediaType.APPLICATION_JSON)
              .entity(new InputStreamHttpEntity(EasyNoteUtil.getInputStreamDataJsonBody(easyNoteDTO)))
              .build();
      response = httpClient.send(httpRequest, connectionTimeout, false, null);
      inputStream=response.getEntity().getContent();
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return inputStream;
  }

  public InputStream callHttpDeleteEmployeeById(String employeeId, EasyNoteAPIConfiguration configuration){
    InputStream inputStream=null;
    HttpResponse response=null;
    String uri=null;
    HttpRequest httpRequest=null;
    MultiMap<String,String> headers=null;
    System.out.println("EmployeeAPIConnection.callhttpGetEmployeeById");
    try {
      if(httpClient==null) {
        this.initHttpClient();
      }
      headers = getHeaders(configuration);
      uri = EasyNoteAPIURL.getDeleteEmployeeUrl()+employeeId;
      httpRequest = httpRequestBuilder
              .method(HttpConstants.Method.DELETE)
              .uri(uri)
              .headers(headers)
              .build();
      response = httpClient.send(httpRequest, connectionTimeout, false, null);
      inputStream=response.getEntity().getContent();
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return inputStream;
  }

  private MultiMap<String, String> getHeaders(EasyNoteAPIConfiguration configuration) {
    MultiMap<String, String> headers;
    headers = new MultiMap<>();
    headers.put("client_id", configuration.getClientId());
    headers.put("client_secret", configuration.getClientSecret());
    return headers;
  }

}
