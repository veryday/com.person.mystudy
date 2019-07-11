package com.example.demo.tool;
/**
 * 文字生成图片
 * @author Admin
 *
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class WordToImage {

	public static void main(String[] args) throws IOException {
		
		CheckImage(80, 30, new File("a.png"), "一曲相思");
	}

	public static File CheckImage(Integer width, Integer height, File outFile, String content) throws IOException {
		// 创建特定格式的图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 创建画笔
		Graphics g = image.getGraphics();
		// 设置边框颜色
		g.setColor(Color.WHITE);
		// 设置边框大小
		g.fillRect(0, 0, width, height);
		// 设置内容颜色
		g.setColor(Color.BLUE);
		// 画内容
		g.drawString(content,0,10);
		//放下画笔
		g.dispose();
		// 输出png图片
		ImageIO.write(image, "png", outFile);
		return outFile;
	}
}
