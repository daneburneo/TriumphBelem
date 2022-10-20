package br.com.triumph.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "engines")
public class Engine {

    @Id//annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engine_id")
    private Integer id;

    @Column(name = "engine_cc")
    private Integer cc;

    @Column(name = "engine_type")
    private String type;

    @Column(name = "engine_refrigeration")
    private String refrigeration;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefrigeration() {
        return refrigeration;
    }

    public void setRefrigeration(String refrigeration) {
        this.refrigeration = refrigeration;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public List<Motorcycle> getList() {
        return list;
    }

    public void setList(List<Motorcycle> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "engine")
    private List<Motorcycle> list;

}


