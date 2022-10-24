package com.banmao.httpclient;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description: 带参数的GET请求
 * @author: banmao
 * @date: 2022/10/20 10:04
 */
public class GetRequestWithParam {

    /**
     * get请求
     * @param uri 请求地址
     * @return
     */
    private CloseableHttpResponse execGetWithParam(String uri, Map<String, String> paramMap) {
        System.out.println("============带参数的GET请求，请求uri为" + uri + "============");
        System.out.println("============带参数的GET请求，请求参数为" + JSON.toJSONString(paramMap) + "============");
        // 获得一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        // 定义请求的参数
        if (paramMap != null) {
            URIBuilder uriBuilder = null;
            URI uriBuilded = null;
            try {
                uriBuilder = new URIBuilder(uri);
                for(Map.Entry<String, String> entry: paramMap.entrySet()) {
                    uriBuilder.setParameter(entry.getKey(), entry.getValue());
                }
                uriBuilded = uriBuilder.build();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            if (uriBuilded != null) {
                // 生成一个get请求
                HttpGet httpGet = new HttpGet(uriBuilded);
                // 执行并获得结果
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
        GetRequestWithParam getRequestWithParam = new GetRequestWithParam();
        String uri = "http://124.42.42.233:7001/archives.manager/wuhuBigScreen/meterReadingByMonth";
        Map<String, String> paramMap = new HashMap<>(1);
        paramMap.put("month", "10");
        getRequestWithParam.execGetWithParam(uri, paramMap);
    }
}
