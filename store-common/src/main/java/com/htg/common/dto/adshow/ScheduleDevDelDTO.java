package com.htg.common.dto.adshow;
import java.util.List;

public class ScheduleDevDelDTO {
    private String sn;
    private List<Integer> scheduleIdList;


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<Integer> getScheduleIdList() {
        return scheduleIdList;
    }

    public void setScheduleIdList(List<Integer> scheduleIdList) {
        this.scheduleIdList = scheduleIdList;
    }

    @Override
    public String toString() {
        return "ScheduleDevDelDTO{" +
                "sn='" + sn + '\'' +
                ", scheduleIdList=" + scheduleIdList +
                '}';
    }
}
