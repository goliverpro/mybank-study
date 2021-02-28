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


    private Long id;

    private String name;
    private String document;
    private Date birthDate;
    private String cellPhone;

    private List<AccountDTO> account = new ArrayList<>();

    public ClientDTO(){

    }

    public ClientDTO(Long id, String name, String document, Date birthDate, String cellPhone) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.cellPhone = cellPhone;
    }

    public ClientDTO(Client obj){
        setId(obj.getId());
        setName(obj.getName());
        setDocument(obj.getDocument());
        setBirthDate(obj.getBirthDate());
        setCellPhone(obj.getCellPhone());
        account = obj.getAccount().stream().map(x -> new AccountDTO(x)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<AccountDTO> getAccount() {
        return account;
    }

}
