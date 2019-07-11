package com.example.demo.zfbPay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.demo.config.AlipayConfig;
/**
 * PC端支付
 * @author Admin
 *
 */
public class WebPay {
	

	public static void main(String[] args) throws AlipayApiException {

		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
				AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
				AlipayConfig.SIGNTYPE);
		AlipayTradePagePayRequest alipay_request=new AlipayTradePagePayRequest();
		 
		   // out_trade_no商户订单号
			String outTradeNo = "tradeprecreate" + System.currentTimeMillis() + (long) (Math.random() * 10000000L);
			// total_amount付款金额
			String totalAmount = "0.01";
			// subject订单名称
			String subject = "xxx品牌xxx门店当面付扫码消费";
			// 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
			String body = "购买商品3件共20.00元";
			 // 支付超时，定义为120分钟
	        String timeoutExpress = "120m";
	       // 销售产品码 必填
	        String product_code="FAST_INSTANT_TRADE_PAY";
			
		// 封装请求支付信息
		    AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
		    model.setOutTradeNo(outTradeNo);
		    model.setSubject(subject);
		    model.setTotalAmount(totalAmount);
		    model.setBody(body);
		    model.setTimeoutExpress(timeoutExpress);
		    model.setProductCode(product_code);
		    alipay_request.setBizModel(model);

		    String form = alipayClient.pageExecute(alipay_request).getBody();
		    System.out.println( form);
	}
	/**
	 * PC端支付
	 * @param model
	 * @return
	 * @throws AlipayApiException
	 */
	public String PCWebPay(AlipayTradeWapPayModel model) throws AlipayApiException {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
				AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
				AlipayConfig.SIGNTYPE);
		AlipayTradePagePayRequest alipay_request=new AlipayTradePagePayRequest();
		  alipay_request.setBizModel(model);
		  String form = alipayClient.pageExecute(alipay_request).getBody();
		  return form;
	}

}
