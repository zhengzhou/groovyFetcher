package com.zhou

@Grab(group='org.apache.commons', module='commons-email', version='1.3.3')
import org.apache.commons.mail.*
/**
 * Created by zhou on 2014/12/11 0011.
 */
class EmailSender {

    void sentMail(data){
        def email = new SimpleEmail();
        email.hostName = "smtp.sina.com";
        //email.smtpPort(25);
        email.authenticator = new DefaultAuthenticator("xzzxia", "xzz352107");
        email.from = "xzzxia@sina.com";
        email.setSSLOnConnect(false);
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("zhengzhou.xu@hotmail.com");
        email.send();
    }

    String dumpData(){
        return null
    }
}
