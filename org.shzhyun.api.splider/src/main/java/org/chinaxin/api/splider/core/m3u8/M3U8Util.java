package org.chinaxin.api.splider.core.m3u8;

import java.util.regex.Pattern;

/**
 * m3u8客户端窗口
 * 
 * @author willdas
 *
 */
public class M3U8Util {

	private static final long serialVersionUID = 1L;

	/**
	 * 开始下载文件
	 * @param
	 */
	public void parseFile(String url){
//				String fileName = filePathText.getText();
		//改为多线程
		//域名url：http://aicdn-cbd68274-5.osjzo.com:81/heyzo_hd_0157_full/500kb/hls/		0157为0-1000
		//fileName 取f1 - f1000
		for(int i=0;i<10;i++){
			Thread thread = new DownLoadThread(i);
			thread.setName("thread"+i);
			thread.start();
		}

	}

	/**
	 * 正则网址
	 * @param url
	 * @return
	 */
	private static boolean regexUrl(String url) {
		Pattern pattern = Pattern
				.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
		if (pattern.matcher(url).matches()) {
			return true;
		}
		return false;
	}
}
