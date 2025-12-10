package terminal;

public class Terminal {
    public final Input in;
    public final Output out;

    public Terminal(){
        this.in = new Input();
        this.out = new Output();
    }

    public Terminal(Input in, Output out) {
        this.in = in;
        this.out = out;
    }
}
