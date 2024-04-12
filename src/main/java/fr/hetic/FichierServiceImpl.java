package fr.hetic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FichierServiceImpl implements FichierService {

    public List<FileData> getFichiers() {
        Map<Integer, FileData> fichierMap = new HashMap<>();

        String query = "SELECT * FROM FICHIER F INNER JOIN LIGNE L ON F.ID = L.FICHIER_ID AND F.TYPE = 'OP' ORDER BY F.ID, L.POSITION ASC";

        try (
            Connection connexion = DatabaseConnection.getConnection();
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int fichierId = resultSet.getInt("ID");
                String nom = resultSet.getString("NOM");
                String type = resultSet.getString("TYPE");

                FileData fileData = fichierMap.getOrDefault(fichierId, new FileData());

                if (fileData.getFichier() == null) {
                    Fichier fichier = new Fichier(fichierId, nom, type);
                    fileData.setFichier(fichier);
                }

                int ligneId = resultSet.getInt("ID");
                int param1 = resultSet.getInt("PARAM1");
                int param2 = resultSet.getInt("PARAM2");
                String operateurStr = resultSet.getString("OPERATEUR");
                char operateur = (operateurStr != null && !operateurStr.isEmpty()) ? operateurStr.charAt(0) : ' ';
                int position = resultSet.getInt("POSITION");

                Ligne ligne = new Ligne(ligneId, param1, param2, operateur, position, fichierId);
                fileData.getLignes().add(ligne);

                fichierMap.put(fichierId, fileData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(fichierMap.values());
    }
}