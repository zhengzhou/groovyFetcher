package com.zhou

import com.googlecode.groovyhttp.Http
import groovyx.net.http.EncoderRegistry
import groovyx.net.http.HTTPBuilder

/**
 * Created by zhou on 2014/11/25 0025.
 */
import org.jsoup.Jsoup

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.Method.POST

class HttpPoster {

    HtmlData htmlData;

    void post(){
        println 'posting...'
        def http = new HTTPBuilder(htmlData.host)
        http.encoderRegistry = new EncoderRegistry(charset:'utf-8')
        http.handler.success = { resp ,html ->
            println '请求成功'
            parseHtml(formatHtml(html))
        }

        http.handler.failure = { resp ->
            println "Unexpected failure: ${resp.statusLine}"
        }

//        form submit use requestContentType: URLENC !!
//        http.post( path: htmlData.path, body: htmlData.body,
//                requestContentType: URLENC ) { resp,html ->
//            println "POST Success: ${resp.statusLine}"
//           // println html
//            parseHtml(html)
//        }

        def result =  http.request(POST,URLENC){
            uri.path = htmlData.path
            headers : [Accept : 'text/html; charset=utf-8']
            body = htmlData.body
        }

        print result
    }

    void parseHtml(html){
        Jsoup.parse(html).body().select(htmlData.selectPath).each {
            printf it.text
        }
    }

    String formatHtml(html){
        def result = html =~ /<html>.*<\/html>/
        print result[0]
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

    void testGet() {
        def host = 'http://api.mgyapp.com'
        def http = new HTTPBuilder(host)
        def json = http.get(path: '/v2/gift/list', contentType: JSON, query: [pageno: 1, pagesize: 20, packagename: ''])
        println(json)

        http = new HTTPBuilder('http://www.yayu.org')
        def html = http.get( path : '/book/gnu_make/index.html')
        print html
    }

    void testGroovyHttp(){
        //with constructor
        new Http().get("http://www.qjvpn.net/user/checklogin.php")
                .getForm('loginForm')
                .submit(username:'huahuasa',password:'huahuasa',from:'')
                .get("http://www.qjvpn.net/user/center.php")
                .text
    }
}
