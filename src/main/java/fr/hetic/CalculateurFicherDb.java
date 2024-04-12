package fr.hetic;

import java.io.*;
import java.util.List;

public class CalculateurFicherDb {
    public static void main(String[] args) throws FileNotFoundException {
        CalculateurFactory calculateurFactory = new CalculateurFactory();
        FichierService fichierService = new FichierServiceImpl();

        String dossierOp = args[0];
        File dossier = new File(dossierOp);
        dossier.mkdirs();

        List<FileData> fichiers = fichierService.getFichiers();

        for (FileData fichier : fichiers) {
            Fichier fichierData = fichier.getFichier();
            List<Ligne> lignes = fichier.getLignes();

            PrintWriter writer = new PrintWriter(dossierOp + "/" + fichierData.getNom() + ".res");

            try {
                for (Ligne ligne : lignes) {
                    String param1 = String.valueOf(ligne.getParam1());
                    String param2 = String.valueOf(ligne.getParam2());
                    String operateur = String.valueOf(ligne.getOperateur());

                    writer.println(calculateurFactory.calculFichier(param1, param2, operateur));
                }
            } finally {
                writer.close();
            }
        }
    }
}
