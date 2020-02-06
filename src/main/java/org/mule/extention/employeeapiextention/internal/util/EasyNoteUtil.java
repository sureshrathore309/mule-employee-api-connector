package org.mule.extention.employeeapiextention.internal.util;

import com.google.gson.Gson;
import org.mule.extention.employeeapiextention.api.EasyNoteDTO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class EasyNoteUtil {

    public static byte[] getByteArrayDataJsonBody(EasyNoteDTO easyNoteDTO){
        System.out.println("EmployeeUtil.getByteArrayDataJsonBody");
        Gson gson =null;
        String jsonBody=null;
        byte[] byteArrayData =null;
        gson = new Gson();
        jsonBody=gson.toJson(easyNoteDTO);
        System.out.println(jsonBody);
        byteArrayData = jsonBody.getBytes(StandardCharsets.UTF_8);
        return byteArrayData;
    }

    public static InputStream getInputStreamDataJsonBody(EasyNoteDTO easyNoteDTO)throws IOException {
        InputStream inputStream=null;
        inputStream=new ByteArrayInputStream(getByteArrayDataJsonBody(easyNoteDTO));
        return inputStream;
    }
}
