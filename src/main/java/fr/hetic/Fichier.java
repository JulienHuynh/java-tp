package fr.hetic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fichier {
    private int id;
    private String nom;
    private String type;
}
