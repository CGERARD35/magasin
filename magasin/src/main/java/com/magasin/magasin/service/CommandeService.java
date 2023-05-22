package com.magasin.magasin.service;

import com.magasin.magasin.model.Commande;

import java.util.List;

public interface CommandeService {

    List<Commande> getAllCommandes();
    Commande getById(Integer id);
    Commande createCommande(Commande commande);
    Commande updateCommande(Integer id, Commande updatedCommande);
    void deleteCommande(Integer id);
    Commande ajouterArticleACommande(Integer commandeId, Integer articleId);
}
