public class Main {
    public static void Main(String[] args) {
        
        // Insercoes
        sistema.inserirReserva(new Reserva(1001, "Alice Silva", "V001", "2024-08-20T15:30:00"));
        sistema.inserirReserva(new Reserva(1002, "Joao Pereira", "V001", "2024-08-20T14:00:00"));
        sistema.inserirReserva(new Reserva(1003, "Maria Costa", "V001", "2024-08-20T15:00:00"));
        sistema.inserirReserva(new Reserva(1004, "Carlos Souza", "V002", "2024-08-21T09:00:00"));
        sistema.inserirReserva(new Reserva(1005, "Beatriz Lima", "V002", "2024-08-21T10:30:00"));
        sistema.inserirReserva(new Reserva(1006, "Fernanda Oliveira", "V001", "2024-08-20T16:00:00"));
        sistema.inserirReserva(new Reserva(1007, "Joaquim Ferreira", "V002", "2024-08-21T10:30:00"));
        sistema.inserirReserva(new Reserva(1008, "Manoel Leao", "V001", "2024-08-20T16:00:00"));
        sistema.inserirReserva(new Reserva(1009, "Jose Carlos", "V002", "2024-08-21T10:30:00"));
        sistema.inserirReserva(new Reserva(1010, "Andre Mateus", "V001", "2024-08-20T16:00:00"));

        // Remocoes
        sistema.removerReserva(9);
        sistema.removerReserva(10);
        sistema.removerReserva(4);

        // Impressao em pre-ordem
        sistema.imprimirEmPreOrdem();
    }
}
