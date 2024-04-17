package server;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.InterfazDeServer;
public class RunServer {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		try {
			// TODO Auto-generated method stub
			InterfazDeServer s = new ServerImpl();
			Registry r = LocateRegistry.createRegistry(1099);
			r.bind("Server", s);
			System.out.println("Servidor inicializado");	
		} catch (Exception e) {
			System.err.println("Excepción del Servidor:: " + e.toString());
			e.printStackTrace();
		}
		System.out.println("Servidor detenido");

	}

}
