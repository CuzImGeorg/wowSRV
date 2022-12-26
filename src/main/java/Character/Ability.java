package Character;

import java.io.Serial;
import java.io.Serializable;

public class Ability implements Serializable {
    private int id,aid;
    private String name, description;
    private Character charid;

    public Ability() {

    }
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getCharid() {
        return charid;
    }

    public void setCharid(Character charid) {
        this.charid = charid;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "id=" + id +
                ", aid=" + aid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
