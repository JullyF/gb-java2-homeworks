package lesson6homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleChatClient {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 12345;
    private static DataOutputStream output;
    private static DataInputStream input;
    private static Scanner scanner;


    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            System.out.println("Успешное подключение к серверу.");
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());

            startClientInputTread();
            startSendingMessagesFromClient();

        } catch (IOException e) {
            System.err.println("Невозможно установить соединение с сервером.");
        }
        scanner.close();
    }

    private static void startClientInputTread() {
        Thread inputThread = new Thread(() -> {
            while (true) {
                try {
                    String message = input.readUTF();
                    System.out.println("Сервер: " + message);
                    if (message.equalsIgnoreCase("/end")) {
                       break;
                    }
                } catch (IOException e) {
                    System.err.println("Не удалось прочитать сообщение от сервера.");
                    break;
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();
    }

    private static void startSendingMessagesFromClient() throws IOException {
        scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            output.writeUTF(message);
            if (message.equalsIgnoreCase("/end")) {
                System.exit(0);
            }
        }
    }
}



