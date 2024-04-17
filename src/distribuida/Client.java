package distribuida;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
		Registry r = LocateRegistry.getRegistry("localhost");
		ServerInterface stub = (ServerInterface) r.lookup("Server");
		stub.addPersona(new Persona("Juan", 30));
	}

}
