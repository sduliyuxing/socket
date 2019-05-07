import org.junit.Test;

import javax.sound.midi.Soundbank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @ProjectName idea_space
 * @PackageName PACKAGE_NAME
 * @ClassName: socket
 * @Author liyuxing
 * @Date 2019/4/17   20:55
 * @Description:
 */
public class socket {

    @Test
    public void test1() throws Exception {

        //获取本机的InetAddress实例
        InetAddress address=InetAddress.getLocalHost();
        String hostName = address.getHostName();//获取计算机名
        String ip = address.getHostAddress();
        byte[] ipaddress = address.getAddress();
        System.out.println(hostName);
        System.out.println(ip);
        System.out.println(ipaddress.toString());

        URL baidu=new URL("http://www.baidu.com");
        URL url=new URL(baidu,"/index.html?username=tom#test");//？表示参数，#表示锚点
        //协议
        String protocol = url.getProtocol();
//        主机
        String host = url.getHost();
//        端口
        int port = url.getPort();
//        文件路径
        String path = url.getPath();
        //文件名，包括文件路径+参数
        String file = url.getFile();
        //相对路径，就是锚点，即#号后面的内容
        String ref = url.getRef();
        //查询字符串，即参数
        String query = url.getQuery();
        System.out.println(protocol);
        System.out.println(host);
        System.out.println(port);
        System.out.println(path);
        System.out.println(file);
        System.out.println(ref);
        System.out.println(query);
    }

    @Test
    public void test2() throws Exception{
        URL url=new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String data = bufferedReader.readLine();
        while (data!=null){
            System.out.println(data);
            data=bufferedReader.readLine();
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }

}
