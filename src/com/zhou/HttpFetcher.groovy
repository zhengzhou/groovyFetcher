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
    void fetcher(){
        def id;
        def title;
        def url;
        Jsoup.connect(htmlData.host+htmlData.path).get().select(htmlData.selectPath).each {
            def content = it.text()
            if(content.contains("经营权"))
                println it.text()
        }
    }
}
