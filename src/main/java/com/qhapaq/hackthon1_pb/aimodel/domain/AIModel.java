package com.qhapaq.hackthon1_pb.aimodel.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ai_models")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AIModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 100)
    private String name;

    @Column(nullable = true, length = 100)
    private String provider;

    @Column(nullable = true, length = 50)
    private String type;

    @Column(nullable = true)
    private Double costPerToken;

    @Column(nullable = true)
    private Double costPerRequest;

    @Column(nullable = true)
    private boolean active;
}
