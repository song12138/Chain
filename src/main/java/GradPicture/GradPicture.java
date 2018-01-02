package GradPicture;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by paul on 2017/12/20.
 */
public class GradPicture {

    /**
     * @param url      url
     * @param encoding encoding
     * @return java.lang.String
     * @description 根据网站的地址和页面的编码集来获取网页的源代码
     * @methodName getHtmlResourceByUrl
     * @author songxingfu [2274466718@qq.com]
     * @time 2017/12/20 10:53
     */
    public static String getHtmlResourceByUrl(String url, String encoding) {
        // 用于存储网页源代码
        StringBuffer stringBuffer = new StringBuffer();

        URL urlObject;
        URLConnection uc;
        InputStreamReader isr = null;
        BufferedReader bufferedReader;
        try {
            // 建立网络连接
            urlObject = new URL(url);
            // 打开网络连接
            uc = urlObject.openConnection();
            // 将连接网络的输入流转换
            isr = new InputStreamReader(uc.getInputStream(), encoding);
            // 建立缓冲写入流
            bufferedReader = new BufferedReader(isr);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\n");// 一行一行的追加代码
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    /**
     * @param filepath filepath  文件保存的路径
     * @param imgUrl   imgUrl
     * @return void
     * @description 根据图片的网络地址，下载图片带本地服务器
     * @methodName DownImages
     * @author songxingfu [2274466718@qq.com]
     * @time 2017/12/20 11:03
     */
    public static void DownImages(String filepath, String imgUrl) {
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/"));

        try {
            // 创建文件目录
            File files = new File(filepath);
            if (!files.exists()) {
                files.mkdirs();
            }
            // 获取下载地址
            URL url = new URL(imgUrl);
            // 连接网络地址
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            // 获取连接的输出流
            InputStream is = httpURLConnection.getInputStream();
            // 创建文件
            File file = new File(filepath + fileName);
            //写入文件
            FileOutputStream out = null;
            if (file.getName().endsWith("jpg") || file.getName().endsWith("png")
                    || file.getName().endsWith("jpeg") || file.getName().endsWith("jpg")) {
                out = new FileOutputStream(file);
                int i = 0;
                while ((i = is.read()) != -1) {
                    out.write(i);
                }
                is.close();
                out.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析网页图片标签，下载图片
     * @param url
     * @param encoding
     * @param path
     */
    public static void getImage(String url, String encoding, String path) {
        String htmlResource = getHtmlResourceByUrl(url, encoding);

        // 解析网页源代码
        Document document = Jsoup.parse(htmlResource);
        // 获取所以图片的地址<img src="" alt= "" width= "" height=""/>
        Elements elements = document.getElementsByTag("img");
        for (Element element : elements) {
            String imgSrc = element.attr("src");
            if (!"".equals(imgSrc) && imgSrc.startsWith("http://")) {
                DownImages(path, imgSrc);
            }
        }
    }


    public static void main(String[] args) {
        // 根据网页地址和网页的编码集 获取网页的内容
        String url = "http://www.cnblogs.com/zrtqsk/p/3735273.html";
        String encoding = "utf-8";
        String path = "d:\\downImage";
        getImage(url,encoding,path);
    }


}
