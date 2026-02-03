// Write a program on datagram socket for client/server to display the 
// messages on client side, typed at the server side. 

// UDP Server - sends messages to client

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPS {
    public static void main(String[] args) {
        final int CLIENT_PORT = 12345;

        try (DatagramSocket serverSocket = new DatagramSocket()) {
            Scanner sc = new Scanner(System.in);
            InetAddress clientAddress = InetAddress.getByName("localhost");

            while (true) {
                System.out.print("Enter message for client (type 'exit' to quit): ");
                String msg = sc.nextLine();

                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }

                byte[] sendData = msg.getBytes();
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, clientAddress, CLIENT_PORT);

                serverSocket.send(sendPacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}