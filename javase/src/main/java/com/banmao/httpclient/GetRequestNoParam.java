package com.banmao.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description: 无参数的GET请求
 * @author: banmao
 * @date: 2022/10/20 10:04
 */
public class GetRequestNoParam {

    /**
     * get请求
     * @param uri 请求地址
     * @return
     */
    private CloseableHttpResponse execGetNoParam(String uri) {
        System.out.println("============无参数的GET请求，请求url为" + uri + "============");
        // 获得一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 生成一个get请求
        HttpGet httpGet = new HttpGet(uri);
        // 执行并获得结果
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
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
        GetRequestNoParam getRequestNoParam = new GetRequestNoParam();
        String uri = "http://124.42.42.233:7001/auth/auth/getToken/cdjqGetData/12345678";
        getRequestNoParam.execGetNoParam(uri);
    }
}
