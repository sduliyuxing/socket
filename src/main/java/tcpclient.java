import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @ProjectName idea_space
 * @PackageName PACKAGE_NAME
 * @ClassName: tcpclient
 * @Author liyuxing
 * @Date 2019/5/7   20:35
 * @Description:
 */
public class tcpclient {

    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("localhost",8888);
        System.out.println(socket.isConnected());
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter=new PrintWriter(outputStream);
        printWriter.write("用户已登录");
        printWriter.flush();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String msg=null;
        while ((msg=bufferedReader.readLine())!=null){
            System.out.println("接收到服务端的消息： "+msg);
        }

        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
    }
}
