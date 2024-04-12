package fr.hetic;

import java.io.*;

public class CalculateurFichier implements Reader {
    @Override
    public void read(String folderName) throws FileNotFoundException {
        CalculateurFactory calculateurFactory = new CalculateurFactory();

        File dossier = new File(folderName);
        File[] fichiers = dossier.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".op");
            }
        });

        if (fichiers == null) {
            System.out.println("Le dossier est vide");
            return;
        }

        for (File fichier : fichiers) {
            PrintWriter writer = new PrintWriter(folderName + "/" + fichier.getName().replace(".op", ".res"));

            try {
                BufferedReader reader = new BufferedReader(new FileReader(fichier));
                String ligne = reader.readLine();
                while (ligne != null) {
                    String[] elements = ligne.split(" ");
                    writer.println(calculateurFactory.calculFichier(elements[0], elements[1], elements[2]));

                    ligne = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        }
    }
}