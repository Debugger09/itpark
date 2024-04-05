package com.sprinpay.itpark.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sprinpay.itpark.domain.LigneMateriel;
import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.domain.Pannes;
import com.sprinpay.itpark.repository.LigneMaterielRepository;
import com.sprinpay.itpark.repository.MaterielsRepository;
import com.sprinpay.itpark.repository.PannesRepository;
import com.sprinpay.itpark.services.PannesService;
import com.sprinpay.itpark.services.dto.PanneDTO;
import org.springframework.stereotype.Service;


@Service
public class PannesServiceImpl implements PannesService {
    private final PannesRepository pannesRepository;
    private final MaterielsRepository materielsRepository;
    private final LigneMaterielRepository ligneMaterielRepository;
    public PannesServiceImpl(PannesRepository pannesRepository, MaterielsRepository materielsRepository, LigneMaterielRepository ligneMaterielRepository) {
        this.pannesRepository = pannesRepository;
        this.materielsRepository = materielsRepository;
        this.ligneMaterielRepository = ligneMaterielRepository;
    }

    @Override
    public void deleteById(Long id) {
        pannesRepository.deleteById(id);

    }

    /**
     *  Find all pannes
     * @return
     */

    @Override
    public List<Pannes> findAll() {
        return pannesRepository.findAll();
    }

    @Override
    public Optional<Pannes> findById(Long id) {
        return pannesRepository.findById(id);
    }

    /**
     * Save parne
     * @param panneDTO
     * @return
     */
    @Override
    public Pannes save(PanneDTO panneDTO) {

        Optional<Materiels> materiels=materielsRepository.findById(panneDTO.getMaterielId());
        Pannes panne=new Pannes();
        materiels.ifPresent(panne::setMateriel);
        panne.setDiagnostic(panneDTO.getDiagnostic());
        panne.setDateDiagnostic(panneDTO.getDateDiagnostic());
        panne.setBesoinPiece(panneDTO.getBesoinPiece());
        panne.setDecision(false);
        /*
            Si le materiel n'es plus reparable on met panne automatiquement a false
         */
        if(!panneDTO.getReparable()){
            panne.setBesoinPiece(false);

        }else{
            LigneMateriel ligneMateriel=ligneMaterielRepository.findByMateriel_Id(panneDTO.getMaterielId());
            /*
                Si le materiel est deja attribué et qu'il ne peut plus etre reparé on restitue le materiel si ce n'est pas encore fait
            * */
            if(ligneMateriel!=null && ligneMateriel.getDateAttribution()!=null){
                ligneMateriel.setDateRestitution(new Date());
                ligneMaterielRepository.save(ligneMateriel);
            }


        }
        panne.setReparable(panneDTO.getReparable());

        if(panneDTO.getId()!=null){
            panne.setId(panneDTO.getId());
        }


        return pannesRepository.save(panne);
    }

}
