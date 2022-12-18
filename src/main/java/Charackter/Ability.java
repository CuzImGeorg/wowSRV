package Charackter;

public class Ability {
    private int id,aid;
    private String name, description;
    private Character charid;

    public Ability() {

    }

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
}
