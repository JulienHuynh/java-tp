package fr.hetic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ligne {
    private int id;
    private int param1;
    private int param2;
    private char operateur;
    private int position;
    private int fichierId;
}
