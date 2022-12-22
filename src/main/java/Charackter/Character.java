package Charackter;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Set;

public class Character implements Serializable {
    private int id, maxHp,shield, ad, cdr, hp, ap;
    private String klasse, name, description;
    private BufferedImage img;
    private Set<Ability> abilitys;

    public Character() {

    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getCdr() {
        return cdr;
    }

    public void setCdr(int cdr) {
        this.cdr = cdr;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ability> getAbilitys() {
        return abilitys;
    }

    public void setAbilitys(Set<Ability> abilitys) {
        this.abilitys = abilitys;
    }
}
