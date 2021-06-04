package lesson14;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ServerWithFeedback {
    private final static int PORT = 8089;

    public ServerWithFeedback() {
        Scanner inConsole = new Scanner(System.in);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started");

            Socket socket = server.accept();
            System.out.println("Client connected");

            new Thread(() -> {
                try (Scanner inSocket = new Scanner(socket.getInputStream())) {
                    while (true) {
                        String str = "";
                        try {
                            str = inSocket.nextLine();
                        } catch (NoSuchElementException e) {
                            System.out.println("Socket closed");
                            System.exit(0);
                        }
                        if (str.equals("/end")) {
                            System.out.println("Client disconnected");
                            System.exit(0);
                        }
                        System.out.println("Client: " + str);
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
                            System.out.println("Server closed");
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
        new ServerWithFeedback();
    }
}
