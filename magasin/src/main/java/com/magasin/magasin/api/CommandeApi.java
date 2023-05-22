package com.magasin.magasin.api;

import com.magasin.magasin.api.dto.CommandeDto;
import com.magasin.magasin.mapping.CommandeMapper;
import com.magasin.magasin.model.Commande;
import com.magasin.magasin.service.CommandeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeApi {
    private final CommandeService commandeService;
    private final CommandeMapper commandeMapper;

    public CommandeApi(CommandeService commandeService, CommandeMapper commandeMapper) {
        this.commandeService = commandeService;
        this.commandeMapper = commandeMapper;
    }
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Commande> getAllCommandes() {
        List<Commande> commandes = commandeService.getAllCommandes();
        return commandes;
    }
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CommandeDto getCommandeById(@PathVariable("id") Integer id) {
        Commande commande = commandeService.getById(id);
        return commandeMapper.toDTO(commande);
    }
}
