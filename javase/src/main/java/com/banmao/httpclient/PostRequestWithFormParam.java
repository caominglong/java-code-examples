package com.banmao.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description:
 * 表单参数的POST请求
 * 关键词：UrlEncodedFormEntity
 * @author: banmao
 * @date: 2022/10/20 10:04
 */
public class PostRequestWithFormParam {

    /**
     * POST请求
     * @param uri 请求地址
     * @param paramMap 请求参数对象，采用json格式
     * @param headerMap 设置响应的请求头参数
     * @return
     */
    private CloseableHttpResponse execPostWithParam(String uri, Map<String, String> paramMap, Map<String, String> headerMap) {
        System.out.println("============带参数的POST请求，请求url为" + uri + "============");
        System.out.println("============带参数的POST请求，表单参数为" + JSON.toJSONString(paramMap) + "============");
        System.out.println("============带参数的POST请求，header参数为" + JSON.toJSONString(headerMap) + "============");
        // 获得一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 生成一个HTTP POST请求
        HttpPost httpPost = new HttpPost(uri);
        // 关键1：设置Content-type
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");

        // 设置请求的头部参数，一般来说是token等信息
        for(Map.Entry<String, String> entry: headerMap.entrySet()) {
            httpPost.setHeader(entry.getKey(), entry.getValue());
        }

        // 关键2：设置请求参数，paramMap
        // 使用 UrlEncodedFormEntity 来设置 body，消息体内容类似于“KEY1=VALUE1&KEY2=VALUE2&...”这种形式，
        // 服务端接收以后也要依据这种协议形式做处理。
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        for(Map.Entry<String, String> entry: paramMap.entrySet()) {
            parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        try {
            // 构造一个form表单式的实体
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
            httpPost.setEntity(formEntity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 执行并获得结果
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            // 打印结果
            printResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    private void printResponse(CloseableHttpResponse response) {
        // 判断返回状态是否为200
        if (response.getStatusLine().getStatusCode() == 200) {
            //请求体内容
            try {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("执行结果为：" + content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PostRequestWithFormParam postRequestNoParam = new PostRequestWithFormParam();
        String uri = "http://www.oschina.net/";
        Map<String, String> paramMap = new HashMap<>(1);
        Map<String, String> headerMap = new HashMap<>(1);
        postRequestNoParam.execPostWithParam(uri, paramMap, headerMap);
    }
}
