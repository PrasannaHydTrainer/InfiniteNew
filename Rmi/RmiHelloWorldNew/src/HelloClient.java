import java.rmi.Naming;

public class HelloClient {
	public static void main(String[] args) {
		try
		{
			Hello h = (Hello)Naming.lookup("localhost");
			System.out.println("Client Program");
			System.out.println("Server :  " + h.sayHello());
		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}
	}
}
