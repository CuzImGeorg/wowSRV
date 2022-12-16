package Charackter;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Character implements Serializable {
    private int id, maxHp,shield, ad, cdr, hp;
    private String klasse, name;
    private BufferedImage img;

    private Abillity[] abillities = new Abillity[5];

    public Character(int id, int maxHp, int shield, int ad, int cdr, String klasse, String name, Abillity[] abillities, BufferedImage img) {
        this.id = id;
        this.maxHp = maxHp;
        this.shield = shield;
        this.ad = ad;
        this.cdr = cdr;
        this.klasse = klasse;
        this.name = name;
        this.abillities = abillities;
        this.img = img;

    }

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

    public Abillity[] getAbillities() {
        return abillities;
    }

    public void setAbillities(Abillity[] abillities) {
        this.abillities = abillities;
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
}
