package test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fountontec.collector.client.PDHttpClient;
import com.fountontec.collector.common.Common;
import com.fountontec.collector.common.RandomGUID;

public class Test {

	public static void main(String[] args) {
		
		
		     PDHttpClient client = PDHttpClient.getInstance();
        	 URL url =  Test.class.getClassLoader().getResource("message/");
        	 Collection<File> files =  FileUtils.listFiles(new File(url.getFile()), new String[]{"json"}, false);
        	 
        	 String random = new RandomGUID().valueAfterMD5;
        	 for(File file: files){
        		 try {
        			 String con = FileUtils.readFileToString(file, Common.DEFAULT_CHARSET);
        			 
        			 JSONObject ob = JSON.parseObject(con);
        			 ob.put("ToUserName", random);
        			 System.out.println(ob);
					 int st = client.post(ob.toJSONString(), "http://10.200.33.130:20056/");
					 System.out.println(st);
					 con = null;
					 ob = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
        		 
        	 }
        	 client.close();
         
	}
}
