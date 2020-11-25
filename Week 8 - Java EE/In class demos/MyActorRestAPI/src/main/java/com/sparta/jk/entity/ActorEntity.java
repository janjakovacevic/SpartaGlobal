package com.sparta.jk.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;

@Entity
@Table(name = "actor", schema = "sakila")
@NamedQueries({
        @NamedQuery(name = "ActorEntity.findAll", query = "SELECT actors FROM ActorEntity actors"),
        @NamedQuery(name = "ActorEntity.findByFirstName", query = "SELECT actors FROM ActorEntity actors WHERE actors.firstName = :firstName"),
        @NamedQuery(name = "ActorEntity.findByLastName", query = "SELECT actors FROM ActorEntity actors WHERE actors.lastName = :lastName")
})
public class ActorEntity {
    private Integer actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "actor_id")
    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorEntity that = (ActorEntity) o;

        if (actorId != null ? !actorId.equals(that.actorId) : that.actorId != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorId != null ? actorId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActorEntity{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
