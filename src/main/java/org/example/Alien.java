package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
//@Table(name = "alien_table")
public class Alien {
    @Id
    private int aId;
    //@Transient
    private AlienName aName;
    //@Column(name = "alien_color")
    private String color;
    @ManyToMany
    private List<Laptop> laptops=new ArrayList<>();

    public List<Laptop> getLaptop() {
        return laptops;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptops = laptops;
    }

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

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName=" + aName +
                ", color='" + color + '\'' +
                ", laptop=" + laptops +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }


}
