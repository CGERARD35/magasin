package com.magasin.magasin.service.impl;

import com.magasin.magasin.model.Article;
import com.magasin.magasin.model.Commande;
import com.magasin.magasin.repository.ArticleRepository;
import com.magasin.magasin.repository.CommandeRepository;
import com.magasin.magasin.service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {

    private CommandeRepository commandeRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public void CommandeService(CommandeRepository commandeRepository, ArticleRepository articleRepository) {
        this.commandeRepository = commandeRepository;
        this.articleRepository = articleRepository;
    }
    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
    @Override
    public Commande getById(Integer id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La commande n'a pas été trouvée: " + id));
    }
    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }
    @Override
    public Commande updateCommande(Integer id, Commande updatedCommande) {
        Commande existingCommande = getById(id);
        existingCommande.setArticle(updatedCommande.getArticle());
        return commandeRepository.save(existingCommande);
    }
    @Override
    public void deleteCommande(Integer id) {
        commandeRepository.deleteById(id);
    }
    @Override
    public Commande ajouterArticleACommande(Integer commandeId, Integer articleId) {
        Commande commande = getById(commandeId);
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("L'article n'a pas été trouvé: " + articleId));
        article.setCommande(commande);
        return commandeRepository.save(commande);
    }

}
