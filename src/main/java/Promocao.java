import java.math.BigDecimal;

public class Promocao implements AlteracaoPreco {

    @Override
    public BigDecimal alteraPreco(BigDecimal preco) {

        return preco.multiply(BigDecimal.valueOf(-0.15));
    }
}
