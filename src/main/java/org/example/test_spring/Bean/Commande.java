package org.example.test_spring.Bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String ref ;
    private double total ;
    private double totalPayer ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPayer() {
        return totalPayer;
    }

    public void setTotalPayer(double totalPayer) {
        this.totalPayer = totalPayer;
    }
}


