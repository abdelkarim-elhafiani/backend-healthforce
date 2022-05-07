package ma.ensa.backendhealthforce.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users", 
    uniqueConstraints = {
      @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @NotBlank
  @Size(max = 30)
  private String username;

  @NotBlank
  @Size(max = 30)
  private String telephone;

  @NotBlank
  @Size(max = 10)
  private String genre;


  private Date date;

  @NotBlank
  @Size(max = 70)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;


  public User() {
  }

  public User(String username,String telephone,String genre, Date date, String email, String password) {
    this.username = username;
    this.telephone = telephone;
    this.genre = genre;
    this.email = email;
    this.password = password;
    this.date = date;
  }

  public Long getId() {
    return id;
  }


  public String getUsername() {
    return username;
  }


  public String getTelephone() {
    return telephone;
  }

  public String getGenre() {
    return genre;
  }

  public Date getDate() {
    return date;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }


}
