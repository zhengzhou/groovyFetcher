package com.zhou

import groovyx.net.http.EncoderRegistry
import groovyx.net.http.HTTPBuilder
import org.jsoup.Jsoup

import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.Method.POST

/**
 * Created by zhou on 2014/11/25 0025.
 */
class HttpPoster {

    HtmlData htmlData;

    void post(){
        println 'posting...'
        def http = new HTTPBuilder(htmlData.host)
        http.encoderRegistry = new EncoderRegistry(charset:'gbk')

        http.handler.success = { resp ,reader ->
            println '请求成功'
            println reader.getClass().getName()
           // html = new String(html.getBytes("US-ASCII"),"gbk");
            print reader
            parseHtml(formatHtml(reader))
        }

        http.handler.failure = { resp ->
            println "Unexpected failure: ${resp.statusLine}"
        }
        http.contentType = URLENC
        http.request(POST){
            uri.path = htmlData.path
            headers.Accept = 'text/html'
            body = htmlData.body
        }

    }

    void parseHtml(html){
        Jsoup.parse(html).body().select(htmlData.selectPath).each {
            println it.text
        }
    }

    String formatHtml(html){
        def result = html =~ /<html>[\s\S]{0,}/
        return result[0]
        /*new HTTPBuilder('http://tool.oschina.net').request(POST,JSON){
            uri.path = '/action/format/html'
            body = [html:html,fhtml:'']
            response.success = { resp, json ->
                // parse the JSON response object:
                println "format result ${json}"
            }
        }*/
    }

}
