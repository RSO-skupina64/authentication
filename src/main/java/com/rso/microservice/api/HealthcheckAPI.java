package com.rso.microservice.api;

import com.rso.microservice.api.dto.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Healthcheck")
public class HealthcheckAPI {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application is running",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))}
            )
    })
    @Operation(summary = "Healthcheck",
            description = "HealthCheck service")
    @GetMapping("/ping")
    public ResponseEntity<MessageDto> ping() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("pong"));
    }

}
