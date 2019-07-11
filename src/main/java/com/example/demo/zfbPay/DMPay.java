package com.example.demo.zfbPay;

import java.util.ArrayList;
import java.util.List;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.example.demo.config.AlipayConfig;
import com.example.demo.tool.ZxingUtils;

/**
 * 当面付
 * 
 * @author Admin
 *
 */
public class DMPay {

	public static void main(String[] args) throws AlipayApiException {

		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
				AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
				AlipayConfig.SIGNTYPE);
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		// out_trade_no商户订单号
		String outTradeNo = "tradeprecreate" + System.currentTimeMillis() + (long) (Math.random() * 10000000L);
		// total_amount付款金额
		String totalAmount = "0.01";
		// subject订单名称
		String subject = "xxx品牌xxx门店当面付扫码消费";
		// (可选) 订单不可打折金额
		String undiscountableAmount = "0";
		// 卖家支付宝账号ID
		// 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
		String sellerId = "";
		// 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
		String body = "购买商品3件共20.00元";
		// 商户操作员编号，添加此参数可以为商户操作员做销售统计
		String operatorId = "test_operator_id";
		// (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
		String storeId = "test_store_id";
		// 支付超时，定义为120分钟
		String timeoutExpress = "120m";

		// 商品明细列表，需填写购买商品详细信息，
		List<com.alipay.api.domain.GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
		// 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
		GoodsDetail goods1 = new GoodsDetail();
		goods1.setGoodsId("goods_id001");
		goods1.setGoodsName("xxx小面包");
		goods1.setPrice("1.00");
		goods1.setQuantity(1L);
		// 创建好一个商品后添加至商品明细列表
		goodsDetailList.add(goods1);

		// 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.00元，购买了两件
		GoodsDetail goods2 = new GoodsDetail();
		goods2.setGoodsId("goods_id002");
		goods2.setGoodsName("xxx牙刷");
		goods2.setPrice("5.00");
		goods2.setQuantity(2L);
		goodsDetailList.add(goods2);

		AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
		model.setOutTradeNo(outTradeNo);
		model.setTotalAmount(totalAmount);
		model.setSubject(subject);
		model.setUndiscountableAmount(undiscountableAmount);
		model.setSellerId(sellerId);
		model.setBody(body);
		model.setOperatorId(operatorId);
		model.setStoreId(storeId);
		model.setTimeoutExpress(timeoutExpress);
		model.setStoreId(storeId);
		model.setGoodsDetail(goodsDetailList);
		request.setBizModel(model);

		// request.setNotifyUrl("http://192.168.168.110/Zpay");

		AlipayTradePrecreateResponse response = alipayClient.execute(request);

		if (response.isSuccess()) {
			System.out.println("调用成功");
			System.out.println(response.getBody());
			// 需要修改为运行机器上的路径
			String filePath = String.format(System.getProperty("user.dir") + "\\qr-%s.png", response.getOutTradeNo());
			System.out.println("filePath:" + filePath);
			ZxingUtils.getQRCodeImge(response.getQrCode(), 256, filePath);
		} else {
			System.out.println("调用失败");
		}
	}
/**
 * 当面支付
 * @param model
 * @param QRCodeFilePath
 * @throws AlipayApiException
 */
	public DMPay(AlipayTradePrecreateModel model,String QRCodeFilePath) throws AlipayApiException {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
				AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
				AlipayConfig.SIGNTYPE);
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		AlipayTradePrecreateResponse response = alipayClient.execute(request);

		if (response.isSuccess()) {
			System.out.println("调用成功");
			System.out.println(response.getBody());
			// 需要修改为运行机器上的路径
			System.out.println("filePath:" + QRCodeFilePath);
			ZxingUtils.getQRCodeImge(response.getQrCode(), 256, QRCodeFilePath);
		} else {
			System.out.println("调用失败");
		}
	}
}
