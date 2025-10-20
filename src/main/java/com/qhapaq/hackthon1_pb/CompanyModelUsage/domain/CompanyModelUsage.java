package com.qhapaq.hackthon1_pb.CompanyModelUsage.domain;

import com.qhapaq.hackthon1_pb.company.domain.Company;
import com.qhapaq.hackthon1_pb.aimodel.domain.AIModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company_model_usages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyModelUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(
            name = "company_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_usage_company")
    )
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(
            name = "ai_model_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_usage_ai_model")
    )
    private AIModel model;

    @Column(nullable = true)
    private Long maxTokens;

    @Column(nullable = true)
    private Long maxRequests;

    @Column(nullable = true)
    private boolean active;
}
