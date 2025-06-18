package TPE;

public class Maquina {
    private String name;
    private int piezas;

    public Maquina(String name, int piezas) {
        super();
        this.name = name;
        this.piezas = piezas;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPiezas() {
        return piezas;
    }
    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    @Override
    public String toString() {
        return name + "-" + piezas;
    }
}