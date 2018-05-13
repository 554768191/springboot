package org.chinaxin.api.splider.core.m3u8;

import org.chinaxin.api.splider.core.ConstInf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 下载网络文件工具类
 * @author willdas
 *
 */
public class DownLoadUtil {

	private List<String> fileList = new ArrayList<String>();
	private boolean isComplete = true;
	private String fileName;
	private String urlT;

	public DownLoadUtil(List<String> fileList, String fileName, String urlT){
		this.fileList = fileList;
		this.fileName = fileName;
		this.urlT = urlT;
	}
	/**
	 * 下载网络文件
	 * @param tsFileUrl
	 * @param filePath
	 * @throws Exception
	 */
	public static boolean  downLoadTs(String tsFileUrl,String filePath) {
        try {
        	int byteread = 0;
            //url连接
    		URL url = new URL(tsFileUrl);
    		System.out.println("------tsFileUrl-----"+tsFileUrl);
    		HttpURLConnection  conn = (HttpURLConnection )url.openConnection();
    		//获取状态码
    		int responseCode = conn.getResponseCode();
    		//获取文件流
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(filePath);
            byte[] buffer = new byte[1204];
            if (responseCode == 200) {
            	//写入到目标文件中
                while ((byteread = inStream.read(buffer)) != -1) {
                    fs.write(buffer, 0, byteread);
                }
                fs.close();
                inStream.close();
			}
        } catch (Exception e) {
        	return false;
		}
        return true;
	}
	public void downLoadByUrl(){
		String url = "";
		int size = fileList.size();   //
//		String fileName = filePathText.getText();  //获取文件名称所有的ts文件
		String filePath = fileName.split("\\.")[0];
		//创建文件夹
		String finalFilePath = filePath + File.separator + filePath;
		FileUtil.createFilePath(finalFilePath);
		for (int i = 0;i < size;i++) {
			//获取每一个ts文件
			String tsFileName = fileList.get(i);
			String[] tsFileNameSplit = tsFileName.split("/");
			fileName = tsFileNameSplit[tsFileNameSplit.length-1];
			//文件最终写入路径
			finalFilePath = filePath + File.separator + fileName;
			//下载地址URL
			url = urlT + tsFileName;
			//判断网络文件是否正确
			boolean result = downLoadTs(url, ConstInf.filepath+finalFilePath);
			if (!result) {
				System.out.println("请检查网址或者M3U8文件是否正确");
				isComplete = false;
				break;
			}
//			//计算进度
//			float pro = (float) i / size * 100;
//			//计算结果格式化(四舍五入)
//			BigDecimal bd = new BigDecimal(pro).setScale(0, BigDecimal.ROUND_HALF_UP);
//			int k = Integer.parseInt(bd.toString());
//			//存入数据
//			publish(k);
		}
	}
}
