package dev.fisa.test.simpleapi.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Test {

    private LocalDateTime currentDate;
    private String status;

    public Test(LocalDateTime currentDate, String status) {
        this.currentDate = currentDate;
        this.status = status;
    }
}
