package com.banmao.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description: 带参数与特定header参数的POST请求
 * @author: banmao
 * @date: 2022/10/20 10:04
 */
public class PostRequestWithParamAndHeader {

    /**
     * POST请求
     * @param uri 请求地址
     * @param paramObj 请求参数对象，采用json格式
     * @return
     */
    private CloseableHttpResponse execPostWithParam(String uri, JSONObject paramObj, Map<String, String> headerMap) {
        System.out.println("============带参数的POST请求，请求url为" + uri + "============");
        System.out.println("============带参数的GET请求，路径参数为" + JSON.toJSONString(paramObj) + "============");
        System.out.println("============带参数的GET请求，header参数为" + JSON.toJSONString(headerMap) + "============");
        // 获得一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 生成一个HTTP POST请求
        HttpPost httpPost = new HttpPost(uri);
        // 关键1：设置Content-type
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");

        // 设置请求的头部参数，一般来说是token等信息
        for(Map.Entry<String, String> entry: headerMap.entrySet()) {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }

        // 关键2：设置请求参数，paramObj为json格式的参数
        StringEntity stringEntity = new StringEntity(paramObj.toString(), "UTF-8");
        stringEntity.setContentEncoding("UTF-8");

        httpPost.setEntity(stringEntity);

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
        PostRequestWithParamAndHeader postRequestNoParam = new PostRequestWithParamAndHeader();
        String uri = "http://www.oschina.net/";
        JSONObject paramObj = postRequestNoParam.buildQueryGisObjectsParam();
        Map<String, String> headerMap = new HashMap<>(1);
        postRequestNoParam.execPostWithParam(uri, paramObj, headerMap);
    }

    private JSONObject buildQueryGisObjectsParam() {
        JSONObject paramObj = new JSONObject();
        paramObj.put("schema", "spatial");
        JSONObject paramInnerObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("SP_WATERMETER");
        paramInnerObj.put("fcNames", jsonArray);
        // fieldsOnly=false，将返回转换后的经纬度
        paramInnerObj.put("fieldsOnly", false);
        // queryType=NORMAL，代表不分页
        paramInnerObj.put("queryType", "NORMAL");
        paramInnerObj.put("geometry", null);
        JSONArray returnFields = new JSONArray();
        returnFields.add("id");
        paramInnerObj.put("returnFields", returnFields);
        paramInnerObj.put("whereStr", " id = '00041bd2-6121-4cef-8579-fdc1bb92b015'");
        JSONObject paramInnerInnerObj = new JSONObject();
        paramInnerInnerObj.put("source", "EPSG:4549");
        paramInnerInnerObj.put("target", "EPSG:4326");
        paramInnerInnerObj.put("srid", "4549");
        paramInnerInnerObj.put("transform", true);
        paramInnerObj.put("transformParams", paramInnerInnerObj);
        paramObj.put("params", paramInnerObj);
        return paramObj;
    }
}
