package com.example.simpleboard.crud;

import com.example.simpleboard.common.Api;
import com.example.simpleboard.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract  class CRUDAbstractService<DTO, ENTITY> implements CRUDInterface<DTO> {
    // dto  -> entity -> dto : dto 를 받아서 entity 로 바꾼 다음 특정한 작업을 하고 나서 다시 dto 로 반환
    @Autowired(required = false)
    private JpaRepository<ENTITY, Long> jpaRepository;
    @Autowired(required = false)
    private Converter<DTO, ENTITY> converter;

    @Override
    public DTO create(DTO dto) {

        // dto -> entity
        var entity = converter.toEntity(dto);
        // entity -> save
        jpaRepository.save(entity);
        // save -> dto
        var returnDto = converter.toDTO(entity);
        return returnDto;
    }

    @Override
    public Optional<DTO> read(Long id) {
        var optionEntity = jpaRepository.findById(id);
        var dto = optionEntity.map(
                it -> converter.toDTO(it)
        ).orElseGet(()->null);

        return Optional.ofNullable(dto);
    }

    @Override
    public DTO update(DTO dto) {
        var entity = converter.toEntity(dto);
        jpaRepository.save(entity);
        var returnDto = converter.toDTO(entity);
        return returnDto;
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Api<List<DTO>> list(Pageable pageable) {
        var list = jpaRepository.findAll(pageable);
        var pagination =  Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElements(list.getNumberOfElements())
                .totalElements(list.getTotalElements())
                .totalPage(list.getTotalPages())
                .build();
        var dtoList = list.stream()
                .map(it -> {
                    return converter.toDTO(it);
                }).collect(Collectors.toList());

        var response = Api.<List<DTO>>builder()
                .body(dtoList)
                .pagination(pagination)
                .build();
        return response;
    }
}
