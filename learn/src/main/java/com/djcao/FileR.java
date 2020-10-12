package com.djcao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.djcao.zk.FixData;
import com.google.common.collect.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/8/29
 */
public class FileR {
    public static void main(String[] args) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        File file = new File("H:\\Download\\20200921_LS_2.csv");
        BufferedReader bufferedReader = new BufferedReader(
            new FileReader(file));
        List<String> strings = new ArrayList<>();
        bufferedReader.lines().forEach(strings::add);
        System.out.println(strings.size());
        List<List<String>> partition = Lists.partition(strings, 100);
        for (int i = 0; i < partition.size(); i++) {
            List<String> strings1 = partition.get(i);
            com.djcao.FixData  fixData = new com.djcao.FixData ();
            fixData.setBillCodes(strings1);
            ResponseEntity<String> stringResponseEntity = restTemplate
                .postForEntity("http://10.8.28.26:45380/express-order/restful/fixRecData/fix",
                    fixData,
                    String.class);
            System.out.println(stringResponseEntity.getBody());

        }

    }


}
