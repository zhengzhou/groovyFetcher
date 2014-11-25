@Grab(group="org.jsoup",module="jsoup",version="1.8.1")
import org.jsoup.Jsoup;

void fetch(){
	def yongz = "http://yongz.ccgp-hunan.gov.cn/more.cfm?sid=100002001"
	println "fetch.. $yongz"
	path = "body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr"
	Jsoup.connect("$yongz").get().select(path).each {
		def href = it.select('a').attr("href");
		def title = it.text()
		println "name:$title href:$href" 
		
	}
}


fetch();