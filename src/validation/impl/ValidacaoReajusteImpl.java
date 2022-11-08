package validation.impl;

import exception.ValidacaoException;
import model.Funcionario;
import validation.ValidacaoReajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoReajusteImpl implements ValidacaoReajuste {

    @Override
    public void validarAumento(Funcionario funcionario, BigDecimal aumento){

        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0)
            throw new ValidacaoException("Reajuste não pode ser maior que 40% do salário.");
    }

    @Override
    public void validarTempoUltimoReajuste(Funcionario funcionario){

        LocalDate dataUltimoReajuste = funcionario.getDataReajuste();
        LocalDate dataAtual = LocalDate.now();
        Long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

        if (mesesDesdeUltimoReajuste < 6)
            throw new ValidacaoException("Intervalo entre reajustes muito curto.");
    }
}
