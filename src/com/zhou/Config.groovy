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
		changd.selectPath = 'body > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td:nth-child(2) > table:nth-child(1) > tbody > tr:nth-child(2) > td:nth-child(2) > table:nth-child(1) > tbody > tr'
		{changd.body = [key       : '经营权',
						   'Submit.x': '25',
						   'Submit.y': 9,
						   type      : 'all',
						   dq        : '湖南省常德市',
						   dl        : 'search',
						   submit    : 'search'
		]}
		def changd1 =  new HtmlData([host: 'http://changd.ccgp-hunan.gov.cn', path: '/more.cfm?sid=100002002'])
		changd1.selectPath = changd.selectPath;
		cityMap<<changd
		cityMap<<changd1
		def zhuz = new HtmlData([host:'http://zhuz.ccgp-hunan.gov.cn',path: ''])
		def xiangt = new HtmlData([host:'http://xiangt.ccgp-hunan.gov.cn',path: ''])
		def yuey = new HtmlData([host:'http://yuey.ccgp-hunan.gov.cn',path: ''])
		def yiy = new HtmlData([host:'http://yiy.ccgp-hunan.gov.cn',path: ''])
		def zjj = new HtmlData([host:'http://zjj.ccgp-hunan.gov.cn',path: ''])
		def xxz = new HtmlData([host:'http://xxz.ccgp-hunan.gov.cn',path: ''])
		def huaih = new HtmlData([host:'http://huaih.ccgp-hunan.gov.cn',path: ''])
		def shaoy = new HtmlData([host:'http://shaoy.ccgp-hunan.gov.cn',path: ''])
		def loud = new HtmlData([host:'http://loud.ccgp-hunan.gov.cn',path: ''])
		def hengy = new HtmlData([host:'http://hengy.ccgp-hunan.gov.cn',path: ''])
		def chenz = new HtmlData([host:'http://chenz.ccgp-hunan.gov.cn',path: ''])
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