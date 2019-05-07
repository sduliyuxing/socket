import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ProjectName idea_space
 * @PackageName PACKAGE_NAME
 * @ClassName: tcpserver
 * @Author liyuxing
 * @Date 2019/5/7   20:34
 * @Description:
 */
public class tcpserver {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket=new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        InputStream inputStream=accept.getInputStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String msg=null;
        while ((msg=bufferedReader.readLine())!=null){
            System.out.println("接收到客户端的消息： "+msg);
        }
        accept.shutdownInput();
        OutputStream outputStream = accept.getOutputStream();
        PrintWriter printWriter=new PrintWriter(outputStream);
        printWriter.write("接收完毕");
        printWriter.flush();

        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
