import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import javax.sound.midi.Soundbank;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahao0 on 2016/12/7.
 */
public class Test {

    public static void main(String[] args) throws IOException {





        /*//post请求的方式,机器代码
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/save");

        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("username","jack"));
        list.add(new BasicNameValuePair("address","北京"));

        httpPost.setEntity(new UrlEncodedFormEntity(list));
        for(int i = 0;i < 10;i++) {
            httpClient.execute(httpPost);
        }
        httpClient.close();*/





       /* //字节流
        //创建一个可以发送请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个发送get请求方式
        HttpGet httpGet = new HttpGet("http://ww1.sinaimg.cn/mw690/824de770jw1epwcnivby6j20go0p00x4.jpg");
        //发出请求并接受客户端响应
        HttpResponse response = httpClient.execute(httpGet);
        //获取http响应状态码
        int status = response.getStatusLine().getStatusCode();

        if(status == 200) {
            InputStream inputStream = response.getEntity().getContent();
            OutputStream outputStream = new FileOutputStream("E:/workpace/x.jpg");

            IOUtils.copy(inputStream,outputStream);

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } else {
            System.out.println("服务器异常：" + status);
        }
        httpClient.close();*/





       /* //创建了一个可以发出请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个GET请求
        HttpGet httpGet = new HttpGet("http://www.pingwest.com/feed/");
        //发出请求并接受客户端响应
        HttpResponse httpResponse = httpClient.execute(httpGet);

        //获取http响应的状态码
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if(statusCode == 200) {
            //获取响应输入流
            InputStream inputStream = httpResponse.getEntity().getContent();

            String result = IOUtils.toString(inputStream, "UTF-8");

            inputStream.close();
            System.out.println(result);

        } else {
            System.out.println("服务器异常" + statusCode);
        }
        httpClient.close();*/
    }
}
