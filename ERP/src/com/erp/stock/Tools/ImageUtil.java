package com.erp.stock.Tools;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static int zoomImgAndSave(File file, int w, int h, File saveFile) {
		int ret = 0;
		try {
			String ext = file.getName().substring(
					file.getName().lastIndexOf(".") + 1);
			BufferedImage srcImg = ImageIO.read(file);// 读取原图信息
			Image targetImg = srcImg
					.getScaledInstance(w, h, Image.SCALE_SMOOTH);// 按尺寸缩放图片
			BufferedImage bufferedImage = new BufferedImage(w, h,
					BufferedImage.TYPE_INT_RGB);
			bufferedImage.getGraphics().drawImage(targetImg, 0, 0, null);// 将targetImg绘制到bufferedImage中
			ImageIO.write(bufferedImage, ext, saveFile);// 保存图片
			ret = 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;

	}

	/**
	 * 等比例缩放图片
	 * 
	 * @param file
	 * @param w
	 * @param h
	 * @param saveFile
	 * @return
	 */
	public static int zoomScaleImgAndSave(File file, int w, int h, File saveFile) {
		int ret = 0;
		double rate1 = 0.0, rate2 = 0.0;
		try {
			String ext = file.getName().substring(
					file.getName().lastIndexOf(".") + 1);
			BufferedImage srcImg = ImageIO.read(file);// 读取原图信息
			if (srcImg.getWidth() > w || srcImg.getHeight() > h) {// 等比缩放
				rate1 = srcImg.getWidth() / w;
				rate2 = srcImg.getHeight() / h;
				double rate = rate1 > rate2 ? rate1 : rate2;
				w = (int) (srcImg.getWidth() / rate);
				h = (int) (srcImg.getHeight() / rate);
			}
			Image targetImg = srcImg
					.getScaledInstance(w, h, Image.SCALE_SMOOTH);
			BufferedImage bufferedImage = new BufferedImage(w, h,
					BufferedImage.TYPE_INT_RGB);
			bufferedImage.getGraphics().drawImage(targetImg, 0, 0, null);// 将targetImg绘制到bufferedImage中
			ImageIO.write(bufferedImage, ext, saveFile);// 保存图片
			ret = 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;

	}
}
