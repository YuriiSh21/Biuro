package com.tour.dao;

import com.tour.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Client> getAllClients() {

        Session session = sessionFactory.getCurrentSession();
        List<Client> allClients = session.createQuery("from Client", Client.class)
                .getResultList();

        return allClients;
    }

    @Override
    public void saveClient(Client client) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(client);

    }

    @Override
    public Client getClient(int id) {

        Session session = sessionFactory.getCurrentSession();

        Client client = session.get(Client.class, id);
        return client;
    }

    @Override
    public void deleteClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Client> query = session.createQuery("delete from Client " +
                "where id =:clientId");
        query.setParameter("clientId", id);
        query.executeUpdate();
    }
}
