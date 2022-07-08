package service;

import java.math.BigDecimal;

public class Frete implements AlteracaoPreco{
    @Override
    public BigDecimal alteraPreco(BigDecimal preco) {

        return preco.multiply(BigDecimal.valueOf(0.1));
    }
}
