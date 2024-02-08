package dev.testing.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.testing.springboot.model.Employee;
import dev.testing.springboot.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Controller의 동작 자체만 테스트를 수행하기 때문에 EmployeeService는 목(Mock) 객체로 등록
    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Employee 추가 테스트")
        // Employee 추가 요청이 서버로 성공적으로 전송되어
        // Service, Repository(DB)를 거쳐 요청 처리가 되었다고 가정한 후 정상적으로 HTTP 응답 결과를 반환하는지 테스트
    void createEmployee() throws Exception {
        // Given - When - Then

        // given - 테스트를 위한 사전 조건 세팅

        // 기존에는 Postman에서 Employee에 대한 JSON을 직접 작성해서 Send 버튼으로 동작을 테스트했었음
        Employee employee = Employee.builder()
                .firstName("gugu")
                .lastName("ttemy")
                .email("guguttemy@gmail.com")
                .build();

        // Controller의 역할이 아닌 employeeService.saveEmployee()코드는 목 객체를 통해 대신 수행되었다고 가정
        given(employeeService.saveEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // when - 실제로 테스트할 동작(요청) 수행
        // -> POST: localhost:8080/api/employees로 요청하였을 때의 상황을 테스트해보는 부분
        // mockMvc : 개발자 대신 postman처럼 HTTP 요청 수행을 대신 테스트해주는 역할
        ResultActions response = mockMvc.perform(post("/api/employees")
                        // 요청 경로(/api/employees) 및 요청 메서드(POST) 지정
                        .contentType(MediaType.APPLICATION_JSON)
                        // 요청 시 Content-Type: application/json 추가하는 부분
                        .content(objectMapper.writeValueAsString(employee))
                // 실제로는 React나 Postman를 통해 전송할 때 JSON 데이터로 전송
        );

        // then - when에서 테스트를 수행한 결과에 대한 테스트의 성공/실패 여부를 검증
        response.andDo(print()).
                andExpect(status().isCreated()) // "HTTP 응답 코드(Status)는 201 created일 것이다."
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", // JSON 형태로 요청한 lastName의 값은 "ttemy"일 것이다.
                        is(employee.getLastName())))
                .andExpect(jsonPath("$.email", // JSON 형태로 요청한 email의 값은 "guguttemy@gmail.com"일 것이다.
                        is(employee.getEmail())));

    }

    @Test
    void getAllEmployees() throws Exception {
        // given
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = Employee.builder()
                .firstName("gugu")
                .lastName("ttemy")
                .email("guguttemy@gmail.com")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("gugu2")
                .lastName("ttemy2")
                .email("guguttemy2@gmail.com")
                .build();

        employeeList.add(employee);
        employeeList.add(employee2);

        given(employeeService.saveEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));
        given(employeeService.saveEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(1));

        // when
        ResultActions response = mockMvc.perform(get("/api/employees")
                        // 요청 경로(/api/employees) 및 요청 메서드(POST) 지정
                        .contentType(MediaType.APPLICATION_JSON)
                        // 요청 시 Content-Type: application/json 추가하는 부분
        );

        // then
        response.andDo(print()).
                andExpect(status().isFound()) // "HTTP 응답 코드(Status)는 201 created일 것이다."
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", // JSON 형태로 요청한 lastName의 값은 "ttemy"일 것이다.
                        is(employee.getLastName())))
                .andExpect(jsonPath("$.email", // JSON 형태로 요청한 email의 값은 "guguttemy@gmail.com"일 것이다.
                        is(employee.getEmail())));
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {
    }

}