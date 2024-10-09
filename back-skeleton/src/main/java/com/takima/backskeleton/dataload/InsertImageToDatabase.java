package com.takima.backskeleton.dataload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InsertImageToDatabase {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/db_java";
        String user = "root";
        String password = "root";

        Connection connection = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtt = null;


        String[] imagePaths = {

                "back-skeleton/assets_image/guerre1.png",
                "back-skeleton/assets_image/guerre2.png",
                "back-skeleton/assets_image/guerrecor.png",
                "back-skeleton/assets_image/guerreviet.png",
                "back-skeleton/assets_image/mario galaxy.png",
                "back-skeleton/assets_image/mario kart.png",
                "back-skeleton/assets_image/mariobroswander.png",
                "back-skeleton/assets_image/supermarionewbros.png",
                "back-skeleton/assets_image/pain_seigle.png",
                "back-skeleton/assets_image/painCouronne_bordelaise.png",
                "back-skeleton/assets_image/paincouronnelyonnaise.png",
                "back-skeleton/assets_image/painlevain.png",
                "back-skeleton/assets_image/painmeteil.png",
                "back-skeleton/assets_image/takima.png",
                "back-skeleton/assets_image/capgemini.png",
                "back-skeleton/assets_image/jeux_olympique.png",
                "back-skeleton/assets_image/sopra.png"
        };

        String[] descriptions = {
              "1 ére guerre mondiale", "2 éme guerre mondiale", "guerre corée", "guerre vietnam",
                "Mario galaxy", "mario kart", "mario bros wander", "New Super Mario Bros", "pain de seigle", "Pain couronne bordelaise",
                "Pain couronne lyonnaise", "pain au levain", "pain méteil", "Takima", "Capgemini","jeux olympique", "Sopra Steria"
        };

        try {
            // Connexion à la base de données
            connection = DriverManager.getConnection(url, user, password);

            // Requête d'insertion SQL
            String sql = "INSERT INTO choix (id, categorie_id, description, image) VALUES (?, ?, ?, ?)";
            String sql_categorie = "INSERT INTO categorie (id, nom_categorie) VALUES (?, ?)";

            pstmtt = connection.prepareStatement(sql_categorie);
            pstmtt.setInt(1, 1);  // ID de catégorie
            pstmtt.setString(2, "Guerre");
            pstmtt.executeUpdate();
            pstmtt.setInt(1, 2);  // ID de catégorie
            pstmtt.setString(2, "Mario");
            pstmtt.executeUpdate();
            pstmtt.setInt(1, 3);  // ID de catégorie
            pstmtt.setString(2, "Pain");
            pstmtt.executeUpdate();
            pstmtt.setInt(1, 4);  // ID de catégorie
            pstmtt.setString(2, "Logo");
            pstmtt.executeUpdate();
            pstmt = connection.prepareStatement(sql);

            for (int i = 0; i < 17; i++) {
                pstmt.setInt(1, i + 1);

                int categoryId =0;
                if (i > 0 && i <= 3) {  // Images de pain (index 8 à 12)
                    categoryId = 1;
                } else if (i > 3 && i <= 7 ) {
                    categoryId = 2;
                } else if (i > 7 && i <= 12 ) {  // Images de Mario (index 5 à 7 et 14)
                    categoryId = 3;
                }  else if (i > 12  ) {  // Images de Mario (index 5 à 7 et 14)
                    categoryId = 4;
                }

                pstmt.setInt(2, categoryId);  // ID de catégorie
                pstmt.setString(3, descriptions[i]);  // Description correspondante

                // Chargement de l'image depuis le fichier
                File image = new File(imagePaths[i]);
                FileInputStream fis = new FileInputStream(image);
                pstmt.setBinaryStream(4, fis, (int) image.length());

                // Exécution de l'insertion
                pstmt.executeUpdate();
                fis.close();  // Fermer le FileInputStream après chaque insertion
                System.out.println("Image " + (i + 1) + " insérée avec succès.");
            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
