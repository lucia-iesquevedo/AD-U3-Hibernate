/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "suppliers")
public class Supplier {

    private int supp_id;
    private String street;
    private String town;
    private String country;
    private String pcode;

    public Supplier() {
    }

    public Supplier(int supp_id, String street, String town, String country) {
        this.supp_id = supp_id;
        this.street = street;
        this.town = town;
        this.country = country;
    }

    @Id
    @Column(name = "SUPP_ID")
    public int getSupp_id() {
        return supp_id;
    }

    public void setSupp_id(int supp_id) {
        this.supp_id = supp_id;
    }

    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "PCODE")
    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supp_id=" + supp_id + ", street=" + street + ", town=" + town + ", country=" + country + ", pcode=" + pcode + '}';
    }

    
}