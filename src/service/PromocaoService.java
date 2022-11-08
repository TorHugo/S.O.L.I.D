package service;

import enums.Cargo;
import exception.ValidacaoException;
import model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, Boolean metaBatida){

        Cargo cargoAtual = funcionario.getCargo();
        if (Cargo.GERENTE.equals(cargoAtual))
            throw new ValidacaoException("O funcionário do tipo GERENTE, não pode ser promovido.");

        if (metaBatida) {
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("O funcionário não bateu a meta.");
        }

    }
}
