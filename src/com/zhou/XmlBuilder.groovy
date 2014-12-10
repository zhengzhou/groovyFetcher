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
    void read() {
        //check is extends.if true read the xml
        if (new File(fileName).exists()) {

        } else {

        }
    }

    void createXml(){
        //create xml file.
        def writer = new FileWriter(fileName)
        def xml = new groovy.xml.MarkupBuilder(writer)
        xml.announcements(time:"current"){
            city(flavor:"static", version:"1.5", "Java")
            title(flavor:"dynamic", version:"1.6.0", "Groovy")
            url(flavor:"dynamic", version:"1.9", "JavaScript")
        }
    }

    void writeXMl(){

    }
}
