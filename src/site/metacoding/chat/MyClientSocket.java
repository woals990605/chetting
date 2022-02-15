package site.metacoding.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;

public class MyClientSocket {

    Socket socket;
    BufferedWriter writer;
    Scanner sc;

    // 추가
    BufferedReader reader;

    public MyClientSocket() {
        try {
            // IP주소, 포트번호
            socket = new Socket("192.168.0.132", 1077);
            writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            sc = new Scanner(System.in);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(() -> {
                while (true) {
                    try {
                        String inputData = reader.readLine();
                        System.out.println("받은 메시지 : " + inputData);
                        System.out.println("===============");

                        System.out.println("대화가 종료되었습니다.");
                        break;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();

            System.out.println("내용을 입력하세요.");
            while (true) {
                String inputData = sc.nextLine();
                writer.write(inputData + "\n");
                writer.flush();
                System.out.println("보낸 메시지 : " + inputData);
                System.out.println("===============");
                if (inputData.equals("")) {
                    System.out.println("대화가 종료되었습니다.");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyClientSocket();
    }
}