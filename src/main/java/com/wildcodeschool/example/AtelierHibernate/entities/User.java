package com.wildcodeschool.example.AtelierHibernate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	public User() {
    }

    public User(String firstName, String lastName, String pilot) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pilot = pilot;
    }
    
    
    @Id
    @GeneratedValue
    private Long id;     /* Le type Long permet de prévoir 
                        le cas où l'id aurait une valeur importante */

    private String firstName;

    private String lastName;

    private String pilot;

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", pilot=" + pilot + "]";
    }            
    /* Permet d'afficher les attributs de l'objet lors de l'invocation 
    de sa méthode toString() */                

    

    public Long getId() {
        return id;
    }

    /* On ne définit pas de setId() car l'id sera généré automatiquement */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }    
}