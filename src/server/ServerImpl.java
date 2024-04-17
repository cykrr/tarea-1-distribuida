package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.Persona;
import common.InterfazDeServer;


public class ServerImpl extends UnicastRemoteObject implements InterfazDeServer {
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	private static final long serialVersionUID = -6571982898024384555L;

	public ServerImpl( ) throws RemoteException { 
		super();
	}
	

	public int addPersona(Persona p) {
		this.personas.add(p);
		return 0;
	}
	
	public ArrayList<Persona> getPersonas() {
		return this.personas;
	}

}
