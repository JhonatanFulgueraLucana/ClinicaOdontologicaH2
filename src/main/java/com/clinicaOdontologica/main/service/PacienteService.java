package com.clinicaOdontologica.main.service;

import com.clinicaOdontologica.main.dto.PacienteDTOMapper;
import com.clinicaOdontologica.main.dto.PacienteDto;
import com.clinicaOdontologica.main.repository.IDao;
import com.clinicaOdontologica.main.entity.Paciente;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
        private IDao<Paciente> pascienteServiceDao;
    private PacienteDTOMapper pasmondeDTOMapper;

    public PacienteService(PacienteDTOMapper pasmondeDTOMapper) {
        this.pasmondeDTOMapper = pasmondeDTOMapper;
    }


        public PacienteService() {
        }

        public PacienteService(IDao<Paciente> pascienteServiceDao) {
            this.pascienteServiceDao = pascienteServiceDao;
        }

        public void setPascienteServiceDao(IDao<Paciente> pascienteServiceDao) {
            this.pascienteServiceDao = pascienteServiceDao;
        }

        public Paciente save(Paciente paciente) {
            return pascienteServiceDao.save(paciente);
        }
        public void update(Paciente paciente, Long id) throws SQLException {
            pascienteServiceDao.update(paciente, id);
        }
        public void delete(Long id) throws SQLException {
            pascienteServiceDao.delete(id);
        }
        public Paciente share(Long id)throws SQLException {
            return pascienteServiceDao.share(id);
        }
        public List<PacienteDto> shreAll()throws SQLException {
            return pascienteServiceDao.shareAll()
                    .stream()
                    .map(pasmondeDTOMapper).collect(Collectors.toList());
        }
}
