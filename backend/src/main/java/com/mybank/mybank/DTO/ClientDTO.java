package com.mybank.mybank.DTO;


import com.mybank.mybank.domain.Account;
import com.mybank.mybank.domain.Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private String login;

    private String name;
    private String document;
    private Date birthDate;
    private String cellPhone;
    private String clientPassword;

    private List<AccountDTO> account = new ArrayList<>();

    public ClientDTO(){

    }

    public ClientDTO(String login, String name, String document, Date birthDate, String cellPhone, String clientPassword) {
        this.login = login;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.cellPhone = cellPhone;
        this.clientPassword = clientPassword;
    }

    public ClientDTO(Client obj){
        setLogin(obj.getLogin());
        setName(obj.getName());
        setDocument(obj.getDocument());
        setBirthDate(obj.getBirthDate());
        setCellPhone(obj.getCellPhone());
        setClientPassword(obj.getClientPassword());
        account = obj.getAccount().stream().map(x -> new AccountDTO(x)).collect(Collectors.toList());
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

    public List<AccountDTO> getAccount() {
        return account;
    }

}
