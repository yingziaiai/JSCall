package com.restfull.callTest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;
//http://www.cnblogs.com/snake-hand/p/3157332.html
//http://blog.csdn.net/u013766436/article/details/51095514
//httpclient模拟post请求json封装表单数据
//http://www.cnblogs.com/Vdiao/p/5339487.html
public class RestfullCallTest {
public static void main(String[] args) throws IOException {
//	String urlpath = "http://localhost:8080/mlc/memberID/SSOSession/JSON";
	String urlpath = "http://localhost:8080/mlc/12334/SSOSession";
	HttpURLConnection connection = null;
//    URL url = new URL(urlpath);
//    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//    connection.setDoOutput(true);
//    connection.setDoInput(true);
//    connection.setRequestMethod("POST");
//    connection.setUseCaches(false);
//    connection.setInstanceFollowRedirects(true);
//    connection.setRequestProperty("Content-Type","application/json"); 
//    connection.connect();  
//    DataOutputStream out = new DataOutputStream(connection.getOutputStream());  
//    JSONObject obj = new JSONObject();  
//       
//    obj.put("code", -1002);       
//    obj.put("message", "msg");  
//    out.writeBytes(obj.toString());  
//    out.flush();  
//    out.close();  
    try {
        URL url=new URL(urlpath);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("PUT");
        connection.setRequestMethod("PUT");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        
        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        JSONObject obj = new JSONObject();
        obj.element("memberId", "12345678");
        obj.element("appCode", "AM");
        obj.element("token", "87900$%8#dllsfsl");
        outputStream.writeBytes(obj.toString());
        outputStream.flush();
        outputStream.close();
//        new InputStreamReader(connection.getInputStream(), "utf-8");
//        new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lines;
        
        StringBuffer sb = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
			lines = new String(lines.getBytes(),"utf-8");
			sb.append(lines);
		}
        System.out.println(sb.toString());
        //http://blog.csdn.net/u011008029/article/details/51315177
        //http://www.cnblogs.com/wangchuanfu/p/6116645.html
        //https://my.oschina.net/huangsm/blog/31994
        JSONObject json = JSONObject.fromObject(sb.toString());  
        System.out.println("获取的值"+json.get("token"));
        
//        String result ="";
//        while ((lines = reader.readLine()) != null) {    
//            result += "/n" + lines;    
//        }  
//        System.out.println(result);  
        
        
        reader.close();
        
//      OutputStreamWriter streamWriter = new OutputStreamWriter(connection.getOutputStream());
//      SessionDomain sessionDomain = new SessionDomain();
//      sessionDomain.setAppCode("AM");
//      sessionDomain.setMemberId("1733999000");
//      sessionDomain.setToken("fsfsoosf&%$$#@");
//      connection.connect();        
//        int code = connection.getResponseCode();
//        streamWriter.write(sessionDomain.toString());
//        streamWriter.flush();
//        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println(connection.getResponseCode());
//        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
//            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
//            BufferedReader bufferedReader = new BufferedReader(streamReader);
//            String response = null;
//            while ((response = bufferedReader.readLine()) != null) {
//                stringBuilder.append(response + "\n");
//            }
//            bufferedReader.close();
//
//            System.out.println("test" + stringBuilder.toString());
////            return stringBuilder.toString();
//        } else {
//            System.out.println("test" + connection.getResponseMessage());
////            return null;
//        }
//    } catch (Exception exception){
//            exception.printStackTrace();
//    } finally {
//        if (connection != null){
//            connection.disconnect();
//        }
//    }
//}

    } catch (Exception exception){
      exception.printStackTrace();
} finally {
  if (connection != null){
      connection.disconnect();
  }
}
	
}
}


        