import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        String host = "localhost";
        int port = 9999;
        try{
            Socket server = new Socket(host, port);
            System.out.println("Connected to : " + server);

            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            DataInputStream in = new DataInputStream(System.in);

            Author author = new Author("me", 21);
            Book book = new Book("Fish", "Me", author);

            out.writeUTF(Utils.Object2jsonString(book));

            server.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
