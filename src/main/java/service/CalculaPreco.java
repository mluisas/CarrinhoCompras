package service;

import java.math.BigDecimal;

public interface CalculaPreco<T> {
    BigDecimal calcular(T t);
}
