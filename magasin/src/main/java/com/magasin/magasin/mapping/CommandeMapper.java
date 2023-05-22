package com.magasin.magasin.mapping;

import com.magasin.magasin.api.dto.CommandeDto;
import com.magasin.magasin.model.Commande;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CommandeMapper {
    private final ArticleMapper articleMapper;

    public CommandeMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public CommandeDto toDTO(Commande commande) {
        CommandeDto commandeDTO = new CommandeDto();
        commandeDTO.setId(Long.valueOf(commande.getId()));
        commandeDTO.setArticles(commande.getArticle().stream()
                .map(articleMapper::toDTO)
                .collect(Collectors.toList()));
        return commandeDTO;
    }

    public Commande toEntity(CommandeDto commandeDTO) {
        Commande commande = new Commande();
        commande.setId(commandeDTO.getId().intValue());
        commande.setArticle(commandeDTO.getArticles().stream()
                .map(articleMapper::toEntity)
                .collect(Collectors.toList()));
        return commande;
    }
}
