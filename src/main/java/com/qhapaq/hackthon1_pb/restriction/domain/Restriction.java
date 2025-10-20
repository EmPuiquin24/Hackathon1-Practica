package com.qhapaq.hackthon1_pb.restriction.domain;

import com.qhapaq.hackthon1_pb.aimodel.domain.AIModel;
import com.qhapaq.hackthon1_pb.company.domain.Company;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;

@Entity
@Table(name = "restrictions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Restriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_id")
    private AIModel model;

    @Column(nullable = false)
    private Long maxTokensPerWindow;

    @Column(nullable = false)
    private Long maxRequestPerWindow;

    @Column(nullable = false)
    private Duration windowDuration;
}
