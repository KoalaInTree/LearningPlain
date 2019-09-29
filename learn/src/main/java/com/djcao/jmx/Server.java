package com.djcao.jmx;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/9/21
 */
public class Server implements ServerMBean {
    @Override
    public String getNowDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
