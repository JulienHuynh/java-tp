package fr.hetic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FileData {
    private Fichier fichier;
    private List<Ligne> lignes = new ArrayList<>();
}
