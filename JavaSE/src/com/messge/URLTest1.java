package com.messge;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Description:
 * date:2020-08-15 12:15
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class URLTest1 {
    public static void main(String[] args)  {
        HttpURLConnection urlConnection = null;
        InputStream is= null;
        FileOutputStream fos = null;
        try {
            URL url=new URL("        ");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("      ");

            byte[]buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(urlConnection!=null){
                urlConnection.disconnect();
            }
        }







    }
}
