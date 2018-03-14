package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class User extends Model {

    public String email;
    public String password;
    public String firstName;
    public String lastName;

}
