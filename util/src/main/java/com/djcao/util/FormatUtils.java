package com.djcao.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/15
 */
public class FormatUtils {
    // 多单号in
    public static Set<String> formatEach(Collection<String> items, String format,int inSize) {
        List<List<String>> partition = Lists.partition(new ArrayList<>(items), inSize);
        Set<String> rst = new HashSet<>();
        for (List<String> x : partition) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("('");
            String join = StringUtils.join(x, "','");
            stringBuilder.append(join);
            stringBuilder.append("')");
            rst.add(String.format(format, stringBuilder.toString()));
        }
        return rst;
    }

    public static void main(String[] args) throws IOException {
        Set<String> strings = FileUtils.unqFile("C:\\\\Users\\\\bg389966\\\\Desktop\\\\ddd.txt");
        Set<String> strings1 = formatEach(strings, "select bill_code,created_time from "
            + "ge_balance_detail where bill_code in %s"
            + "and balance_date > sysdate - 0.5", 999);

    }
}
