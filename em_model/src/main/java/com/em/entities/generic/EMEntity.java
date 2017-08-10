package com.em.entities.generic;

import org.hibernate.Hibernate;

import java.io.Serializable;

/**
 * Created by jli on 8/6/2017.
 */
public abstract class EMEntity<K extends Serializable & Comparable<K>, E extends EMEntity<K, ?>>
        implements Serializable, Comparable<E> {
    /**
     * Retourne la valeur de l'identifiant unique.
     *
     * @return id
     */
    public abstract K getId();

    /**
     * Définit la valeur de l'identifiant unique.
     *
     * @param id id
     */
    public abstract void setId(K id);

    /**
     * Indique si l'objet a déjà été persisté ou non
     *
     * @return vrai si l'objet n'a pas encore été persisté
     */
    public boolean isNew() {
        return getId() == null;
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }

        if (Hibernate.getClass(object) != Hibernate.getClass(this)) {
            return false;
        }

        EMEntity<K, E> entity = (EMEntity<K, E>) object;
        K id = getId();

        if (id == null) {
            return false;
        }

        return id.equals(entity.getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;

        K id = getId();
        hash = 31 * hash + ((id == null) ? 0 : id.hashCode());

        return hash;
    }

    public int compareTo(E o) {
        if (this == o) {
            return 0;
        }
        return this.getId().compareTo(o.getId());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("entity.");
        builder.append(Hibernate.getClass(this).getSimpleName());
        builder.append("<");
        builder.append(getId());
        builder.append("-");
        builder.append(super.toString());
        builder.append(">");

        return builder.toString();
    }
}
