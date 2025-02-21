package ua.pudgecorporation.zxctube.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.pudgecorporation.zxctube.core.Identifiable;
import ua.pudgecorporation.zxctube.core.service.CommonCrudService;

@RequiredArgsConstructor
public class CommonController<DTO extends Identifiable> {
    private final CommonCrudService<DTO> service;

    @PostMapping("add")
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("find/{uuid}")
    public ResponseEntity<DTO> findByUuid(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(service.findByUuid(uuid));
    }

    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<DTO> delete(@PathVariable("uuid") String uuid) {
        service.delete(uuid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<DTO> update(@PathVariable("uuid") String uuid, @RequestBody DTO dto) {
        return ResponseEntity.ok(service.update(uuid, dto));
    }
}
