// CLient side

import java.io.*;
import java.net.*;

public class TCPC {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 4000);
        System.out.println("Enter the filename");

        // Read file name from user
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        String fname = keyRead.readLine();

        // Get the socket's output stream to send data to server
        OutputStream ostream = socket.getOutputStream();
        // Send file name to server
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(fname);

        // Get the socket's input stream to receive data from server
        InputStream istream = socket.getInputStream();
        // Read the file content sent by server
        BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));

        String str;

        // Display the file content
        while ((str = socketRead.readLine()) != null) {
            System.out.println(str);
        }

        //Cleaning up resources
        pwrite.close();
        socketRead.close();
        keyRead.close();
    }
}