package com.zhou

/**
 * Created by zhou on 2014/12/11 0011.
 */
class ResultData {
    //结果数据。
    def city
    def time
    def title
    def href


    @Override
    public String toString() {
        return "ResultData{" +
                "city=" + city +
                ", time=" + time +
                ", title=" + title +
                ", href=" + href +
                '}';
    }
}
