package com.pvt.tracker.beans;

import com.pvt.tracker.beans.enums.UserType;

import javax.persistence.*;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */

@Entity
@Table (name="user_profile", catalog = "tracker")
public class UserProfile {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="type", length=15, unique=true, nullable=false)
    private String type = UserType.ADMIN.getType();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)id;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserProfile))
            return false;
        UserProfile other = (UserProfile) obj;
        if (id != other.id)
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserProfile [id=" + id + ",  type=" + type	+ "]";
    }

}
