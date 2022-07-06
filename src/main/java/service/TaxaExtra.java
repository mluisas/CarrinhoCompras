package service;

import java.math.BigDecimal;
import java.util.Random;

public class TaxaExtra implements AlteracaoPreco{
    @Override
    public BigDecimal alteraPreco(BigDecimal preco) {

        Random random = new Random();

        return BigDecimal.valueOf(random.nextInt(25));
    }
}
