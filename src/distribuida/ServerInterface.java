package distribuida;
import java.rmi.*;
import java.util.ArrayList;
import java.util.Iterator;


public interface ServerInterface extends Remote {
	int addPersona(Persona p) throws RemoteException;
	ArrayList<Persona> getPersonas() throws RemoteException;	
}
