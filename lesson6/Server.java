package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static ServerSocket server;
    static Socket socket;
    static final int PORT = 8189;

    static Scanner in;
    static PrintWriter out;
    static Scanner sc;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("server started");

            socket = server.accept();
            System.out.println("client connected");

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
                        System.out.println("Client: " + str);
                    }
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        server.close();
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