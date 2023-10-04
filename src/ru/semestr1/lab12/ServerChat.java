package ru.semestr1.lab12;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ServerChat {
    private static List<Connection> connections = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Server <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(port);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Thread serverThread = new Thread(() -> {
            while (true) {
                try {
                    String message = reader.readLine();
                    System.out.println("12");
                    if (message.startsWith("@casino ")) {
                        String max = message.substring(8);
                        int maxInt = Integer.parseInt(max);
                        int rightInt = (int) (Math.random() * maxInt);
                        System.out.println(rightInt);
                        for (Connection connection : connections) {
                            connection.out.println(rightInt);
                        }
                        int numbers[];
                        int bets[];
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        serverThread.start();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            Connection connection = new Connection(clientSocket);
            connections.add(connection);
            connection.start();
        }
    }

    private static class Connection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket clientSocket;
        private String name;

        public Connection(Socket clientSocket) throws IOException {
            this.clientSocket = clientSocket;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                name = in.readLine();
                for (Connection connection : connections) {
                    connection.out.println(name + " joined");
                }

                while (true) {
                    String message = in.readLine();
                    if (message.equals("@exit")) {
                        break;
                    } else if (message.startsWith("@ls ")) {
                        String username = message.substring(4);
                        String tempMessage = in.readLine();
                        for (Connection connection : connections) {
                            if (connection.name.equals(username)) {
                                connection.out.println(name + ": " + tempMessage);
                            }
                        }
                    } else {
                        for (Connection connection : connections) {
                            if (!(connection.name.equals(name))) {
                                connection.out.println(name + ": " + message);
                            }
                        }
                    }
                }

                for (Connection connection : connections) {
                    connection.out.println(name + " left");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




