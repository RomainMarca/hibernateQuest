package com.wildcodeschool.example.AtelierHibernate.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.wildcodeschool.example.AtelierHibernate.entities.User;
import com.wildcodeschool.example.AtelierHibernate.repositories.UserRepositories;;

@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("romain");

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + userRepositories.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        User user2 = new User("Ayanami", "Rei", "EVA00");
        LOG.info("******************");
        LOG.info(user2 + " has been created !");
        userRepositories.save(user2);
        LOG.info(user2 + " has been saved !");
        
     // Crée un nouvel utilisateur et l'enregistre dans la BDD
        User user3 = new User("Langley", "Asuka", "EVA02");
        LOG.info("******************");
        LOG.info(user3 + " has been created !");
        userRepositories.save(user3);
        LOG.info(user3 + " has been saved !");
        
        
     // Lit les informations correspondant au second utilisateur
        User tempUser = userRepositories.findById(2L).get(); /* On écrit "2L" car 
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Second user's firstName is " + tempUser.getFirstName());
        LOG.info("Second user's lastName is " + tempUser.getLastName());
        LOG.info("Second user's age is " + tempUser.getPilot());
        
        
     // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(User myUser : userRepositories.findAll()) {
            LOG.info(myUser.toString());
        };
        
        // Supprime le second utilisateur de la BDD
        userRepositories.deleteById(2L); /* risque de provoquer une erreur si 
                                tu n'as pas vidé ta table avant de relancer 
                                ton application ! */

        /*     Liste les utilisateurs enregistrés dans la BDD
             (permet de vérifier que le second utilisateur
             a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(User myUser : userRepositories.findAll()) {
            LOG.info(myUser.toString());
        };
    }    
}