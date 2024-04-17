package common;
import java.rmi.*;
import java.util.ArrayList;


public interface InterfazDeServer extends Remote {
	int addPersona(Persona p) throws RemoteException;
	ArrayList<Persona> getPersonas() throws RemoteException;	
}
