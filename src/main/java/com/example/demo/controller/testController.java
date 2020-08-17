package com.example.demo.controller;

import ir.tourismit.tit.core.Request;
import ir.tourismit.tit.core.Response;
import ir.tourismit.tit.core.grpc.GrpcClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class testController  {

    @PostMapping("/request")
    public ResponseEntity<String> callService() {
        Request request1 = Request.newBuilder()
                .setProcessID("request.getProcessId()")
                .setProcessReference("request.getProcessReference()")
                .setCallerReference("request.getCallerReference()")
                .setServiceID("request.getServiceId()")
                .setCallerInputJson("{\"name\": \"test\"}")
                .setPreviewsOutput("request.getPreviewsOutput()")
                .setTokenAA("request.getTokenAA()")
                .build();
        System.out.println("Request");
        System.out.println(request1);
        Response response = GrpcClient.getInstance().service(request1);
        System.out.println("Response");
        System.out.println(response);

        return new ResponseEntity<>(response.getOutputJson(), HttpStatus.OK);
    }
}
