package com.keralty.aenovedades.api.globalservices;

import com.keralty.aenovedades.service.GlobalServicesService;
import com.keralty.aenovedades.utils.TokenUtilities;
import com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADORequest;
import com.keralty.aenovedades.viewmodel.globalservices.siu.OGSOLNOVSETTRAMITADOResponse;
import com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRARequest;
import com.keralty.aenovedades.viewmodel.globalservices.siu.TGSOLNOVSETTRAResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/GlobalServicesApi")
@RequestScoped
public class GlobalServicesApi {

    GlobalServicesService service;

    public GlobalServicesApi(GlobalServicesService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @POST
    @Path(value = "/OGSOLNOVSETTRAMITADO")
    @RolesAllowed({"Admin","SuperAdmin"})
    public OGSOLNOVSETTRAMITADOResponse oGSOLNOVSETTRAMITADO(OGSOLNOVSETTRAMITADORequest request) {
        return service.oGSOLNOVSETTRAMITADO(request);
    }

    @POST
    @Path(value = "/TGSOLNOVSETTRA")
    @RolesAllowed({"Admin","SuperAdmin"})
    public TGSOLNOVSETTRAResponse tGSOLNOVSETTRA(TGSOLNOVSETTRARequest request) {
        return service.tGSOLNOVSETTRA(request);
    }
}
