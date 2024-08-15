package com.romannumerals.challenge.infraestructure.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    private int statusCode;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> moreInfo;

    public ErrorResponse(int statusCode, String message, String moreInfo) {
        this.statusCode = statusCode;
        this.message = message;
        this.moreInfo = List.of(moreInfo);
    }
}
