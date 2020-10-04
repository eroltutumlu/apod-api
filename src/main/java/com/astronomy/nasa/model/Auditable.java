package com.astronomy.nasa.model;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> implements Serializable {

    private static final long serialVersionUID = -8027746305948051121L;

    @CreatedBy
    @Column(updatable = false)
    protected U createdBy;
    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date creationDate;
    @LastModifiedBy
    protected U lastModifiedBy;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;

    protected Boolean isDeleted;

    public Boolean getDeleted() {
        return isDeleted;
    }

    public U getCreatedBy() {
        return createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Auditable{" +
                "createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", lastModifiedDate=" + lastModifiedDate +
                ", isDeleted=" + isDeleted +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditable<?> auditable = (Auditable<?>) o;
        return createdBy.equals(auditable.createdBy) &&
                Objects.equals(creationDate, auditable.creationDate) &&
                Objects.equals(lastModifiedBy, auditable.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, auditable.lastModifiedDate) &&
                Objects.equals(isDeleted, auditable.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, creationDate, lastModifiedBy, lastModifiedDate, isDeleted);
    }
}
