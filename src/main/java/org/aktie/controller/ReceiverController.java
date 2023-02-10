package org.aktie.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.aktie.dto.ReceiverDTO;
import org.aktie.service.ReceiverService;

@Path("/v1")
public class ReceiverController {

    @Inject
    ReceiverService service;

    @POST
    @Path("/receiver")
    public Response create(ReceiverDTO receiverDTO) {
        service.createReceiver(receiverDTO);

        return Response.ok().build();
    }

    @GET
    @Path("/receiver")
    public Response list() {
        return Response.ok(service.listAll()).build();
    }
}