package com.zhou

import org.jsoup.Jsoup

/**
 * Created by zhou on 2014/12/2 0002.
 */
class HttpFetcher {

    HtmlData htmlData;


    /**
     * 抓取网页
     */
    List<ResultData> fetcher(){
        def resultItems = [];
        Jsoup.connect(htmlData.host+htmlData.path).get().select(htmlData.selectPath).each {
           // println it.text()
            //if(it.text().contains("经营权")) {

                def link = it.select("a[href]").first()
                def linkHref = link.attr("href");
                def linkText = link.text();
                def linkTime = it.select('td').last()?.text()
                if(linkTime == null)
                    linkTime = it.select('span').last()?.text()
//                println "find: $time ,$linkText, $linkHref"
                resultItems << new ResultData([city:htmlData.title,title:linkText,time:linkTime,href:htmlData.host+'/'+linkHref])
//            }
        }
        return resultItems
    }
}

