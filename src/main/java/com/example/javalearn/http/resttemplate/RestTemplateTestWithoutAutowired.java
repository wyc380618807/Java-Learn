package com.example.javalearn.http.resttemplate;

import org.junit.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author: wangyucheng19
 * @date: 2022/8/10
 * @description:
 **/
public class RestTemplateTestWithoutAutowired {
    @Test
    public void test() {
//        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
        String forObject = restTemplate.getForObject("http://www.baiduxxssx.com", String.class);

    }
}
