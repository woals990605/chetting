package site.metacoding.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    ServerSocket serverSocket;
    Socket socket;
    BufferedReader reader;

    public MyServerSocket() {

        try {

            serverSocket = new ServerSocket(1077);
            System.out.println("서버 소켓 생성됨");
            socket = serverSocket.accept();// while을 돌면서 대기 (내부적)
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String inputData = reader.readLine();
            System.out.println("받은 메시지 : " + inputData);
            System.out.println("클라이언트 연결됨");
        } catch (Exception e) {
            System.out.println("통신 오류 발생 : " + e.getMessage());
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        new MyServerSocket();
        System.out.println("main 종료");
    }

}