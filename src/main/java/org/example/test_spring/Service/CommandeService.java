package org.example.test_spring.Service;

import jakarta.transaction.Transactional;
import org.example.test_spring.Bean.Commande;
import org.example.test_spring.Dao.CommandeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeDAO commandeDAO;

    public int save(Commande commande) {
        if (findByRef(commande.getRef()) != null) {
            return -1;
        } else if (commande.getTotalPayer() > commande.getTotal()) {
            return -1;
        }
        commandeDAO.save(commande);
        return 1;
    }

    public int payer(String ref, double montant) {
        Commande commande = findByRef(ref);
        if (commande == null) {
            return -1;
        } else if (commande.getTotalPayer() + montant > commande.getTotal()) {
            return -2;
        }
        commande.setTotalPayer(commande.getTotalPayer() + montant);
        commandeDAO.save(commande);
        return 1;
    }

    public Commande getReferenceById(long id) {
        return commandeDAO.getReferenceById(id);
    }

    public long count() {
        return commandeDAO.count();
    }
    @Transactional
    public void deleteByRef(String ref) {
        Commande commande = commandeDAO.findByRef(ref);
        if (commande != null && commande.getTotalPayer()== commande.getTotal()) {
            commandeDAO.delete(commande);
        }
    }
    @Transactional
    public void deleteAll() {
        commandeDAO.deleteAll();
    }

    public List<Commande> findAll() {
        return commandeDAO.findAll();
    }

    public Commande findByRef(String ref) {
        return commandeDAO.findByRef(ref);
    }
}
