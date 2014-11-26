package com.zhou

import groovyx.net.http.EncoderRegistry

/**
 * Created by zhou on 2014/11/25 0025.
 */

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import com.googlecode.groovyhttp.*

class HttpPoster {

    HtmlData htmlData;

    void post(){
        //String host = 'http://changd.ccgp-hunan.gov.cn'//'http://'+ htmlData.host
        //host = 'http://www.qjvpn.net'
        println htmlData
        def http = new HTTPBuilder(htmlData.host)
        http.encoderRegistry = new EncoderRegistry( charset:'utf-8' )

        http.handler.success = { println "Success!" }

        http.handler.failure = { resp ->
            println "Unexpected failure: ${resp.statusLine}"
        }

        http.post( path: htmlData.path, body: htmlData.body,
                requestContentType: HTML ) { resp ->
            println "POST Success: ${resp.statusLine}"
            assert resp.statusLine.statusCode == 201
        }
    }

    void testPost() {
        def host = 'http://api.mgyapp.com';
        def http = new HTTPBuilder(host)
        def json = http.get(path: '/v2/gift/list', contentType: JSON, query: [pageno: 1, pagesize: 20, packagename: ''])
        println(json)
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
