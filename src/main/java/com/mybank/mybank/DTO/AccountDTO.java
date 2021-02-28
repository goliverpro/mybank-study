package com.mybank.mybank.DTO;

import com.mybank.mybank.domain.Account;
//import com.mybank.mybank.domain.Client;

import java.io.Serializable;


public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String typeAccount;
    private Double balance;
    private Double boundary;

    //private Client client;

    public AccountDTO(){

    }

    public AccountDTO(Long id, String typeAccount, Double balance, Double boundary) {
        this.id = id;
        this.typeAccount = typeAccount;
        this.balance = balance;
        this.boundary = boundary;
    }

    public AccountDTO(Account obj){
        setId(obj.getId());
        setTypeAccount(obj.getTypeAccount());
        setBalance(obj.getBalance());
        setBoundary(obj.getBoundary());
        //setClient(obj.getClient());
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTypeAccount() {

        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {

        this.typeAccount = typeAccount;
    }

    public Double getBalance() {

        return balance;
    }

    public void setBalance(Double balance) {

        this.balance = balance;
    }

    public Double getBoundary() {

        return boundary;
    }

    public void setBoundary(Double boundary) {

        this.boundary = boundary;
    }

    /*public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }*/
}
