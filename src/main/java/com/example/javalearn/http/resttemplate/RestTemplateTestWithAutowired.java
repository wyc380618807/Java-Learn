package com.example.javalearn.http.resttemplate;

import com.example.javalearn.BaseTest;
import com.example.javalearn.JavalearnApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author: wangyucheng19
 * @date: 2022/8/10
 * @description:
 **/

public class RestTemplateTestWithAutowired extends BaseTest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() {
        String rootUrl = "http://www.baidu.com";
        String result="";
        String forObject = restTemplate.getForObject(rootUrl, String.class);

        //2. 简单带路径变量参数Get请求
        result = restTemplate.getForObject(rootUrl + "get2/{1}", String.class, 239);
        System.out.println("简单带路径变量参数Get请求:" + result);

        //3. 返回对象Get请求（注意需包含compile group: 'com.google.code.gson', name: 'gson', version: '2.8.5'）
        ResponseEntity<TestObject> responseEntity = restTemplate.getForEntity(rootUrl + "get3/339", TestObject.class);
        System.out.println("返回:" + responseEntity);
        System.out.println("返回对象Get请求:" + responseEntity.getBody());

        //4. 设置header的Get请求
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", "123");
        ResponseEntity<String> response = restTemplate.exchange(rootUrl + "get4", HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        System.out.println("设置header的Get请求:" + response.getBody());

        //5. Post对象
        TestObject testObject = new TestObject();
        testObject.setName("buter");
        testObject.setSex("1");
        result = restTemplate.postForObject(rootUrl + "post1", testObject, String.class);
        System.out.println("Post对象:" + result);

        //6. 带header的Post数据请求
        response = restTemplate.postForEntity(rootUrl + "post2", new HttpEntity<TestObject>(testObject, headers), String.class);
        System.out.println("带header的Post数据请求:" + response.getBody());

        //7. 带header的Put数据请求
        //无返回值
        restTemplate.put(rootUrl + "put1", new HttpEntity<TestObject>(testObject, headers));
        //带返回值
        response = restTemplate.exchange(rootUrl + "put1", HttpMethod.PUT, new HttpEntity<TestObject>(testObject, headers), String.class);
        System.out.println("带header的Put数据请求:" + response.getBody());

        //8. del请求
        //无返回值
        restTemplate.delete(rootUrl + "del1/{1}", 332);
        //带返回值
        response = restTemplate.exchange(rootUrl + "del1/332", HttpMethod.DELETE, null, String.class);
        System.out.println("del数据请求:" + response.getBody());
        
        System.out.println(forObject);

    }

}
