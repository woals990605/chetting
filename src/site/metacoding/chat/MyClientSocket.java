package site.metacoding.chat;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MyClientSocket {

    Socket socket;
    BufferedWriter writer;

    public MyClientSocket() {
        try {
            // IP주소, 포트번호
            socket = new Socket("192.168.0.132", 1077);
            writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            writer.write("황재민\n");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyClientSocket();
    }
}