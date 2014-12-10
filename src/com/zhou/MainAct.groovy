/**
 * Created by zhou on 2014/11/19 0019.
 */

package com.zhou


//@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.2' )
def  config = new FetcherConfig()
config.init()


def resultAll = [];
config.cityMap.forEach{htmlData ->
	//new HttpPoster([htmlData:htmlData]).post()
	def resultItems //= new HttpFetcher([htmlData:htmlData]).fetcher()
//	if(!resultItems?.isEmpty())
//		resultAll.addAll(resultItems)
}

if(!resultAll.isEmpty()){
	for(ResultData item:resultAll){
		println "find: $item"
	}
}



