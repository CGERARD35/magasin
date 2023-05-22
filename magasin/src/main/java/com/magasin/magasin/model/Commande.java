package com.magasin.magasin.model;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int quantite;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<Article> article;
}
