package Character;

import java.io.Serial;
import java.io.Serializable;

public class Settings implements Serializable {

    private int id,ability1, ability2,ability3,ability4, userid;

    @Serial
    private static final long serialVersionUID = 6529685098267757690L;

    public Settings() {
    }

    public Settings(int ability1, int ability2, int ability3, int ability4, int userid) {
        this.ability1 = ability1;
        this.ability2 = ability2;
        this.ability3 = ability3;
        this.ability4 = ability4;
        this.userid = userid;
    }

    public int getAbility1() {
        return ability1;
    }

    public void setAbility1(int ability1) {
        this.ability1 = ability1;
    }

    public int getAbility2() {
        return ability2;
    }

    public void setAbility2(int ability2) {
        this.ability2 = ability2;
    }

    public int getAbility3() {
        return ability3;
    }

    public void setAbility3(int ability3) {
        this.ability3 = ability3;
    }

    public int getAbility4() {
        return ability4;
    }

    public void setAbility4(int ability4) {
        this.ability4 = ability4;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
