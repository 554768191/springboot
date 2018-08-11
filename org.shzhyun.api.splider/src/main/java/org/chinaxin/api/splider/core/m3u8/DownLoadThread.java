package org.chinaxin.api.splider.core.m3u8;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DownLoadThread extends Thread {
    String fileName = Thread.currentThread().getName();
    private List<String> fileList = new ArrayList<String>();
    String url = "http://aicdn-cbd68274-5.osjzo.com:81/heyzo_hd_0001_full/500kb/hls/";
    private String count = null;
    private int i = 0;
    DecimalFormat df=new DecimalFormat("0000");

    public DownLoadThread(int i) {
        this.i = i;
    }
    public void run(){
        int di = 100*i;
        System.out.println("-------线程名称-------"+fileName);
        for(int j=di+1 ;j<100*(i+1) ;j++){
            count =df.format(j);
            url = "http://aicdn-cbd68274-5.osjzo.com:81/heyzo_hd_"+count+"_full/500kb/hls/";
            System.out.println("--------第"+count+"个---------");
            System.out.println("-------url-------"+url);
            try{
//					new ProgressBarRealized(fileList, fileName, url,progressBar).execute();
                new DownLoadUtil(fileList, j+"-"+fileName, url).downLoadByUrl();
            }catch (Exception e){
                System.out.println("------------第"+count+"个----异常");
            }
        }

    }
}
