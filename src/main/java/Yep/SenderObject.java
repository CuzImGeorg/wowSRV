package Yep;

import java.io.Serializable;

public class SenderObject  implements Serializable {
    private Instruction instruction;
    private User user;

    public Instruction getInstruction() {
        return instruction;
    }

    public SenderObject(Instruction instruction) {
        this.instruction = instruction;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
