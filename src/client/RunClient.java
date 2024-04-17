package client;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import common.Persona;
import common.InterfazDeServer;

public class RunClient {
    private static void interfaz(InterfazDeServer s) {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Ingrese (1) para crear una persona, (2) para mostrar personas, o (3) para salir:");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Ingrese el nombre de la persona:");
                        String name = scanner.next();
                        System.out.println("Ingrese la edad de la persona:");
                        int age = scanner.nextInt();
                        Persona newPerson = new Persona(name, age);
                        s.addPersona(newPerson);
                        break;
                    case 2:
                        ArrayList<Persona> persons = s.getPersonas();
                        for (Persona person : persons) {
                            System.out.println(person.toString());
                        }
                        break;
                    case 3:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Elección inválida. Por favor ingrese 1, 2, o 3.");
                        break;
                }
            }
        } catch (RemoteException e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("localhost");

            InterfazDeServer stub = (InterfazDeServer) registry.lookup("Server");
            interfaz(stub);
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("Error:: No se pudo establecer la conexión al servidor");
        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}