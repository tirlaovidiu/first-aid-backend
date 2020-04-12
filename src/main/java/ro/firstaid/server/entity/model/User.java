package ro.firstaid.server.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private long timeStamp = Calendar.getInstance().getTimeInMillis();

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String sSNumber;

    @Column
    private String phoneNumber;

    @Column
    @Email
    private String email;

    @Column
    private boolean accountExpired;

    @Column
    private boolean accountLocked;

    @Column
    private boolean credentialsExpired;

    @Column
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_AUTHORITIES", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID"))
    @OrderBy
    @JsonIgnore
    private Collection<Authority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired();
    }
}
