package com.djcao;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class FixData {
   private String startDate;

   private String endDate;

   private List<String> billCodes;

   private Boolean test;

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public List<String> getBillCodes() {
        return billCodes;
    }

    public void setBillCodes(List<String> billCodes) {
        this.billCodes = billCodes;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}