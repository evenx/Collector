package com.fountontec.collector.client;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import com.fountontec.collector.common.Common;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Request;
import com.ning.http.client.Response;

public class PDHttpClient {
	
	
	private static AsyncHttpClientConfig.Builder builder;
	private static AsyncHttpClient client;
	static{
		builder = new AsyncHttpClientConfig.Builder();
		builder.setMaximumConnectionsTotal(100000);
		builder.setAllowPoolingConnection(true);
		builder.setCompressionEnabled(true);
		builder.setUserAgent(Common.USER_AGENT);
		builder.setConnectionTimeoutInMs(300);
		builder.setExecutorService(Executors.newCachedThreadPool());
		client = new AsyncHttpClient(builder.build());
	}
	
	private PDHttpClient(){}
	private volatile static PDHttpClient singleton;
	
	public static PDHttpClient getInstance(){
		if(singleton == null){
			synchronized (PDHttpClient.class) {
				if(singleton == null){
					singleton = new PDHttpClient();
				}
			}
		}
		return singleton;
	}
	
	/**
	 * @param content
	 * @return success 200, failure -1
	 */
	public int post(String content, String url){
		
		int status = -1;
		Request request = client.preparePost(url)
	            .setHeader("Content-Type","text/plain")
	            .setHeader("Content-Length", ""+content.length())
	            .setHeader(Common.ADDRESS_WEXIN, Common.ADDRESS_WEXIN)
	            .setBodyEncoding(Common.DEFAULT_CHARSET)
	            .setBody(content)
	            .build();
		
		   ListenableFuture<Integer> f= null;
		    try {
		        f = client.executeRequest(request,
		                new AsyncCompletionHandler<Integer>(){
		                    @Override
		                    public Integer onCompleted(Response response) throws Exception{
		                        return response.getStatusCode();
		                    }
		                });
		        status = f.get();
		    } catch (IOException ex) {
		    	ex.printStackTrace();
		    } catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		    content = null;
		return status;
	}
	
	public void close(){
		client.close();
	}
	
}
