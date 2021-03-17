package sn.isi.main;

import sn.isi.dao.*;
import sn.isi.entities.Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, Exception, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        IClient clientdao = new ClientImpl();
        String rep = null;

        do {
            System.out.println("=====================Entre votre choix==================*");
            System.out.println("*                     1 : Création                      *");
            System.out.println("*                     2 : Visualisation                 *");
            System.out.println("*                     3 : Edition                       *");
            System.out.println("*                     4 : Recherche                     *");
            System.out.println("*====================*******************================*");
            int nbMenu = Integer.parseInt(sc.nextLine());

            switch (nbMenu) {
                case 1:

                    Client client = new Client();
                    System.out.println("Entre votre nom");
                    client.setNomClient(sc.nextLine());
                    System.out.println("Entre votre prenom");
                    client.setPrenomClient(sc.nextLine());
                    System.out.println("Entre votre email");
                    client.setEmailClient(sc.nextLine());
                    System.out.println("Entre votre numero de telephone");
                    client.setTelClient(sc.nextLine());
                    int ok = clientdao.add(client);
                    break;
                case 2:
                    //Client client1 = new Client();
                    //client1.setIdClient(10);
                    IClient iclient = new ClientImpl();
                    File c = new File("listClient.txt");
                    List<Client> clientList = iclient.getAll();
                    FileWriter fileWriter = new FileWriter(c);
                    fileWriter.write("nomClient;prenomClient;emailClient;telClient");
                    for (Client client3 : clientList) {
                        String cl = client3.getNomClient() + ";" +
                                ";" + client3.getPrenomClient() + ";" +
                                client3.getEmailClient() + ";" + client3.getTelClient();
                        fileWriter.write(cl);
                    }
                    fileWriter.close();
                    System.out.println("fichier creer");
                    //clientdao.getAll();
                    break;
                case 3:
                    Client client1 = new Client();
                    clientdao.update(client1);
                    break;
                case 4:
                    do {
                        Client client2 = new Client();
                        IClient iClient = new ClientImpl();
                        System.out.println("Recherche par email");
                        iClient.recherche(client2.setEmailClient(sc.nextLine()));
                        /* clientdao.recherche(client2.getEmailClient());*/
                        System.out.println("Voulez vous continuer O/N");
                        rep = sc.nextLine();
                    } while (rep.equalsIgnoreCase("o"));
                    break;
                default:
                    System.out.println("choix erroné :(!!!");
            }
            System.out.println("Voulez vous continuer O/N");
            rep = sc.nextLine();
        } while (rep.equalsIgnoreCase("o"));


    }
    /*public static boolean isValid(String email)
    {
        String emailtest = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(email);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }*/
}
