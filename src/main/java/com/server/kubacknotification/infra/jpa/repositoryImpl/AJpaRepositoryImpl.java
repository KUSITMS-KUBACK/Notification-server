package com.server.kubacknotification.infra.jpa.repositoryImpl;

import com.server.kubacknotification.domain.entity.A;
import com.server.kubacknotification.domain.repository.ARepository;
import com.server.kubacknotification.infra.jpa.repository.AJpaRepository;
import com.server.kubacknotification.infra.mapper.AMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AJpaRepositoryImpl implements ARepository {
    private final AJpaRepository aJpaRepository;
    private final AMapper aMapper;


    @Override
    public A findById(Long id) {
        return aMapper.toDomain(aJpaRepository.findById(id).orElseThrow());
    }
}
