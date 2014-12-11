package com.zhou

import java.text.SimpleDateFormat

import static java.util.Calendar.getInstance as now

/**
 * Created by zhou on 2014/12/11 0011.
 * xml 格式：<announcement time='2014-11-12'>
 *              <city></city>
 *              <title></title>
 *              <url></url>
 *          </announcement>
 */
class XmlBuilder {

    def fileName;

    XmlBuilder() {
        def df = new SimpleDateFormat("yyyy-MM")
        fileName = df.format(now().time) + '.xml'
    }

    //返回这个月的所有数据。
    def read() {
        //check is extends.if true read the xml
        def resultItems = [];
        if (new File(fileName).exists()) {
            def xml = new XmlParser().parse(fileName)
            xml.announcements.each {
                def result = new ResultData()
                result.city = it.city.text()
                result.title = it.title.text()
                result.href = it.url.text()
                result.time = it.attribute('time')
                resultItems << result
            }
        } else {
            return null;
        }
    }

    void createXml() {
        //create xml file.
        def writer = new FileWriter(fileName)
        def xml = new groovy.xml.MarkupBuilder(writer)
        xml.announcements(time: "current") {
            city("Java")
            title("Groovy")
            url("JavaScript")
        }
    }

    void writeXMl() {

    }
}
