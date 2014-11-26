package com.zhou

class FetcherConfig {

	def keyWord = ''
	def startDate = '2014-01-01'

	def dataMap = [
			'changs.ccgp-hunan.gov.cn': '',
			'zhuz.ccgp-hunan.gov.cn'  : '',
			'xiangt.ccgp-hunan.gov.cn': '',
			'yuey.ccgp-hunan.gov.cn'  : '',
			'yiy.ccgp-hunan.gov.cn'   : '',
			'changd.ccgp-hunan.gov.cn': '/search.cfm',
			'zjj.ccgp-hunan.gov.cn'   : '',
			'xxz.ccgp-hunan.gov.cn'   : '',
			'huaih.ccgp-hunan.gov.cn' : '',
			'shaoy.ccgp-hunan.gov.cn' : '',
			'loud.ccgp-hunan.gov.cn'  : '',
			'hengy.ccgp-hunan.gov.cn' : '',
			'chenz.ccgp-hunan.gov.cn' : ''
	]

	def cityMap = []


	void init() {

		//常德站点表单
		def changd = new HtmlData([host: 'http://changd.ccgp-hunan.gov.cn', path: '/search.cfm'])

			changd.body = [key       : '%E7%BB%8F%E8%90%A5%E6%9D%83',
						   'Submit.x': '25',
						   'Submit.y': 9,
						   type      : 'all',
						   dq        : '%E6%B9%96%E5%8D%97%E7%9C%81%E5%B8%B8%E5%BE%B7%E5%B8%82',
						   dl        : 'search',
						   submit    : 'search'
			]
		cityMap<<changd
	}
}

class HtmlData {

	def host
	def path
	def selectPath
	def body


	@Override
	public String toString() {
		return "HtmlData{" +
				"host=" + host +
				", path=" + path +
				", selectPath=" + selectPath +
				'}';
	}
}