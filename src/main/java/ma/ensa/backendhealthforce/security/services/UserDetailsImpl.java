package ma.ensa.backendhealthforce.security.services;

import ma.ensa.backendhealthforce.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;
  private Long id;
  private  String username;
  private  String telephone;
  private  String genre;
  private Date date;
  private String email;

  @JsonIgnore
  private String password;


  public UserDetailsImpl(Long id, String username, String telephone, String genre, Date date, String email, String password) {
    this.id = id;
    this.username = username;
    this.telephone = telephone;
    this.genre = genre;
    this.date = date;
    this.email = email;
    this.password = password;

  }

  public static UserDetailsImpl build(User user) {


    return new UserDetailsImpl(
        user.getId(), 
        user.getUsername(),
        user.getTelephone(),
        user.getGenre(),
        user.getDate(),
        user.getEmail(),
        user.getPassword());
  }



  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }


  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
