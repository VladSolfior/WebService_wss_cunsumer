package com.vladapps.fmanager.model;

import org.hibernate.Hibernate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity implements Persistable<Long> {

    public static final int START_SEQ = 100000;

    @Id
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected BaseEntity() {
    }

    protected BaseEntity(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return (getId() == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().intValue() : 0;
    }


    @Override
    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), getId());
    }
}