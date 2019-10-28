package client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 *
 * @author nisabengisu
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        String host = "10.99.15.255";
        socket = new Socket(host, 300);

        File file = new File("C:\\Users\\nisabengisu\\Desktop\\Client\\test.zip");
        long length = file.length();
        byte[] bytes = new byte[2048];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        socket.close();
    }
}

