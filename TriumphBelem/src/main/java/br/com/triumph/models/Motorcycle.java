package br.com.triumph.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "motorcycles")
public class Motorcycle {

    @Id   //ATRIBUTOS DO OBJETO SAO PRIVADOS, CASO QUEIRAMOS COLOCAR ALGUMA CARACTERISTICA FIXA
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motorcycle_id")
    private Integer id;
    @Column(name = "motorcycle_name")
    private String name;
    @Column(name = "motorcycle_model")
    private String model;
    @Column(name = "motorcycle_price")
    private Double price;
    @Column(name = "motorcycle_discount")
    private Double discount;
    @Column(name = "motorcycle_total")
    private Integer total;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getId() { //GETTERS AND SETTERS SAO PUBLICOS
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

   public List<Reserve> getListReserve() {
       return reserve;
   }

   public void setListReserve(List<Reserve> listReserve) {
        this.reserve = listReserve;
   }

    @ManyToOne //sempre o ultimo atributo de entidade
    @JoinColumn(name = "engine_fk")
    private Engine engine;

    @ManyToMany
    @JoinTable(name = "reserves_motorcycles",
            joinColumns = @JoinColumn(name = "motorcycle_fk"),
           inverseJoinColumns = @JoinColumn(name = "reserve_fk"))
    private List<Reserve> reserve;

}
