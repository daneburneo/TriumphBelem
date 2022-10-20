package br.com.triumph.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reserves")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "reserve_id")
    Integer id;
    @Column(name = "reserve_total_price")
    Double price;
    @Column(name = "reserve_date")
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public List<Motorcycle> getListMotorcycles() {
        return listMotorcycles;
    }

    public void setListMotorcycles(List<Motorcycle> listMotorcycle) {
        this.listMotorcycles = listMotorcycle;
    }

    @ManyToMany(mappedBy = "reserve")
    List<Motorcycle> listMotorcycles;

}



