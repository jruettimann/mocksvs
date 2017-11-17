package com.mock.empapi.empapimock.websocket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StatusUpdate {

    private String user;
    private String status;
}
