package com.djcao.jmx;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author djcao
 * @date 2019/12/19 10:59 
 */
public class Server implements ServerMBean {
    @Override
    public String getNowDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
