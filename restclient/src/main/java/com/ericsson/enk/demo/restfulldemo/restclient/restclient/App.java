package com.ericsson.enk.demo.restfulldemo.restclient.restclient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final String uri = "http://localhost:8080/restfulldemo/countries";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        
        System.out.println(result);
        
        final String uri2 = "http://localhost:8080/restfulldemo/country/{id}";
        restTemplate.setMessageConverters(getMessageConverters());
        
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        
        ResponseEntity<CountryClient> response = restTemplate.exchange(uri2, HttpMethod.GET, entity, CountryClient.class, "1");
        CountryClient c = response.getBody();
        System.out.println(c.toString());
    }
    
    private static List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }
}
