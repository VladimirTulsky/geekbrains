package lesson6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static Socket socket;
    static final int PORT = 8189;
    static final String IP_ADDRESS = "localhost";

    static Scanner in;
    static PrintWriter out;
    static Scanner sc;

    public static void main(String[] args) {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            sc = new Scanner(new InputStreamReader(System.in));

            new Thread(()-> {
                try {
                    while (true) {
                        String str = in.nextLine();
                        if (str.equals("/end")) {
                            System.out.println("Disconnected");
                            out.println("/end");
                            break;
                        }
                        System.out.println("Server: " + str);
                    }
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            Thread t2 = new Thread(()-> {
                while (true) {
                    out.println(sc.nextLine());
                }
            });
            t2.setDaemon(true);
            t2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
