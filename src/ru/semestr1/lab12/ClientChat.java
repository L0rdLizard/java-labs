package ru.semestr1.lab12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientChat {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java Client <host> <port>");
            return;
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        Socket socket = new Socket(host, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your name:");
        String name = console.readLine();
        out.println(name);

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readLine();
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        while (true) {
            String message = console.readLine();
            out.println(message);
            if (message.equals("@exit")) {
                break;
            }
        }
    }
}

//java ClientChat localhost 8080

//java ServerChat 8080