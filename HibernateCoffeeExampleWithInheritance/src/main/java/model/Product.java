/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "products")
public class Product {

    private int idProd;
    private String country;
    private EuropeanCode eu;

    public Product() {
    }
    
    public Product(int id_prod, String country, EuropeanCode eu) {
        this.idProd = id_prod;
        this.country = country;
        this.eu = eu;
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name = "id_prod", nullable = false)
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @ManyToOne
    @JoinColumn(name="FirstDig", referencedColumnName = "FirstDig", nullable=false)
    public EuropeanCode getEu() {
        return eu;
    }

    public void setEu(EuropeanCode eu) {
        this.eu = eu;
    }

    @Override
    public String toString() {
        return "Product{" + "id_prod=" + idProd + ", country=" + country + ", eu=" + eu + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getIdProd() == product.getIdProd() &&
                Objects.equals(getCountry(), product.getCountry()) &&
                Objects.equals(getEu(), product.getEu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProd(), getCountry(), getEu());
    }
}