package com.example.demo.emailAndMessag;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.example.demo.tool.DES;
import com.example.demo.tool.PropertisUtil;
/**
 * email发送
 * @author Admin
 *
 */
public class Email {
	

	public static void main(String[] args) throws Exception {
		sendEmail();
	}
	/**
	 * 发送email
	 * @throws Exception
	 */
	public static void sendEmail() throws Exception {
		Properties props = PropertisUtil.getProperties(Email.class.getClassLoader().getResourceAsStream("mailConfig.properties"));
		 // 得到回话对象
		Session session = Session.getInstance(props);
		 //创建邮件对象
		Message msg = new MimeMessage(session);
		//设置发件人邮箱地址
		msg.setFrom(new InternetAddress(props.getProperty("sendAddr")));
		// 设置收件人邮箱地址 
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(props.getProperty("ReviceAddr")));
		// 设置邮件标题
		msg.setSubject("Test_email");
		//设置附件
		Multipart multipart = new MimeMultipart();//向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
		//设置邮件内容
		BodyPart contentPart = new MimeBodyPart();//设置邮件的文本内容
		contentPart.setText("本次邮件只是为了测试。");
		multipart.addBodyPart(contentPart);
		String AFFIX = props.getProperty("AFFIX");
		String AFFIXNAME = props.getProperty("AFFIXNAME");
		if(!AFFIX.isEmpty()){//添加附件
			 BodyPart messageBodyPart = new MimeBodyPart();
			  DataSource source = new FileDataSource(AFFIX);
			  messageBodyPart.setDataHandler(new DataHandler(source));//添加附件的内容
			  sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();//添加附件的标题
			  messageBodyPart.setFileName("=?GBK?B?"+ enc.encode(AFFIXNAME.getBytes()) + "?=");
			  multipart.addBodyPart(messageBodyPart);
		}
		msg.setContent(multipart);//将multipart对象放到message中
		msg.saveChanges(); //保存邮件
		//创建邮差对象(邮件转发者)
		Transport transport =session.getTransport();
		//连接发送的邮箱
		transport.connect(props.getProperty("sendAddr"), DES.decrypt(props.getProperty("sendPwd"),"QADqw124"));
		 // 发送邮件
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
	}

}
