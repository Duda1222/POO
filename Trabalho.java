package trabalho;
import java.util.HashMap;
import java.util.Map;

class CardapioDiario {
    private Map<DiaSemana, CardapioDia> cardapios;

    public CardapioDiario() {
        this.cardapios = new HashMap<>();
    }

    public void adicionarCardapio(DiaSemana dia, CardapioDia cardapioDia) {
        cardapios.put(dia, cardapioDia);
    }

    public CardapioDia obterCardapio(DiaSemana dia) {
        return cardapios.get(dia);
    }
}

class CardapioDia {
    private String pratoPrincipal;
    private String acompanhamento;
    private String bebida;

    public CardapioDia(String pratoPrincipal, String acompanhamento, String bebida) {
        this.pratoPrincipal = pratoPrincipal;
        this.acompanhamento = acompanhamento;
        this.bebida = bebida;
    }

    public String getPratoPrincipal() {
        return pratoPrincipal;
    }

    public void setPratoPrincipal(String pratoPrincipal) {
        this.pratoPrincipal = pratoPrincipal;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }
}

enum DiaSemana {
    SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA
}

public class Trabalho {
    public static void main(String[] args) {
        CardapioDiario cardapioDiario = new CardapioDiario();

        cardapioDiario.adicionarCardapio(DiaSemana.SEGUNDA, new CardapioDia("Arroz, feijão e carne", "Salada", "Suco"));
        cardapioDiario.adicionarCardapio(DiaSemana.TERÇA, new CardapioDia("Frango grelhado", "Batata frita", "Refrigerante"));

        CardapioDia cardapioSegunda = cardapioDiario.obterCardapio(DiaSemana.SEGUNDA);
        if (cardapioSegunda != null) {
            System.out.println("Cardápio de segunda-feira:");
            System.out.println("Prato Principal: " + cardapioSegunda.getPratoPrincipal());
            System.out.println("Acompanhamento: " + cardapioSegunda.getAcompanhamento());
            System.out.println("Bebida: " + cardapioSegunda.getBebida());
        } else {
            System.out.println("Cardápio não cadastrado para segunda-feira.");
        }
    }
}


