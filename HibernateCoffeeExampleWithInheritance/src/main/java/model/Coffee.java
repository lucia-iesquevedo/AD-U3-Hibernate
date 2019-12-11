package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "coffees")
@PrimaryKeyJoinColumn(name = "id_coffee")  //From coffee table
public class Coffee extends Product{

    private String cofName;
    private BigDecimal price;
    private int sales;
    private int total;
    private Supplier supplier;

    @Basic
    @Column(name = "COF_NAME", nullable = true, length = 32)
    public String getCofName() {
        return cofName;
    }

    public void setCofName(String cofName) {
        this.cofName = cofName;
    }

    @Basic
    @Column(name = "PRICE", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "SALES", nullable = false)
    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Basic
    @Column(name = "TOTAL", nullable = false)
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @ManyToOne
    @JoinColumn(name = "SUPP_ID", referencedColumnName = "SUPP_ID", nullable = false)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier suppliersBySuppId) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                ", cofName='" + cofName + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", total=" + total +
                '}' + super.toString();
    }
}
