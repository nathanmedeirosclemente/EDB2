public class Reserva {
    int codigo;
    String nome;
    String voo;
    String horarioDePartida; // formato "yyyy-MM-dd'T'HH:mm:ss"

    public Reserva(int codigo, String nome, String voo, String horarioDePartida) {
        this.codigo = codigo;
        this.nome = nome;
        this.voo = voo;
        this.horarioDePartida = horarioDePartida;
    }



    @Override
    public String toString() {
        return "Reserva [Código: " + codigo + ", Nome: " + nome + ", Voo: " + voo + ", Horário: " + horarioDePartida + "]";
    }
}
