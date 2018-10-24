package model;

import javax.persistence.*;

@Entity
@Table(name = "hobbies", schema = "respring2", catalog = "")
public class Hobbies {
    private int id;
    private String hobby;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hobby")
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hobbies that = (Hobbies) o;

        if (id != that.id) return false;
        if (hobby != null ? !hobby.equals(that.hobby) : that.hobby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        return result;
    }
}
