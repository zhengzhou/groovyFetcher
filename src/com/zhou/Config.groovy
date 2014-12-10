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
		/*changd.body = [key       : '经营权',
                       'Submit.x': '25',
                       'Submit.y': 9,
                       type      : 'all',
                       dq        : '湖南省常德市',
                       dl        : 'search',
                       submit    : 'search'
    ]*/

		//长沙
		def changs = new HtmlData([host: 'http://changs.ccgp-hunan.gov.cn', path: '/noticeAction!showSub_gonggaolist.action?query.gglx=2'])
		changs.selectPath = 'body > div:nth-child(7) > div > div.r.sub_right > div.sub_list > div.sub_list_content > ul > li'
		cityMap << changs
		changs = new HtmlData([host: 'http://changs.ccgp-hunan.gov.cn', path: '/noticeAction!showSub_gonggaolist.action?query.gglx=3'])
		changs.selectPath = 'body > div:nth-child(7) > div > div.r.sub_right > div.sub_list > div.sub_list_content > ul > li'
		cityMap << changs
		//有些站点是用一样的技术。
		def commonPath = 'body > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td:nth-child(2) > table:nth-child(1) > tbody > tr:nth-child(2) > td:nth-child(2) > table:nth-child(1) > tbody > tr';
		//常德站点表单
		cityMap << new HtmlData([host: 'http://changd.ccgp-hunan.gov.cn', path: '/more.cfm?sid=100002001', selectPath: commonPath])
		cityMap <<  new HtmlData([host: 'http://changd.ccgp-hunan.gov.cn', path: '/more.cfm?sid=100002002', selectPath: commonPath])

		def zhuz = new HtmlData([host: 'http://zhuz.ccgp-hunan.gov.cn', path: ''])
		def xiangt = new HtmlData([host: 'http://xiangt.ccgp-hunan.gov.cn', path: ''])
		def yuey = new HtmlData([host: 'http://yuey.ccgp-hunan.gov.cn', path: ''])
		def yiy = new HtmlData([host: 'http://yiy.ccgp-hunan.gov.cn', path: ''])
		def zjj = new HtmlData([host: 'http://zjj.ccgp-hunan.gov.cn', path: ''])
		def xxz = new HtmlData([host: 'http://xxz.ccgp-hunan.gov.cn', path: ''])
		def huaih = new HtmlData([host: 'http://huaih.ccgp-hunan.gov.cn', path: ''])
		def shaoy = new HtmlData([host: 'http://shaoy.ccgp-hunan.gov.cn', path: ''])
		def loud = new HtmlData([host: 'http://loud.ccgp-hunan.gov.cn', path: ''])
		def hengy = new HtmlData([host: 'http://hengy.ccgp-hunan.gov.cn', path: ''])
		cityMap << new HtmlData([title:'郴州市 招标',host: 'http://chenz.ccgp-hunan.gov.cn', path: '/more.cfm?sid=100002001', selectPath: commonPath])
		cityMap << new HtmlData([title:'郴州市 中标',host: 'http://chenz.ccgp-hunan.gov.cn', path: '/more.cfm?sid=100002002', selectPath: commonPath])
	}
}

class HtmlData {

	def title
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