/**
 * Created by zhou on 2014/11/19 0019.
 */

package com.zhou

def  config = new FetcherConfig()
config.init()

config.cityMap.forEach{htmlData ->
	new HttpPoster([htmlData:htmlData]).post()
}