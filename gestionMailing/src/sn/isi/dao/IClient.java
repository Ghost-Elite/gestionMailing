package sn.isi.dao;

import sn.isi.entities.Client;

import java.util.List;

public interface IClient {
    public int add(Client client) throws Exception;
    public int delete(int idClent) throws Exception;
    public int update(Client Client) throws Exception;
    public void recherche(String emailClient) throws Exception;
    public List<Client> getAll() throws Exception;
    public Client get(int idClient) throws Exception;

}
