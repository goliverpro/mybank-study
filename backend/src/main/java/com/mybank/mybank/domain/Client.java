package com.mybank.mybank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    private String login;
    private String name;
    private String document;
    private Date birthDate;
    private String cellPhone;
    private String clientPassword;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Account> account = new ArrayList<>();


    public Client(){

    }

    public Client(String login, String name, String document, Date birthDate, String cellPhone, String clientPassword) {
        this.login = login;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.cellPhone = cellPhone;
        this.clientPassword = clientPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account.add(account);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.clientPassword;
    }

    @Override
    public String getUsername() {
        return this.login;
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
}
