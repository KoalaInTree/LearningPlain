package com.dj.web.fix;

import com.djcao.util.FileUtils;
import com.djcao.util.IFileFormat;
import com.google.common.collect.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class InvalidSeal {
    static RestTemplate restTemplate = new RestTemplate();
    static String url = "http://10.8.81.226:8080/wyvern-waybill/seal/invalidSeals";
    static String testurl = "http://10.30.10.60:8080/wyvern-waybill/seal/invalidSeals";
    public static void main(String[] args) throws IOException {
        List<String> strings = FileUtils.unqFile("C:\\Users\\bg389966\\Desktop\\test.csv", line -> line.replace("\"",""));
        List<List<String>> partition = Lists.partition(strings, 50);
        for (List<String> item : partition) {
            postWyvernWaybill(item);
        }
    }

    private static void postWyvernWaybill(List<String> item) {
        ResponseEntity<Boolean> booleanResponseEntity = restTemplate.postForEntity(testurl, item, Boolean.class);
        System.out.println(booleanResponseEntity.getBody());
    }
}


