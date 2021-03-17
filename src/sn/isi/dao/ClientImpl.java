package sn.isi.dao;

import sn.isi.entities.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientImpl implements IClient {
    DB db = new DB();
    Scanner sc = new Scanner(System.in);

    @Override
    public int add(Client client) throws Exception {
        db.open();
        String sql = "INSERT INTO client VALUES(NULL,?,?,?,?)";
        db.init(sql);
        db.getPstm().setString(1, client.getNomClient());
        db.getPstm().setString(2, client.getPrenomClient());
        db.getPstm().setString(3, client.getEmailClient());
        db.getPstm().setString(4, client.getTelClient());
        //db.getPstm().setString(5,client.);
        int ok = db.executeUpdate();
        return ok;
    }
    @Override
    public int delete(int idClient) throws Exception {
        db.open();
        String sql = "Delete from client where idClient = ?";
        db.init(sql);
        db.getPstm().setInt(1, idClient);
        return 0;
    }

    @Override
    public int update(Client Client) throws Exception {
        //Scanner sc = new Scanner(System.in);
        Client client = new Client();
        db.open();
        String sql = "UPDATE client set nomClient = ?,prenomClient = ?,emailClient = ?,telClient = ? where idClient = ?";
        db.init(sql);
        String rep = null;
        int ok;
        do {
            System.out.println("Edition :");
            System.out.println("Entre votre nom");
            db.getPstm().setString(1, Client.setNomClient(sc.nextLine()));
            System.out.println("Entre votre prenom");
            db.getPstm().setString(2, Client.setPrenomClient(sc.nextLine()));
            System.out.println("Entre votre email");
            db.getPstm().setString(3, Client.setEmailClient(sc.nextLine()));
            System.out.println("Entre votre numero de telephone");
            db.getPstm().setString(4, Client.setTelClient(sc.nextLine()));
            System.out.println("Entre l'id");
            db.getPstm().setInt(5, Client.setIdClient(Integer.parseInt(sc.nextLine())));
            ok = db.executeUpdate();
            System.out.println("Voulez vous continuer O/N");
            rep = sc.nextLine();
        } while (rep.equalsIgnoreCase("o"));


        return ok;
    }

    @Override
    public void recherche(String emailClient) throws Exception {
        db.open();
        String sql = "SELECT * from client where emailClient ='" + emailClient + "'";
        db.init(sql);
        Client client = new Client();
        //db.getPstm().setString(1,client.setEmailClient(sc.nextLine()));
        ResultSet res = db.executeSelect();
        res.last();
        int nbr = res.getRow();
        if (nbr != 0) {
            System.out.println(emailClient);
            System.out.println("Nom :  " + res.getString("nomClient"));
            System.out.println("prenom : " + res.getString("prenomClient"));
            System.out.println("email : " + res.getString("emailClient"));
            System.out.println("tel : " + res.getString("telClient"));
            System.out.println("-------------------------\t");
        } else {
            System.out.println("non trouvé");
        }
    }
    @Override
    public List<Client> getAll() throws Exception {
        List<Client> clients = new ArrayList<Client>();
        db.open();
        String sql = "SELECT * from client";
        db.init(sql);
        ResultSet res = db.executeSelect();
        while (res.next()) {
            Client client = new Client();
            client.setIdClient(res.getInt(1));
            client.setNomClient(res.getString(2));
            client.setPrenomClient(res.getString(3));
            client.setEmailClient(res.getString(4));
            client.setTelClient(res.getString(5));
            clients.add(client);
        }
        List<Client> client = new ArrayList<Client>();
        for (Client c : clients) {

            System.out.println("Nom :  " + c.getNomClient());
            System.out.println("prenom : " + c.getPrenomClient());
            System.out.println("email : " + c.getEmailClient());
            System.out.println("tel : " + c.getTelClient());
            System.out.println("-------------------------\t");
        }
        return clients;
    }

    @Override
    public Client get(int idClient) throws Exception {
        Client client = null;
        db.open();
        String sql = "SELECT * from client where idClient = ?";
        db.init(sql);
        db.getPstm().setInt(1, idClient);
        ResultSet res = db.executeSelect();
        if (res.next()) {
            client = new Client();
            client.setIdClient(res.getInt(1));
            client.setNomClient(res.getString(2));
            client.setPrenomClient(res.getString(3));
            client.setEmailClient(res.getString(4));
            client.setTelClient(res.getString(5));
        }
        return client;
    }
}
