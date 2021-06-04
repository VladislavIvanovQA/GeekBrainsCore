package lesson14;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {
    private final static int PORT = 8089;
    private final static String HOST = "127.0.0.1";

    public Client() {
        Scanner inConsole = new Scanner(System.in);

        try {
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Client connected");

            new Thread(() -> {
                try (Scanner inSocket = new Scanner(socket.getInputStream())) {
                    while (true) {
                        String str;
                        try {
                            str = inSocket.nextLine();
                        } catch (NoSuchElementException e) {
                            System.out.println("Socket closed");
                            inConsole.close();
                            break;
                        }
                        if (str.equals("/end")) {
                            System.out.println("Server disconnected");
                            System.exit(0);
                        }
                        System.out.println("Server: " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    while (true) {
                        String str = inConsole.nextLine();
                        out.println(str);
                        if (str.equals("/end")) {
                            System.out.println("Client closed");
                            System.exit(0);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
