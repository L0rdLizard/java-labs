package ru.semestr1.lab12;
//Написать текстовый многопользовательский чат.
//Пользователь управляет клиентом. На сервере пользователя нет. Сервер занимается пересылкой сообщений между клиентами.
//По умолчанию сообщение посылается всем участникам чата.
//Есть команда послать сообщение конкретному пользователю (@senduser Vasya).
//Программа работает по протоколу TCP

//Серверная часть
//Серверная часть должна быть реализована в виде отдельного потока.
//Сервер должен уметь одновременно работать с несколькими клиентами.
//Клиенты могут подключаться и отключаться в любой момент времени.

//Клиентская часть
//Клиент после запуска программы должен спросить у пользователя адрес и порт сервера, подключиться к указанному адресу

//При подключении клиента сервер спрашивает его имя.
//После этого клиент может отправлять текстовые сообщения в чат.
//Каждое сообщение сервер подписывает именем клиента и рассылает всем клиентам.

//Если клиент отправляет сообщение с текстом @senduser Vasya, то сообщение получает только клиент с именем Vasya.
//Если клиент отправляет сообщение с текстом @exit, то клиент отключается от сервера.
import java.io.*;
import java.net.*;
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
                    } else if (message.startsWith("@senduser ")) {
                        String username = message.substring(10);
                        String tempMessage = in.readLine();
                        for (Connection connection : connections) {
                            if (connection.name.equals(username)) {
                                connection.out.println(name + ": " + tempMessage);
                            }
                        }
                    } else {
                        for (Connection connection : connections) {
                            connection.out.println(name + ": " + message);
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




