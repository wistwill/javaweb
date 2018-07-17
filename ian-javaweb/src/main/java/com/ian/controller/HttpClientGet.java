package com.ian.controller;

import com.ian.model.MagicValue;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @className: HttpClientGet
 * @description: HttpClientGet封装
 * @author: Ian
 * @create: 2018-07-04 13:58
 **/
public class HttpClientGet {

	public String httpGet(String url, Map<String, String> map) throws URISyntaxException, IOException {

		//创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();

		//创建URIBuilder
		URIBuilder uri = new URIBuilder( url );

		//设置参数
		for (Map.Entry<String, String> entry : map.entrySet()) {
			uri.addParameter( entry.getKey(), entry.getValue() );
		}

		//创建httpGet对象
		HttpGet hg = new HttpGet( uri.build() );

		//设置请求的报文头部的编码
		hg.setHeader( new BasicHeader( "Content-Type", "application/x-www-form-urlencoded; charset=utf-8" ) );

		//设置期望服务端返回的编码
		hg.setHeader( new BasicHeader( "Accept", "text/plain;charset=utf-8" ) );

		//请求服务
		CloseableHttpResponse response = client.execute( hg );

		//获取响应码
		int statusCode = response.getStatusLine().getStatusCode();

		if (statusCode == MagicValue.SUCCESS) {

			//获取返回实例entity
			HttpEntity entity = response.getEntity();

			//通过EntityUtils的一个工具方法获取返回内容
			String resStr = EntityUtils.toString( entity, "utf-8" );

			//输出
			System.out.println( "请求成功,请求返回内容为: " + resStr );

			//关闭response和client
			response.close();
			client.close();

			return resStr;
		} else {
			//输出
			System.out.println( "请求失败,错误码为: " + statusCode );
			return String.valueOf( statusCode );
		}
	}
}