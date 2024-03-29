package ru.semestr1.lab12;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ServerChat2 {
    private static List<Connection> connections = new ArrayList<>();
    private static List<Connection> winners = new ArrayList<>();
    private static int bank;
    private static int rightInt;
    private static boolean isCasino = false;


    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Server <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(port);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(System.out, true);

        Thread serverThread = new Thread(() -> {
            while (true) {
                try {
                    String message = reader.readLine();
                    if (message.startsWith("@casino ")) {
                        isCasino = true;
                        String max = message.substring(8);

                        int maxInt = Integer.parseInt(max);
                        rightInt = (int) (Math.random() * maxInt) + 1;
                        System.out.println(rightInt);

//                        List<Connection> winners = new ArrayList<>();
                        bank = 0;
                        winners.clear();

                        for (Connection connection : connections) {
                            connection.out.println("try to guess the number from 1 to " + max + "\n" + "write '@guess', your number and your bet" + "\n" + "you have 30 seconds");

//                            String tempMessage = connection.in.readLine();
//                            int tempNumber = 0;
//                            int tempBet = 0;

//                            if (tempMessage.startsWith("@guess ")) {
//                                tempMessage = tempMessage.substring(7);
//                                tempNumber = Integer.parseInt(tempMessage.substring(0, tempMessage.indexOf(" ")));
//                                tempBet = Integer.parseInt(tempMessage.substring(tempMessage.indexOf(" ") + 1));
//
//                                bank += tempBet;
//                                System.out.println(connection.name + " " + tempBet);
//                            }
//                            if (tempNumber == rightInt) {
//                                winners.add(connection);
//                            }
                        }

                        try {
                            Thread.sleep(30000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (winners.size() > 0) {
                            if (winners.size() > 1){
                                bank = bank / winners.size();
                            }
                            for (Connection connection : winners) {
                                connection.out.println("you win " + bank);
                            }
                        } else {
                            for (Connection connection : connections) {
                                connection.out.println("no winners");
                            }
                        }
                        isCasino = false;
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
            System.out.println(connections);
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
                while (true){
                    Thread.sleep(10000);
                    for (Connection connection : connections) {
                        connection.out("Make America greate again!")
                    }
                }
                while (true) {
                    String message = in.readLine();
                    if (message.equals("@exit")) {
                        break;
                    } else if ((message.startsWith("@guess ")) && isCasino) {
                        String bet = message.substring(7);

                        int tempNumber = Integer.parseInt(bet.substring(0, bet.indexOf(" ")));
                        int tempBet = Integer.parseInt(bet.substring(bet.indexOf(" ") + 1));
                        bank+=tempBet;

                        out.println("your bet: " + tempBet);

                        if (tempNumber == rightInt){
                            winners.add(this);
                        }


//                        for (Connection connection : connections) {
//                            if (connection.name.equals(name)) {
//                                connection.out.println("your bet: " + tempBet);
//                            }
//                        }
                    } else if (message.startsWith("@ls ")) {
                        String username = message.substring(4);
                        String tempMessage = in.readLine();
                        for (Connection connection : connections) {
                            if (connection.name.equals(username)) {
                                connection.out.println(name + ": " + tempMessage);
                            }
                        }
                    } else {
                        if (message.startsWith("hello")){
                            for (Connection connection : connections) {
                                connection.out("Hi to everyone!")
                            }
                        }
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




