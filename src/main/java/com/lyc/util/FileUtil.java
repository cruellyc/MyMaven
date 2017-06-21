package com.lyc.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * 文件处理器
 * 此类包含各类文件、文件夹、图片等的处理
* @Title: FileUtil.java
* @Package com.seed.util
* @Description: 文件实用工具
* @author janyzheng
* @date 2014-6-23 下午8:42:15
* @version V1.0
 */
public class FileUtil {
	private static Logger logger = Logger.getLogger(FileUtil.class);

	/**
	 * 复制文件
	* @Title: copyFile
	* @Description: 复制文件
	* @return void    返回类型
	* @author janyzheng
	* @date 2014-6-23 下午8:43:09
	* @param sourceFile 原文件（如：c://a.jpg）
	* @param targetFile 目标文件(如：c://b.jpg)
	* @throws IOException
	 */
	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		if (sourceFile.exists() && !targetFile.exists()) {
			try {
				// 新建文件输入流并对它进行缓冲
				inBuff = new BufferedInputStream(
						new FileInputStream(sourceFile));
				// 新建文件输出流并对它进行缓冲
				outBuff = new BufferedOutputStream(new FileOutputStream(
						targetFile));
				// 缓冲数组
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = inBuff.read(b)) != -1) {
					outBuff.write(b, 0, len);
				}
				// 刷新此缓冲的输出流
				outBuff.flush();
			} finally {
				// 关闭流
				if (inBuff != null)
					inBuff.close();
				if (outBuff != null)
					outBuff.close();
			}
		}
		logger.info("文件复制成功！");
	}

	/**
	 * 判断文件夹是否存在，否则创建
	* @Title: mkDir
	* @Description: 创建目录
	* @return File    返回类型
	* @author janyzheng
	* @date 2014-6-23 下午8:49:05
	* @param srcFile
	* @return
	 */
	public static File mkDir(File srcFile) {
		if (srcFile.isDirectory() && !srcFile.exists()) {
			srcFile.mkdir();
		}
		return srcFile;
	}

	/**
	 * 判断文件夹路径是否存在，否则创建文件夹
	* @Title: mkDir
	* @Description: 创建目录
	* @return void    返回类型
	* @author janyzheng
	* @date 2014-6-23 下午8:49:30
	* @param srcPath
	 */
	public static void mkDir(String srcPath) {
		File srcFile = new File(srcPath);
		if (srcFile.isDirectory() && !srcFile.exists()) {
			srcFile.mkdir();
		}
	}

	/**
	 * 判断文件夹是否存在，不存在则创建所有的文件夹
	* @Title: mkDirs
	* @Description: 创建目录
	* @return void    返回类型
	* @author janyzheng
	* @date 2014-6-23 下午8:51:23
	* @param srcPath
	 */
	public static void mkDirs(String srcPath) {
		File srcFile = new File(srcPath);
		if (srcFile.isDirectory() && !srcFile.exists()) {
			srcFile.mkdirs();
		}
	}

	/**
	 * 判断文件夹是否存在，不存在则创建所有的文件夹（例如a/b/c）
	* @Title: mkDirs
	* @Description: 创建目录
	* @return File    返回类型
	* @author janyzheng
	* @date 2014-6-23 下午8:51:44
	* @param srcFiles
	* @return
	 */
	public static File mkDirs(File srcFiles) {
		if (srcFiles.isDirectory() && !srcFiles.exists()) {
			srcFiles.mkdirs();
		}
		return srcFiles;
	}
	/**
	 * 判断文件夹是否存在，不存在则创建所有的文件夹,且在该文件夹下创建fileName文件
	* @Title: mkFile
	* @Description: 创建文件
	* @return File    返回类型
	* @author janyzheng
	* @date 2014-6-23 下午8:51:56
	* @param dirPath
	* @param fileName
	* @return
	 */
	public static File mkFile(String dirPath,String fileName) {
		File srcFile = new File(dirPath);
		if (!srcFile.exists()) {
			srcFile.mkdirs();
		}
		srcFile=new File(dirPath+fileName);
		return srcFile;
	}

	/**
	 * 判断文件是否存在，存在则删除
	 * 
	 * @param srcFile
	 */
	public static void removeFile(File srcFile) {
		if (srcFile.exists()) {
			srcFile.delete();
		}
	}

	
	/**
	 * 获取文件后缀名
	 * 
	 * @param oldFile
	 *            原来的文件名
	 * @param thumIcon
	 * @return
	 */
	public static String getFileSuffix(String oldFile) {
		String fileSuffix = oldFile.substring(oldFile.lastIndexOf('.') + 1,
				oldFile.length());
		return fileSuffix;
	}


	/**
	 * 将InputStream转换成byte数组
	 * 
	 * @param in
	 *            InputStream
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] inStream2Byte(InputStream in) throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int readLine = -1;
		while ((readLine = in.read(data, 0, 1024)) != -1){
			outStream.write(data, 0, readLine);
		}
		return outStream.toByteArray();
	}
	// 手机端文件上传,解码并保存到响应的文件夹
	public static boolean decordBase64(String baseStr, String tagFilePath) {
		// 把base64编码转成图片
		byte[] imgsByte = Base64.decodeBase64(baseStr);
		FileOutputStream out = null;
		boolean result=false;
		try {
			out = new FileOutputStream(new File(tagFilePath));
			out.write(imgsByte);// 把图片写入upload文件夹
			result=true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.debug("找不到文件");
		} catch (IOException e) {
			e.printStackTrace();
			logger.debug("io异常");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.debug("io异常");
			}
		}
		return result;
	}
	public static String encodeBase64(String imgPath) {
		InputStream in;
		try {
			in = new FileInputStream(imgPath);
			byte[] imgsByte = new byte[in.available()];
			in.read(imgsByte);
			in.close();
			return Base64.encodeBase64String(imgsByte);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	/**
	 * 读取文件中的文本
	* @Title: readFileTxt
	* @Description: 读取TXT文件
	* @return String    返回类型
	* @author janyzheng
	* @param file
	* @return
	 */
	public static String readFileTxt(File file){
		if(file.exists()&&file.isFile()){
			InputStreamReader streamReader;
			try {
				streamReader = new InputStreamReader(new FileInputStream(file),"utf-8");
				@SuppressWarnings("resource")
				BufferedReader br=new BufferedReader(streamReader);
				StringBuffer sb=new StringBuffer();
				String line=null;
				while((line=br.readLine())!=null){
					sb.append(line+"\n");
				}
				return sb.toString();
			} catch (FileNotFoundException e) {
				logger.error("找不到指定文件");
			} catch (IOException e) {
				logger.error("io异常");
			}
		}
		return "";
	}
}
