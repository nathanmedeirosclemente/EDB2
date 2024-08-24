public class ArvoreBalanceada {

    private static final boolean VERMELHO = true;
    private static final boolean PRETO = false;

    private class NoRubroNegro {
        Reserva reserva;
        NoRubroNegro esquerda;
        NoRubroNegro direita;
        NoRubroNegro pai;
        boolean cor;

        public NoRubroNegro(Reserva reserva) {
            this.reserva = reserva;
            this.cor = VERMELHO;
            this.esquerda = folha;
            this.direita = folha;
            this.pai = folha;
        }
    }

    private final NoRubroNegro folha;
    private NoRubroNegro raiz;

    public ArvoreBalanceada() {
        folha = new NoRubroNegro(null);
        folha.cor = PRETO;
        raiz = folha;
    }

    private void rotacaoEsquerda(NoRubroNegro no) {
        NoRubroNegro aux = no.direita;
        no.direita = aux.esquerda;
        if (aux.esquerda != folha) {
            aux.esquerda.pai = no;
        }
        aux.pai = no.pai;
        if (no.pai == folha) {
            raiz = aux;
        } else if (no == no.pai.esquerda) {
            no.pai.esquerda = aux;
        } else {
            no.pai.direita = aux;
        }
        aux.esquerda = no;
        no.pai = aux;
    }

    private void rotacaoDireita(NoRubroNegro no) {
        NoRubroNegro aux = no.esquerda;
        no.esquerda = aux.direita;
        if (aux.direita != folha) {
            aux.direita.pai = no;
        }
        aux.pai = no.pai;
        if (no.pai == folha) {
            raiz = aux;
        } else if (no == no.pai.direita) {
            no.pai.direita = aux;
        } else {
            no.pai.esquerda = aux;
        }
        aux.direita = no;
        no.pai = aux;
    }

    private void balancearInsercao(NoRubroNegro no) {
        while (no.pai.cor == VERMELHO) {
            if (no.pai == no.pai.pai.esquerda) {
                NoRubroNegro tio = no.pai.pai.direita;
                if (tio.cor == VERMELHO) {
                    no.pai.cor = PRETO;
                    tio.cor = PRETO;
                    no.pai.pai.cor = VERMELHO;
                    no = no.pai.pai;
                } else {
                    if (no == no.pai.direita) {
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    no.pai.cor = PRETO;
                    no.pai.pai.cor = VERMELHO;
                    rotacaoDireita(no.pai.pai);
                }
            } else {
                NoRubroNegro tio = no.pai.pai.esquerda;
                if (tio.cor == VERMELHO) {
                    no.pai.cor = PRETO;
                    tio.cor = PRETO;
                    no.pai.pai.cor = VERMELHO;
                    no = no.pai.pai;
                } else {
                    if (no == no.pai.esquerda) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.cor = PRETO;
                    no.pai.pai.cor = VERMELHO;
                    rotacaoEsquerda(no.pai.pai);
                }
            }
        }
        raiz.cor = PRETO;
    }

    private NoRubroNegro inserir(NoRubroNegro raiz, NoRubroNegro no) {
        if (raiz == folha) {
            return no;
        }
        if (no.reserva.codigo < raiz.reserva.codigo) {
            raiz.esquerda = inserir(raiz.esquerda, no);
            raiz.esquerda.pai = raiz;
        } else if (no.reserva.codigo > raiz.reserva.codigo) {
            raiz.direita = inserir(raiz.direita, no);
            raiz.direita.pai = raiz;
        }
        return raiz;
    }

    public void inserirReserva(Reserva reserva) {
        NoRubroNegro no = new NoRubroNegro(reserva);
        no.esquerda = folha;
        no.direita = folha;
        no.cor = VERMELHO;
        raiz = inserir(raiz, no);
        balancearInsercao(no);
        System.out.println("Reserva inserida com sucesso: " + reserva);
    }


    private void imprimirEmPreOrdem(NoRubroNegro no) {

        if (no != folha) {
            System.out.println("Reserva: " + no.reserva);
            imprimirEmPreOrdem(no.esquerda);
            imprimirEmPreOrdem(no.direita);
            
        }
    }

    public void imprimirEmPreOrdem() {

        imprimirEmPreOrdem(raiz);
        System.out.println();
    }

   

    private void transplantar(NoRubroNegro no1, NoRubroNegro no2) {
        if (no1.pai == folha) {
            raiz = no2;
        } else if (no1 == no1.pai.esquerda) {
            no1.pai.esquerda = no2;
        } else {
            no1.pai.direita = no2;
        }
        no2.pai = no1.pai;
    }

    private void balancearRemocao(NoRubroNegro no) {
        while (no != raiz && no.cor == PRETO) {
            if (no == no.pai.esquerda) {
                NoRubroNegro tio = no.pai.direita;
                if (tio.cor == VERMELHO) {
                    tio.cor = PRETO;
                    no.pai.cor = VERMELHO;
                    rotacaoEsquerda(no.pai);
                    tio = no.pai.direita;
                }
                if (tio.esquerda.cor == PRETO && tio.direita.cor == PRETO) {
                    tio.cor = VERMELHO;
                    no = no.pai;
                } else {
                    if (tio.direita.cor == PRETO) {
                        tio.esquerda.cor = PRETO;
                        tio.cor = VERMELHO;
                        rotacaoDireita(tio);
                        tio = no.pai.direita;
                    }
                    tio.cor = no.pai.cor;
                    no.pai.cor = PRETO;
                    tio.direita.cor = PRETO;
                    rotacaoEsquerda(no.pai);
                    no = raiz;
                }
            } else {
                NoRubroNegro tio = no.pai.esquerda;
                if (tio.cor == VERMELHO) {
                    tio.cor = PRETO;
                    no.pai.cor = VERMELHO;
                    rotacaoDireita(no.pai);
                    tio = no.pai.esquerda;
                }
                if (tio.direita.cor == PRETO && tio.esquerda.cor == PRETO) {
                    tio.cor = VERMELHO;
                    no = no.pai;
                } else {
                    if (tio.esquerda.cor == PRETO) {
                        tio.direita.cor = PRETO;
                        tio.cor = VERMELHO;
                        rotacaoEsquerda(tio);
                        tio = no.pai.esquerda;
                    }
                    tio.cor = no.pai.cor;
                    no.pai.cor = PRETO;
                    tio.esquerda.cor = PRETO;
                    rotacaoDireita(no.pai);
                    no = raiz;
                }
            }
        }
        no.cor = PRETO;
    }

    private NoRubroNegro buscar(NoRubroNegro raiz, int codigo) {
        if (raiz == folha || raiz.reserva.codigo == codigo) {
            return raiz;
        }
        if (codigo < raiz.reserva.codigo) {
            return buscar(raiz.esquerda, codigo);
        } else {
            return buscar(raiz.direita, codigo);
        }
    }

    public void removerReserva(int codigo) {
        NoRubroNegro no = buscar(raiz, codigo);
        if (no == folha) {
            System.out.println("Reserva não encontrada: ID = " + codigo);
            return;
        }
        NoRubroNegro aux = no;
        boolean auxOriginalCor = aux.cor;
        NoRubroNegro x;
        if (no.esquerda == folha) {
            x = no.direita;
            transplantar(no, no.direita);
        } else if (no.direita == folha) {
            x = no.esquerda;
            transplantar(no, no.esquerda);
        } else {
            aux = minimum(no.direita);
            auxOriginalCor = aux.cor;
            x = aux.direita;
            if (aux.pai == no) {
                x.pai = aux;
            } else {
                transplantar(aux, aux.direita);
                aux.direita = no.direita;
                aux.direita.pai = aux;
            }
            transplantar(no, aux);
            aux.esquerda = no.esquerda;
            aux.esquerda.pai = aux;
            aux.cor = no.cor;
        }
        if (auxOriginalCor == PRETO) {
            balancearRemocao(x);
        }
        System.out.println("Reserva removida com sucesso: ID = " + codigo);
    }

    private NoRubroNegro minimum(NoRubroNegro raiz) {
        while (raiz.esquerda != folha) {
            raiz = raiz.esquerda;
        }
        return raiz;
    }
}
