package com.example.demo;


import ir.tourismit.tit.core.Request;
import ir.tourismit.tit.core.Response;
import ir.tourismit.tit.core.grpc.GrpcClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Async
    public void sendRequest(int process){
        int request = 1;

        while(true){
            request++;
            Request request1 = Request.newBuilder()
                    .setProcessID(String.valueOf(process))
                    .setProcessReference(String.valueOf(request))
                    .setCallerReference("request.getCallerReference()")
                    .setServiceID("request.getServiceId()")
                    .setCallerInputJson("{\"name\": \"test\"}")
                    .setPreviewsOutput("request.getPreviewsOutput()")
                    .setTokenAA("request.getTokenAA()")
                    .build();
            System.out.println("Process:"+process+"\t"+"Request: "+request);
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println(request1);
            Response response = GrpcClient.getInstance().service(request1);
            System.out.println("Response");
            System.out.println(response);
            System.out.println();
            System.out.println();
            System.out.println();
        }

    }


}
