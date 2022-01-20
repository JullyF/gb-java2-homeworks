package lesson6homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleChatServer {

    public static final int PORT = 12345;
    private static DataOutputStream output;
    private static DataInputStream input;
    private static Scanner scanner;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер начал работу. Ожидаются новые подключения.");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Успешное подключение к серверу.");

            output = new DataOutputStream(clientSocket.getOutputStream());
            input = new DataInputStream(clientSocket.getInputStream());

            startInputTread();
            startSendingMessages();

        } catch (IOException e) {
            System.err.printf("Ошибка при подключении к порту %d.%n", PORT);
            e.printStackTrace();
        }
        scanner.close();
    }

    private static void startInputTread() {
        Thread inputThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = input.readUTF();
                    System.out.println("Клиент: " + message);
                    if (message.equalsIgnoreCase("/end")) {
                        System.exit(0); // Для одного клиента можно использовать этот метод при получении команды
                        //на завершение работы. Для нескольких клиентов нельзя будет использовать exit. Нужен будет break?
                    }
                } catch (IOException e) {
                    System.err.println("Не удалось прочитать сообщение от клиента.");
                    break;
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();
    }

    private static void startSendingMessages() throws IOException {
        scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            output.writeUTF(message);
            if (message.equalsIgnoreCase("/end")) {
                break;
            }
        }
    }
}

