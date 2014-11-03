package models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by rafaganabreu on 26/10/14.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Login {
    protected int idLogin;
    protected String email;
    protected Date createdAt;
    protected Date updatedAt;
    protected java.util.Date lastLoginAt;
    protected String passwordHash;
    protected String salt;

    @Id
    @Column(name = "idLogin", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getIdLogin() {return idLogin;}
    public void setIdLogin(int idLogin) {this.idLogin = idLogin;}

    @Basic
    @Column(name = "Email", nullable = true, insertable = true, updatable = true, length = 255)
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @Basic
    @Column(name = "CreatedAt", nullable = false, insertable = true, updatable = true)
    public Date getCreatedAt() {return createdAt;}
    public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}

    @Basic
    @Column(name = "UpdatedAt", nullable = false, insertable = true, updatable = true)
    public Date getUpdatedAt() {return updatedAt;}
    public void setUpdatedAt(Date updatedAt) {this.updatedAt = updatedAt;}

    @Basic
    @Column(name = "LastLoginAt", nullable = false, insertable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getLastLoginAt() {return lastLoginAt;}
    public void setLastLoginAt(java.util.Date lastLoginAt) {this.lastLoginAt = lastLoginAt;}

    @Basic
    @Column(name = "PasswordHash", nullable = false, insertable = true, updatable = true, length = 64)
    public String getPasswordHash() {return passwordHash;}
    public void setPasswordHash(String passwordHash) {this.passwordHash = passwordHash;}

    @Basic
    @Column(name = "Salt", nullable = false, insertable = true, updatable = true, length = 64)
    public String getSalt() {return passwordHash;}
    public void setSalt(String salt) {this.salt = salt;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login = (Login) o;
        if (idLogin != login.idLogin) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLogin;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (lastLoginAt != null ? lastLoginAt.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);

        return result;
    }
}
