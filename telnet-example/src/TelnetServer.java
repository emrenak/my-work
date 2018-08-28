import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


class TelnetServer
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket Soc=new ServerSocket(5217);
        while(true)
        {
            Socket CSoc=Soc.accept();
            DataInputStream din=new DataInputStream(CSoc.getInputStream());
            DataOutputStream dout=new DataOutputStream(CSoc.getOutputStream());
            //System.out.println(din.readUTF());
        }
    }
}