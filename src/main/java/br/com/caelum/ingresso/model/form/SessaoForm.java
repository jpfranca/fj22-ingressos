package br.com.caelum.ingresso.model.form;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class SessaoForm {
    @NotNull
    private Integer salaId;

    @DateTimeFormat(pattern="HH:mm")
    @NotNull
    private LocalTime horario;

    @NotNull
    private Integer filmeId;

    public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao){
        Filme filme = filmeDao.findOne(filmeId);
        Sala sala = salaDao.findOne(salaId);

        return new Sessao(this.horario, filme, sala);
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }

    public Integer getSalaId() {
        return this.salaId;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setFilmeId(Integer filmeId) {
        this.filmeId = filmeId;
    }

    public Integer getFilmeId() {
        return filmeId;
    }
}
