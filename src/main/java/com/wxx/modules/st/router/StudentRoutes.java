package com.wxx.modules.st.router;

import com.wxx.modules.st.handler.MockStudentHandler;
import com.wxx.modules.st.handler.StudentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class StudentRoutes {

    @Bean
    public RouterFunction<ServerResponse> userRoutersFunctionMock(MockStudentHandler mockStudentHandler) {
        RouterFunction<ServerResponse> serverResponse = route()
                .GET("/mock/student/{id}", accept(APPLICATION_JSON), mockStudentHandler::getStudent)
                .GET("/mock/student", accept(APPLICATION_JSON), mockStudentHandler::getStudentList)
                .POST("/mock/student", mockStudentHandler::addStudent)
                .build();
        return serverResponse;
    }

    @Bean
    public RouterFunction<ServerResponse> userRoutersFunction(StudentHandler studentHandler) {
        RouterFunction<ServerResponse> serverResponse = route()
                .GET("/student/{id}", accept(APPLICATION_JSON), studentHandler::getStudent)
                .GET("/student", accept(APPLICATION_JSON), studentHandler::getStudentList)
                .POST("/student", studentHandler::addStudent)
                .POST("/student/mq", studentHandler::syncStudentUpdate)
                .build();
        return serverResponse;
    }
}







