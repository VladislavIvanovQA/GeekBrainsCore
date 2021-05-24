package lesson9;

public class RunningTrack implements Obstaclable {
    int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean toRun(int maxLength) {
        return (maxLength >= length);
    }

    @Override
    public boolean toJump(int maxHeight) {
        return false;
    }

    @Override
    public String toString() {
        return "Беговая дорожка длиной " + length + " м";
    }
}
