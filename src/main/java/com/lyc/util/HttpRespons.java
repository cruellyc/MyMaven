package com.lyc.util;

import java.io.InputStream;
import java.util.Vector;

/**
 * Class Name: HttpResponser.java Function:
 * 
 * @author JamyLin DateTime 2012-11-29 下午4:50:41
 * @version 1.0
 */
public class HttpRespons {

	String urlString;

	int defaultPort;

	String file;

	String host;

	String path;

	int port;

	String protocol;

	String query;

	String ref;

	String userInfo;

	String contentEncoding;

	Object content;

	String contentType;

	int code;

	String message;

	String method;

	int connectTimeout;

	int readTimeout;

	Vector<String> contentCollection;
	
	InputStream inStream;

	public Object getContent() {
		return content;
	}

	public String getContentType() {
		return contentType;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Vector<String> getContentCollection() {
		return contentCollection;
	}

	public String getContentEncoding() {
		return contentEncoding;
	}

	public String getMethod() {
		return method;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public String getUrlString() {
		return urlString;
	}

	public int getDefaultPort() {
		return defaultPort;
	}

	public String getFile() {
		return file;
	}

	public String getHost() {
		return host;
	}

	public String getPath() {
		return path;
	}

	public int getPort() {
		return port;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getQuery() {
		return query;
	}

	public String getRef() {
		return ref;
	}

	public String getUserInfo() {
		return userInfo;
	}

	/**
	 * @return the inStream
	 */
	public InputStream getInStream() {
		return inStream;
	}

	/**
	 * @param inStream the inStream to set
	 */
	public void setInStream(InputStream inStream) {
		this.inStream = inStream;
	}

}
