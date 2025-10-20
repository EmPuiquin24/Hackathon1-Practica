package com.qhapaq.hackthon1_pb.restriction.domain;

import com.qhapaq.hackthon1_pb.aimodel.domain.AIModel;
import com.qhapaq.hackthon1_pb.aimodel.domain.AIModelRepository;
import com.qhapaq.hackthon1_pb.company.domain.Company;
import com.qhapaq.hackthon1_pb.company.infrastructure.CompanyRepository;
import com.qhapaq.hackthon1_pb.restriction.repository.RestrictionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestrictionService {

    private final RestrictionRepository restrictionRepository;
    private final CompanyRepository companyRepository;
    private final AIModelRepository aiModelRepository;

    public Restriction createRestriction(Long companyId, Long modelId, Long maxTokens, Long maxRequests, Duration windowDuration) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        AIModel model = aiModelRepository.findById(modelId)
                .orElseThrow(() -> new RuntimeException("AI Model not found"));

        Restriction restriction = Restriction.builder()
                .company(company)
                .model(model)
                .maxTokensPerWindow(maxTokens)
                .maxRequestPerWindow(maxRequests)
                .windowDuration(windowDuration)
                .build();

        return restrictionRepository.save(restriction);
    }

    public List<Restriction> getRestrictionsByCompany(Long companyId) {
        return restrictionRepository.findByCompanyId(companyId);
    }

    public Restriction updateRestriction(Long restrictionId, Long maxTokens, Long maxRequests, Duration windowDuration) {
        Restriction restriction = restrictionRepository.findById(restrictionId)
                .orElseThrow(() -> new RuntimeException("Restriction not found"));

        restriction.setMaxTokensPerWindow(maxTokens);
        restriction.setMaxRequestPerWindow(maxRequests);
        restriction.setWindowDuration(windowDuration);

        return restrictionRepository.save(restriction);
    }

    public void deleteRestriction(Long restrictionId) {
        restrictionRepository.deleteById(restrictionId);
    }
}
