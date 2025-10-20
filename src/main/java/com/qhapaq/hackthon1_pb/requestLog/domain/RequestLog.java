package com.qhapaq.hackthon1_pb.requestLog.domain;

import com.qhapaq.hackthon1_pb.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    private User user;

    @ManyToMany
    @JoinTable(
            name = "requestlog_ai_model",
            joinColumns = @JoinColumn(name = "request_log_id"),
            inverseJoinColumns = @JoinColumn(name = "ai_model_id")
    )
    private AiModel model;

    private String query;

    private String response;

    private Long tokensConsumed;

    private boolean success;

    private LocalDateTime timeStamp;

    private String fileName;

}
