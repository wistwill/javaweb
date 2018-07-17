package com.ian.commons.code;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * @className: QRCodeUtils
 * @description: 二维码工具类
 * @author: Ian
 * @create: 2018-07-06 17:15
 **/
public class QRCodeUtils {
	/**
	 * 二维码宽度(默认)
	 */
	private static final int                         WIDTH  = 300;
	/**
	 * 二维码高度(默认)
	 */
	private static final int                         HEIGHT = 300;
	/**
	 * 二维码文件格式
	 */
	private static final String                      FORMAT = "png";
	/**
	 * 二维码参数
	 */
	private static final Map<EncodeHintType, Object> hints  = new HashMap();

	static {
		//字符编码
		hints.put( EncodeHintType.CHARACTER_SET, "utf-8" );
		//容错等级 H为最高
		hints.put( EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H );
		//边距
		hints.put( EncodeHintType.MARGIN, 2 );
	}

	/**
	 * 返回一个 BufferedImage 对象
	 *
	 * @param content 二维码内容
	 */
	public static BufferedImage toBufferedImage(String content) throws WriterException, IOException {
		BitMatrix bitMatrix = new MultiFormatWriter().encode( content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints );
		return MatrixToImageWriter.toBufferedImage( bitMatrix );
	}

	/**
	 * 返回一个 BufferedImage 对象
	 *
	 * @param content 二维码内容
	 * @param WIDTH   宽
	 * @param HEIGHT  高
	 */
	public static BufferedImage toBufferedImage(String content, int WIDTH, int HEIGHT) throws WriterException, IOException {
		BitMatrix bitMatrix = new MultiFormatWriter().encode( content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints );
		return MatrixToImageWriter.toBufferedImage( bitMatrix );
	}

	/**
	 * 将二维码图片输出到一个流中
	 *
	 * @param content 二维码内容
	 * @param stream  输出流
	 */
	public static void writeToStream(String content, OutputStream stream) throws WriterException, IOException {
		BitMatrix bitMatrix = new MultiFormatWriter().encode( content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints );
		MatrixToImageWriter.writeToStream( bitMatrix, FORMAT, stream );
	}

	/**
	 * 将二维码图片输出到一个流中
	 *
	 * @param content 二维码内容
	 * @param stream  输出流
	 * @param WIDTH   宽
	 * @param HEIGHT  高
	 */
	public static void writeToStream(String content, OutputStream stream, int WIDTH, int HEIGHT) throws WriterException, IOException {
		BitMatrix bitMatrix = new MultiFormatWriter().encode( content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints );
		MatrixToImageWriter.writeToStream( bitMatrix, FORMAT, stream );
	}

	/**
	 * 生成二维码图片
	 *
	 * @param content 二维码内容
	 * @param path    文件保存路径
	 */
	public static void createQRCode(String content, String path) throws WriterException, IOException {
		BitMatrix bitMatrix = new MultiFormatWriter().encode( content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints );
		MatrixToImageWriter.writeToPath( bitMatrix, FORMAT, new File( path ).toPath() );
	}

	/**
	 * 生成二维码图片
	 *
	 * @param content 二维码内容
	 * @param path    文件保存路径
	 * @param WIDTH   宽
	 * @param HEIGHT  高
	 */
	public static void createQRCode(String content, String path, int WIDTH, int HEIGHT) throws WriterException, IOException {
		BitMatrix bitMatrix = new MultiFormatWriter().encode( content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints );
		MatrixToImageWriter.writeToPath( bitMatrix, FORMAT, new File( path ).toPath() );
	}
}