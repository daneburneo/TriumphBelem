package br.com.triumph.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id//annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")

    private Integer id;

    @Column(name = "contact_number")
    private Long contact;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public People getPerson() {
        return person;
    }

    public void setPerson(People person) {
        this.person = person;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    @ManyToOne //sempre o ultimo atributo de entidade
    @JoinColumn(name = "person_fk")
    private People person;



}