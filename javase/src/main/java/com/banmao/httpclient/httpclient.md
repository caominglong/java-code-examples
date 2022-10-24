### httpclient
操作步骤：

1、不变的步骤：创建HttpClient对象
```
CloseableHttpClient httpClient = HttpClients.createDefault();
```

2、变化的步骤：创建不同的请求对象。比如HttpGet、HttpPost、HttpPut等
```
HttpPost httpPost = new HttpPost(uri);
HttpGet httpGet = new HttpGet(uriBuilded);
```
3、变化的步骤（可省略）设置请求的头部
```
httpPost.addHeader(entry.getKey(), entry.getValue());
httpGet.addHeader(entry.getKey(), entry.getValue());
```
4、变化的步骤（可省略）设置请求的参数
```
# post设置方式，form表单方式，或json等其他格式
StringEntity stringEntity = new StringEntity(paramObj.toString(), "UTF-8");
httpPost.setEntity(stringEntity);
# get设置方式
new URIBuilder(uri).setParameter(entry.getKey(), entry.getValue());
# 重点说明
public StringEntity(final String string, final String charset){...}
这是StringEntity方法签名，其实要传递的参数只是一个String类型的字符串而已，
由此说明，http支撑的是，无论你提供什么格式的参数。json也好，其他格式也好。
http负责的是帮你把数据带过去。只要你服务端能支撑此种格式解析即可。

```
5、不变的步骤，执行请求，得到响应体
```
CloseableHttpResponse response = httpClient.execute(httpGet);
```