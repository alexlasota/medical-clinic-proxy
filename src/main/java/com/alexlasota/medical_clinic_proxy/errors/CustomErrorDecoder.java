package com.alexlasota.medical_clinic_proxy.errors;

import feign.Response;
import feign.codec.ErrorDecoder;
import feign.RetryableException;
import org.springframework.data.crossstore.ChangeSetPersister;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new IllegalArgumentException("Bad request: " + response.request().url());
            case 404 -> new ChangeSetPersister.NotFoundException();
            case 500 -> new RetryableException(
                    response.status(),
                    "Internal Server Error",
                    response.request().httpMethod(),
                    2L, response.request());
            default -> defaultErrorDecoder.decode(methodKey, response);
        };
    }
}