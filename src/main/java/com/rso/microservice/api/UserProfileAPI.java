package com.rso.microservice.api;

import com.rso.microservice.api.dto.*;
import com.rso.microservice.api.mapper.UserProfileMapper;
import com.rso.microservice.service.UserProfileService;
import com.rso.microservice.util.ValidationUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profile")
@Tag(name = "Profile")
public class UserProfileAPI {
    private static final Logger log = LoggerFactory.getLogger(UserProfileAPI.class);

    final UserProfileService userProfileService;

    final UserProfileMapper userProfileMapper;

    public UserProfileAPI(UserProfileService userProfileService, UserProfileMapper userProfileMapper) {
        this.userProfileService = userProfileService;
        this.userProfileMapper = userProfileMapper;
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get logged in User extended info",
            description = "Get profile information about currently logged in user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User information successfully fetched",
                    content = @Content(schema = @Schema(implementation = UserDetailsDto.class))),
            @ApiResponse(responseCode = "400", description = "User not authenticated",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<UserDetailsWithIdDto> getUserProfile(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwt) {
        log.info("getUserProfile: ENTRY");
        UserDetailsWithIdDto userDetailsWithId = userProfileMapper.toModelUserDetailsWithIdDto(
                userProfileService.getUserFromJwt(jwt));
        log.info("getUserProfile: EXIT");
        return ResponseEntity.status(HttpStatus.OK).body(userDetailsWithId);
    }

    @PutMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update User profile",
            description = "Update profile information about currently logged in user")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "User profile update successful"),
            @ApiResponse(responseCode = "400", description = "User not authenticated",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<?> updateUserProfile(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwt,
                                               @Valid @RequestBody UserDetailsDto userDetails) {
        log.info("updateUserProfile: ENTRY");
        userDetails = userProfileMapper.toModelUserDetailsDto(
                userProfileService.updateUser(jwt, userProfileMapper.toModel(userDetails)));
        log.info("updateUserProfile: EXIT");
        return ResponseEntity.status(HttpStatus.OK).body(userDetails);
    }

    @PutMapping(value = "/user/change-password", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Change user password", description = "Changes user password")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "User profile update successful"),
            @ApiResponse(responseCode = "400", description = "User not authenticated",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<?> changePassword(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwt,
                                            @Valid @RequestBody ChangePasswordRequestDto changePasswordRequest) {
        log.info("changePassword: ENTRY");
        ValidationUtil.checkPasswordMatch(changePasswordRequest.getNewPassword(),
                changePasswordRequest.getRepeatPassword());
        userProfileService.updatePassword(jwt, changePasswordRequest.getNewPassword());
        log.info("changePassword: EXIT");
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("changePassword completed"));
    }
}
