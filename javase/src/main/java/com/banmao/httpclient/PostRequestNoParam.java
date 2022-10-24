package com.banmao.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description: 无参数的POST请求
 * @author: banmao
 * @date: 2022/10/20 10:04
 */
public class PostRequestNoParam {

    /**
     * POST请求
     * @param uri 请求地址
     * @return
     */
    private CloseableHttpResponse execPostNoParam(String uri) {
        System.out.println("============无参数的POST请求，请求url为" + uri + "============");
        // 获得一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 生成一个HTTP POST请求
        HttpPost httpPost = new HttpPost(uri);
        //伪装浏览器请求
        // httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
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
        PostRequestNoParam postRequestNoParam = new PostRequestNoParam();
        String uri = "http://www.oschina.net/";
        postRequestNoParam.execPostNoParam(uri);
    }
}
