package com.dj.web.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/8/10
 */
@ConfigurationProperties(prefix = "best")
@Configuration
public class BestConfig {
    private List<String> rd;
    private Map<String,String> maps;
    private Map<String, List<String>> varMapList;

    public List<String> getRd() {
        return rd;
    }

    public void setRd(List<String> rd) {
        this.rd = rd;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Map<String, List<String>> getVarMapList() {
        return varMapList;
    }

    public void setVarMapList(Map<String, List<String>> varMapList) {
        this.varMapList = varMapList;
    }

    @Override
    public String toString() {
        return "BestConfig{" +
            "rd=" + rd +
            ", maps=" + maps +
            ", varMapList=" + varMapList +
            '}';
    }
}
