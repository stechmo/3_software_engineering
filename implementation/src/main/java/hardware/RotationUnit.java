package hardware;

public class RotationUnit {
    private Role role1;
    private Role role2;
    public RotationUnit() {
        this.role1 = new Role();
        this.role2 = new Role();
    }

    public int turn(int angle) {
        this.role1.turn();
        this.role2.turn();
        if (angle >= 270) {
            return 0;
        }
        else {
            return angle + 90;
        }
    }
}
