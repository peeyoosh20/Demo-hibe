package org.example;

import javax.persistence.*;

@Entity()
@Table(name = "alien_table")
public class Alien {
    @Id
    private int aId;
    //@Transient
    private AlienName aName;
    //@Column(name = "alien_color")
    private String color;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public AlienName getaName() {
        return aName;
    }

    public void setaName(AlienName aName) {
        this.aName = aName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
