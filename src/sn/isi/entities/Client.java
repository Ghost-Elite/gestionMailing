package sn.isi.entities;

public class Client {
    //client(id int, nom String, prenom String, email String, tel String)
    private int idClient;
    private String nomClient;
    private String prenomClient;
    private String emailClient;
    private String telClient;
    //private User user = new User();

    public Client() {
    }

    public Client(int idClient, String nomClient, String prenomClient, String emailClient, String telClient) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.emailClient = emailClient;
        this.telClient = telClient;

    }

    public int getIdClient() {
        return idClient;
    }

    public int setIdClient(int idClient) {
        this.idClient = idClient;
        return idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String setNomClient(String nomClient) {
        this.nomClient = nomClient;
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public String setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
        return prenomClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public String setEmailClient(String emailClient) {
        this.emailClient = emailClient;
        return emailClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public String setTelClient(String telClient) {
        this.telClient = telClient;
        return telClient;
    }


}
