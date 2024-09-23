package ru.solonchev.phonecontact.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"code", "message"})
public record ErrorDto(
        String code,
        String message
) {
}
