package isaac.challenge3;

public class jugador {
    public char tiro;// Jugar con X o con O.
    public String name;

    public char getTiro() {
        return tiro;
    }
    public void setTiro(char tiro) {
        this.tiro = tiro;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void JugadorRe(char t, String n) {
        name = n; tiro = t;
    }

}
