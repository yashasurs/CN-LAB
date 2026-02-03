// UDP Client - receives messages from server

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPC {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (DatagramSocket clientSocket = new DatagramSocket(PORT)) {
            System.out.println("Client is ready to receive messages...");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket =
                        new DatagramPacket(receiveData, receiveData.length);

                clientSocket.receive(receivePacket);

                String message = new String(
                        receivePacket.getData(),
                        0,
                        receivePacket.getLength()
                );

                System.out.println("Server: " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}