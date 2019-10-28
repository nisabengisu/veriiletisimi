package server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author nisabengisu
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(300);
        } catch (IOException ex) {
            System.out.println("Bu port numarasına ayarlayamıyor.");
        }

        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            socket = serverSocket.accept();
        } catch (IOException ex) {
            System.out.println("Bağlantıyı kabul etmiyor.");
        }

        try {
            in = socket.getInputStream();
        } catch (IOException ex) {
            System.out.println("Soket giriş akışı alınamıyor.");
        }

        try {
            out = new FileOutputStream("C:\\Users\\nisabengisu\\Desktop\\Server\\Dinlenen.zip"); 
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı.");
        }

        byte[] bytes = new byte[2048];

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}
