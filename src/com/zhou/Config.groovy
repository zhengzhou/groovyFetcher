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
		def changd = new HtmlData([host: 'http://changd.ccgp-hunan.gov.cn', path: '/more.cfm?sid=100002001'])
		//body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1)
			changd.selectPath = 'body > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr > td > table:nth-child(1) > tbody > tr'
			changd.body = [key       : '经营权',
						   'Submit.x': '25',
						   'Submit.y': 9,
						   type      : 'all',
						   dq        : '湖南省常德市',
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