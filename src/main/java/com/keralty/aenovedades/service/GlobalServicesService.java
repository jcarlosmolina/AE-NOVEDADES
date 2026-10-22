package com.keralty.aenovedades.service;

import com.keralty.aenovedades.exception.ModelException;
import com.keralty.aenovedades.exception.SystemException;
import com.keralty.aenovedades.global.UserFunctions;
import com.keralty.aenovedades.persistence.SolicitudNovedad;
import com.keralty.aenovedades.repository.GlobalServicesJpaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class GlobalServicesService extends AbstractService {

    GlobalServicesService globalServicesSrv;

    UserFunctions userFunctionsSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    GlobalServicesJpaRepository globalServicesRepository;

    @Inject
    public GlobalServicesService(
            SolicitudNovedadService solicitudNovedadSrv,
            GlobalServicesJpaRepository globalServicesRepository,
            UserFunctions userFunctionsSrv,
            GlobalServicesService globalServicesSrv) {
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.globalServicesRepository = globalServicesRepository;
        this.userFunctionsSrv = userFunctionsSrv;
        this.globalServicesSrv = globalServicesSrv;
    }

    /*
     * Entry point for global service OGSOLNOVSETTRAMITADO
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADOResponse oGSOLNOVSETTRAMITADO(
            com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADORequest request) {
        com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADOResponse response = new com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADOResponse();
        try {
            response = globalServicesSrv.oGSOLNOVSETTRAMITADOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service OGSOLNOVSETTRAMITADO
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADOResponse oGSOLNOVSETTRAMITADOTxn(
            com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADORequest request) throws ModelException, SystemException {
        return globalServicesSrv.oGSOLNOVSETTRAMITADOImplementation(request);
    }

    /*
     * Implements global service OGSOLNOVSETTRAMITADO
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADOResponse oGSOLNOVSETTRAMITADOImplementation(
            com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADORequest request) throws ModelException, SystemException {
        com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADOResponse response = new com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADOResponse();
        byte[] oGSOLNOVSETTRAMITADOptFichero = request.getOGSOLNOVSETTRAMITADOptFichero();

        request.checkArguments();

        try {
            for(SolicitudNovedad step1Entity : globalServicesRepository.assocOperator137()) {
                try {
                    com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRARequest step1Request = new com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRARequest();
                    step1Request.setTGSOLNOVSETTRAptNumRadicado(Long.valueOf(1));
                    com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRAResponse step1Response = globalServicesSrv.tGSOLNOVSETTRATxn(step1Request);
                    response.setOGSOLNOVSETTRAMITADOoaNumProcesados(step1Response.getTGSOLNOVSETTRAptoaNumProcesados());
                    response.setOGSOLNOVSETTRAMITADOoaNumErrores(step1Response.getTGSOLNOVSETTRAptoaNumErrores());
                    response.setOGSOLNOVSETTRAMITADOoaErrores(step1Response.getTGSOLNOVSETTRAptoaErrores());
                } catch (Exception e) { }
            }
        } catch (Exception e) { }
        return response;
    }

    /*
     * Entry point for global service TGSOLNOVSETTRA
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRAResponse tGSOLNOVSETTRA(
            com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRARequest request) {
        com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRAResponse response = new com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRAResponse();
        try {
            response = globalServicesSrv.tGSOLNOVSETTRATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGSOLNOVSETTRA
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRAResponse tGSOLNOVSETTRATxn(
            com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRARequest request) throws ModelException, SystemException {
        return globalServicesSrv.tGSOLNOVSETTRAImplementation(request);
    }

    /*
     * Implements global service TGSOLNOVSETTRA
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRAResponse tGSOLNOVSETTRAImplementation(
            com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRARequest request) throws ModelException, SystemException {
        com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRAResponse response = new com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRAResponse();
        Long tGSOLNOVSETTRAptNumRadicado = request.getTGSOLNOVSETTRAptNumRadicado();

        request.checkArguments();

        for(SolicitudNovedad step1Entity : globalServicesRepository.assocOperator138(tGSOLNOVSETTRAptNumRadicado)) {
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADARequest step1Request = new com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADARequest();
            step1Request.setSolicitudNovedadTMARCARTRAMITADApthisSolicitudNovedadInstance(step1Entity);
            com.keralty.aenovedades.viewmodel.solicitudnovedad.siu.TMARCARTRAMITADAResponse step1Response = solicitudNovedadSrv.tMARCARTRAMITADAImplementation(step1Request);
        response.setTGSOLNOVSETTRAptoaNumProcesados(step1Response.getSolicitudNovedadTMARCARTRAMITADAoaNumProcesados());
        response.setTGSOLNOVSETTRAptoaNumErrores(step1Response.getSolicitudNovedadTMARCARTRAMITADAoaNumErrores());
        response.setTGSOLNOVSETTRAptoaErrores(step1Response.getSolicitudNovedadTMARCARTRAMITADAoaErrores());
        }
        return response;
    }
}
