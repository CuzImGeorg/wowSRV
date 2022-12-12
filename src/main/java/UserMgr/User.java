package UserMgr;

public class User {
    private String username, password, description, status;
    private int level, xp;
    private String lastlogon, createdate;

    public User(String username, String password, String description, String status, int level, int xp, String lastlogon, String createdate) {
        this.username = username;
        this.password = password;
        this.description = description;
        this.status = status;
        this.level = level;
        this.xp = xp;
        this.lastlogon = lastlogon;
        this.createdate = createdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getLastlogon() {
        return lastlogon;
    }

    public void setLastlogon(String lastlogon) {
        this.lastlogon = lastlogon;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
