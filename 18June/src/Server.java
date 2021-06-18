import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        ServerSocket server = null;
        try{
            int port = 9999;
            server = new ServerSocket(port);
            while(true){
                Socket client = server.accept();
                System.out.println("Client accepted on port: " + client);

                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                DataInputStream in = new DataInputStream(client.getInputStream());

                String temp = in.readUTF();
                System.out.println(temp);
                Book book = Utils.jsonString2Object(temp);

                client.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                server.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
