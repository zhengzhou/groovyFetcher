package com.zhou

/**
 * Created by zhou on 2014/11/25 0025.
 */
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1' )

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

class HttpPoster {

    HtmlData htmlData;

    void post(){
        String host = 'http://changd.ccgp-hunan.gov.cn'//'http://'+ htmlData.host
        host = 'http://www.qjvpn.net'
        def http = new HTTPBuilder(host)
        http.post( path: htmlData.path, body: htmlData.body,
                requestContentType: ANY ) { resp ->
            println "POST Success: ${resp.statusLine}"
            assert resp.statusLine.statusCode == 201
        }
    }
}
