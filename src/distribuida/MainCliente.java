package distribuida;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class MainCliente {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("localhost");

            ServerInterface stub = (ServerInterface) registry.lookup("Server");
            stub.addPersona(new Persona("Cristobal", 3));
            System.out.println("Persona añadida al servidor");
            ArrayList<Persona> ps = stub.getPersonas();
            System.out.print("[");
            for (Persona p : ps) {
            	System.out.print(p);
            }
            System.out.println("]");
        } catch (RemoteException e) {
        	e.printStackTrace();
        	System.out.println("Error:: No se pudo establecer la conexión al servidor");
        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}