package validation;

import exception.ValidacaoException;
import model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {

    void validarAumento(Funcionario funcionario, BigDecimal aumento);
    void validarTempoUltimoReajuste(Funcionario funcionario);
}
