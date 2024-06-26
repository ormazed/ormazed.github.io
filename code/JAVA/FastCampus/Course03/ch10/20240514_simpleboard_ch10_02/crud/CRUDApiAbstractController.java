package com.example.simpleboard.crud;

import com.example.simpleboard.common.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public abstract class CRUDApiAbstractController<DTO, ENTITY> implements CRUDInterface<DTO>{

    @Autowired(required = false)
    private CRUDAbstractService<DTO, ENTITY> crudAbstractService;

    @Override
    @PostMapping("")
    public DTO create(
            @Valid
            @RequestBody
            DTO dto
    ) {
        return crudAbstractService.create(dto);
    }

    @GetMapping("/id/{id}")
    @Override
    public Optional<DTO> read(
            @PathVariable
            Long id
    ) {
        return crudAbstractService.read(id);
    }

    @Override
    @PutMapping("")
    public DTO update(
            @PathVariable
            @Valid
            DTO dto
    ) {
        return crudAbstractService.update(dto);
    }

    @Override
    @DeleteMapping("")
    public void delete(
            @PathVariable
            Long id
    ) {
        crudAbstractService.delete(id);

    }

    @GetMapping("/all")
    @Override
    public Api<List<DTO>> list(
            @PageableDefault
            Pageable pageable
    ) {
        return crudAbstractService.list(pageable);
    }
}
