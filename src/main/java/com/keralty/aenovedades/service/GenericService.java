package com.keralty.aenovedades.service;

import com.keralty.aenovedades.repository.AnexoMatJpaRepository;
import com.keralty.aenovedades.repository.AnexoNeoJpaRepository;
import com.keralty.aenovedades.repository.BeneficiarioCJpaRepository;
import com.keralty.aenovedades.repository.ConfiguracionANSJpaRepository;
import com.keralty.aenovedades.repository.ContratoCJpaRepository;
import com.keralty.aenovedades.repository.DireccionCJpaRepository;
import com.keralty.aenovedades.repository.NovedadJpaRepository;
import com.keralty.aenovedades.repository.PersonaCJpaRepository;
import com.keralty.aenovedades.repository.PersonaJpaRepository;
import com.keralty.aenovedades.repository.ReportesDominioJpaRepository;
import com.keralty.aenovedades.repository.SolicitudJpaRepository;
import com.keralty.aenovedades.repository.UsuarioJpaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class GenericService {

    private PersonaJpaRepository personaJpaRepository;

    private SolicitudJpaRepository solicitudJpaRepository;

    private PersonaCJpaRepository personaCJpaRepository;

    private DireccionCJpaRepository direccionCJpaRepository;

    private UsuarioJpaRepository usuarioJpaRepository;

    private AnexoMatJpaRepository anexoMatJpaRepository;

    private AnexoNeoJpaRepository anexoNeoJpaRepository;

    private ContratoCJpaRepository contratoCJpaRepository;

    private BeneficiarioCJpaRepository beneficiarioCJpaRepository;

    private NovedadJpaRepository novedadJpaRepository;

    private ConfiguracionANSJpaRepository configuracionANSJpaRepository;

    private ReportesDominioJpaRepository reportesDominioJpaRepository;
	
	@Inject
	public GenericService(
            PersonaJpaRepository personaJpaRepository,
            SolicitudJpaRepository solicitudJpaRepository,
            PersonaCJpaRepository personaCJpaRepository,
            DireccionCJpaRepository direccionCJpaRepository,
            UsuarioJpaRepository usuarioJpaRepository,
            AnexoMatJpaRepository anexoMatJpaRepository,
            AnexoNeoJpaRepository anexoNeoJpaRepository,
            ContratoCJpaRepository contratoCJpaRepository,
            BeneficiarioCJpaRepository beneficiarioCJpaRepository,
            NovedadJpaRepository novedadJpaRepository,
            ConfiguracionANSJpaRepository configuracionANSJpaRepository,
            ReportesDominioJpaRepository reportesDominioJpaRepository
			) {
        this.personaJpaRepository = personaJpaRepository;
        this.solicitudJpaRepository = solicitudJpaRepository;
        this.personaCJpaRepository = personaCJpaRepository;
        this.direccionCJpaRepository = direccionCJpaRepository;
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.anexoMatJpaRepository = anexoMatJpaRepository;
        this.anexoNeoJpaRepository = anexoNeoJpaRepository;
        this.contratoCJpaRepository = contratoCJpaRepository;
        this.beneficiarioCJpaRepository = beneficiarioCJpaRepository;
        this.novedadJpaRepository = novedadJpaRepository;
        this.configuracionANSJpaRepository = configuracionANSJpaRepository;
        this.reportesDominioJpaRepository = reportesDominioJpaRepository;
	}

	public PersonaJpaRepository getPersonaJpaRepository() {
		return this.personaJpaRepository;
	}
	public SolicitudJpaRepository getSolicitudJpaRepository() {
		return this.solicitudJpaRepository;
	}
	public PersonaCJpaRepository getPersonaCJpaRepository() {
		return this.personaCJpaRepository;
	}
	public DireccionCJpaRepository getDireccionCJpaRepository() {
		return this.direccionCJpaRepository;
	}
	public UsuarioJpaRepository getUsuarioJpaRepository() {
		return this.usuarioJpaRepository;
	}
	public AnexoMatJpaRepository getAnexoMatJpaRepository() {
		return this.anexoMatJpaRepository;
	}
	public AnexoNeoJpaRepository getAnexoNeoJpaRepository() {
		return this.anexoNeoJpaRepository;
	}
	public ContratoCJpaRepository getContratoCJpaRepository() {
		return this.contratoCJpaRepository;
	}
	public BeneficiarioCJpaRepository getBeneficiarioCJpaRepository() {
		return this.beneficiarioCJpaRepository;
	}
	public NovedadJpaRepository getNovedadJpaRepository() {
		return this.novedadJpaRepository;
	}
	public ConfiguracionANSJpaRepository getConfiguracionANSJpaRepository() {
		return this.configuracionANSJpaRepository;
	}
	public ReportesDominioJpaRepository getReportesDominioJpaRepository() {
		return this.reportesDominioJpaRepository;
	}
}
