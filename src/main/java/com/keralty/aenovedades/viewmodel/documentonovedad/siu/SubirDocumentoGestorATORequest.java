package com.keralty.aenovedades.viewmodel.documentonovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aenovedades.exception.NotNullArgumentException;
import com.keralty.aenovedades.global.DocumentoNovedadConstants;
import com.keralty.aenovedades.persistence.DocumentoNovedad;
import com.keralty.aenovedades.persistence.oid.DocumentoNovedadOid;

public class SubirDocumentoGestorATORequest {

    @JsonProperty("p_thisdocumentonovedad_oid")
    private DocumentoNovedadOid documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad;
    
    @JsonIgnore
    private DocumentoNovedad documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance;

    @JsonProperty("peiddocgestor")
    private String documentoNovedadsubirDocumentoGestorATOpeIdDocGestor;

    @JsonProperty("ptnombre")
    private String documentoNovedadsubirDocumentoGestorATOptNombre;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad();
        checkDocumentoNovedadsubirDocumentoGestorATOpeIdDocGestor();
        checkDocumentoNovedadsubirDocumentoGestorATOptNombre();
    }

    @JsonIgnore
    public DocumentoNovedadOid getDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad() {
        return this.documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad;
    }
    
    public void setDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad(DocumentoNovedadOid documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad) {
        this.documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad = documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad;
    }

    @JsonIgnore
    public DocumentoNovedad getDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance() {
        return this.documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance;
    }
    
    public void setDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance(DocumentoNovedad documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad) {
        this.documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance = documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad;
        this.documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad = documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad != null ? documentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad.getOid() : null;
    }

    private void checkDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedad() throws NotNullArgumentException {
        if(this.getDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance() == null || this.getDocumentoNovedadsubirDocumentoGestorATOpthisDocumentoNovedadInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_SUBIRDOCUMENTOGESTORATO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_SUBIRDOCUMENTOGESTORATO_DOCUMENTONOVEDADSUBIRDOCUMENTOGESTORATOPTHISDOCUMENTONOVEDAD, DocumentoNovedadConstants.SERV_ALIAS_SUBIRDOCUMENTOGESTORATO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_SUBIRDOCUMENTOGESTORATO_DOCUMENTONOVEDADSUBIRDOCUMENTOGESTORATOPTHISDOCUMENTONOVEDAD);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedadsubirDocumentoGestorATOpeIdDocGestor() {
        return this.documentoNovedadsubirDocumentoGestorATOpeIdDocGestor;
    }
    
    public void setDocumentoNovedadsubirDocumentoGestorATOpeIdDocGestor(String documentoNovedadsubirDocumentoGestorATOpeIdDocGestor) {
        this.documentoNovedadsubirDocumentoGestorATOpeIdDocGestor = documentoNovedadsubirDocumentoGestorATOpeIdDocGestor;
    }

    private void checkDocumentoNovedadsubirDocumentoGestorATOpeIdDocGestor() throws NotNullArgumentException {
        if(this.getDocumentoNovedadsubirDocumentoGestorATOpeIdDocGestor() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_SUBIRDOCUMENTOGESTORATO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_SUBIRDOCUMENTOGESTORATO_DOCUMENTONOVEDADSUBIRDOCUMENTOGESTORATOPEIDDOCGESTOR, DocumentoNovedadConstants.SERV_ALIAS_SUBIRDOCUMENTOGESTORATO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_SUBIRDOCUMENTOGESTORATO_DOCUMENTONOVEDADSUBIRDOCUMENTOGESTORATOPEIDDOCGESTOR);
        }
    }

    @JsonIgnore
    public String getDocumentoNovedadsubirDocumentoGestorATOptNombre() {
        return this.documentoNovedadsubirDocumentoGestorATOptNombre;
    }
    
    public void setDocumentoNovedadsubirDocumentoGestorATOptNombre(String documentoNovedadsubirDocumentoGestorATOptNombre) {
        this.documentoNovedadsubirDocumentoGestorATOptNombre = documentoNovedadsubirDocumentoGestorATOptNombre;
    }

    private void checkDocumentoNovedadsubirDocumentoGestorATOptNombre() throws NotNullArgumentException {
        if(this.getDocumentoNovedadsubirDocumentoGestorATOptNombre() == null) {
            throw new NotNullArgumentException(DocumentoNovedadConstants.SERV_ID_SUBIRDOCUMENTOGESTORATO, DocumentoNovedadConstants.CLASS_ID, DocumentoNovedadConstants.ARG_ID_SUBIRDOCUMENTOGESTORATO_DOCUMENTONOVEDADSUBIRDOCUMENTOGESTORATOPTNOMBRE, DocumentoNovedadConstants.SERV_ALIAS_SUBIRDOCUMENTOGESTORATO, DocumentoNovedadConstants.CLASS_ALIAS, DocumentoNovedadConstants.ARG_ALIAS_SUBIRDOCUMENTOGESTORATO_DOCUMENTONOVEDADSUBIRDOCUMENTOGESTORATOPTNOMBRE);
        }
    }
}
