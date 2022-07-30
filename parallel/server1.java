package parallel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import static parallel.server1.serverscreen;
public class server1 extends javax.swing.JFrame {
    
    // Vector to store active clients
    static Vector<ClientHandler> ar = new Vector<>();
	
    // counter for clients
    static int i = 1;
    public server1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        serverscreen = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("server");

        serverscreen.setColumns(20);
        serverscreen.setRows(5);
        jScrollPane1.setViewportView(serverscreen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
	// counter for clients

	public static void main(String[] args) throws IOException
	{
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new server1().setVisible(true);
            }
        });
		// server is listening on port 1234
		ServerSocket ss = new ServerSocket(1234);
		Socket s;

		// running infinite loop for getting
		// client request
		while (true)
		{
			// Accept the incoming request
			s = ss.accept();

			serverscreen.append("New client request received : " + s+"\n");
			
			// obtain input and output streams
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			serverscreen.append("Creating a new handler for this client...\n");

			// Create a new handler object for handling this request.
                        //mmkn nktb arqam zy credit card
                        
			ClientHandler mtch = new ClientHandler(s,"client" + i,"pass"+i, dis, dos);

			// Create a new Thread with this object.
			Thread t = new Thread(mtch);
			
			serverscreen.append("Adding this client to active client list\n");

			// add this client to active clients list
			ar.add(mtch);

			// start the thread.
			t.start();

			// increment i for new client.
			// i is used for naming only, and can be replaced
			// by any naming scheme
			i++;

		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea serverscreen;
    // End of variables declaration//GEN-END:variables
}
// ClientHandler class
class ClientHandler implements Runnable
{
	Scanner scn = new Scanner(System.in);
	private String name;
        private String pass;

	final DataInputStream dis;
	final DataOutputStream dos;
	Socket s;
	boolean isloggedin;
	int balance=5000;
        int money=0;
        int tbalance=0;
        String tname;
	// constructor
	public ClientHandler(Socket s, String name,String pass,DataInputStream dis, DataOutputStream dos) {
		this.dis = dis;
		this.dos = dos;
                this.pass=pass;
		this.name = name;
		this.s = s;
		this.isloggedin=true;
	}

	@Override
	public void run() {

		String received;
		while (true)
		{
			try
			{
				// receive the string 
				received = dis.readUTF();
				
				serverscreen.append(received + "\n");
				
				if(received.equals("logout")){
					this.isloggedin=false;
					this.s.close();
					break;
				}
                                
				// break the string into message and recipient part 
				StringTokenizer st = new StringTokenizer(received, " ");
		
                                  String oper = st.nextToken();
                                  String str1 = st.nextToken();
                                  String str2 = st.nextToken();
    				  String amount=st.nextToken();
                                  String recipient = st.nextToken();
                                 
                                for (ClientHandler mc : server1.ar)
				{
					// if the recipient is found, write on its
					// output stream
                                    if (oper.equals("login") && mc.isloggedin==true )
					{
                                            if (("karim".equals(str1) && "1".equals(str2)) && "1".equals(recipient))
                                            {
                                                dos.writeUTF("Login success");
                                            }
                                            else if (("joya".equals(str1) && "2".equals(str2)) && "2".equals(recipient))
                                            {
                                                dos.writeUTF("Login success");
                                            }
                                            else if (("bob".equals(str1) && "3".equals(str2)) && "3".equals(recipient))
                                            {
                                                dos.writeUTF("Login success");
                                            }
                                            else
                                            {
                                                dos.writeUTF("Login failed");
                                            }
                                        }
                                    if (oper.equals("withdraw") && mc.isloggedin==true )
					{
                                          money=Integer.parseInt(amount);
                                          if((money == 0))
                                          {       
                                            dos.writeUTF("ENTER AMOUNT TO WITHDRAW ");
                                          }
                                          else if (balance>=money) 
                                          {      
                                              if (money<=7000) 
                                              {    
                                                balance-=money;
                                                System.out.println(mc);
                                                System.out.println(server1.ar);
						dos.writeUTF("Withdraw Success ");
						break;
                                              }
                                              else
                                              {
                                    		dos.writeUTF("Withdraw Failed maximum amount is 7000 per day ");
                                              }
                                          }
                                          else
                                          {
                                    	        dos.writeUTF("Insufficient Balance ");
                                          }
                                        }
                                   
                                        if (oper.equals("deposit") && mc.isloggedin==true)
					{
                                         money=Integer.parseInt(amount);
                                         if (money != 0)
                                         {
                                            balance+=money;
                                            System.out.println(mc);
                                            System.out.println(server1.ar);
					    dos.writeUTF("Deposit Success ");
					    break;
                                         }
                                         else
                                         {
                                            dos.writeUTF("ENTER AMOUNT TO DEPOSIT ");
                                         }
					}
                                        
                                        if (oper.equals("checkbalance") && mc.isloggedin==true)
					{
					    dos.writeUTF("Your Balance is : "+balance);
					    break;
					}
                                        
                                        if (oper.equals("transfer") && mc.name.equals(recipient) && mc.isloggedin==true)
					{      
                                                money=Integer.parseInt(amount);

                                                if (balance<=money) 
                                                {
                                                 dos.writeUTF("Insufficient Balance to transfer ");
                                                }
                                                else
                                                {
                                                  if((money == 0))
                                                  {
                                                     dos.writeUTF("Enter amount to transfer  ");
                                                  }
                                                  else
                                                  {
                                                     balance = balance-money;
                                                     mc.balance=mc.balance+money;
						     mc.dos.writeUTF(this.name+" : trans amount to u : "+amount);
                                                     dos.writeUTF("Your Balance is : "+balance);
						     break;
                                                  }
                                                }
					}
                                        if (oper.equals("paybill") && mc.isloggedin==true )
					{
                                             money=Integer.parseInt(amount); 
                                            if((money == 0))
                                            {       
                                            dos.writeUTF("ENTER AMOUNT OF BILL ");
                                            }
                                            else
                                            {
                                              Random billcode = new Random();
                                              int billcode_int = billcode.nextInt(5000);
                                                
                                              if (money<=balance)
                                              { 
                                               balance-=money;
                                               System.out.println(mc);
                                               System.out.println(server1.ar);
				               dos.writeUTF("the bill with code "+billcode_int+" that costs "+money +"is paid Successfully");
					       break;
                                              }
                                              else
                                              {
                                    	       dos.writeUTF("Insufficient Balance");
                                              }
                                            }
                                           
					}
                                }
			}
                        catch (IOException e)
                        {	
			   e.printStackTrace();
			}
		}
		try
		{
			// closing resources
			this.dis.close();
			this.dos.close();
			
		}
                catch(IOException e)
                {
			e.printStackTrace();
		}
                
	}
}