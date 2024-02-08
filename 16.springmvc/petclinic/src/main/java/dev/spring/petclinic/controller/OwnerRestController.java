package dev.spring.petclinic.controller;

import dev.spring.petclinic.dto.OwnerRequest;
import dev.spring.petclinic.dto.OwnerResponse;
import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api/owners")
@RestController
public class OwnerRestController {

    private final OwnerService ownerService;

    /**
     * Owners 전체 정보 조회
     */
    @GetMapping
    public List<OwnerResponse> listOwners() {

        List<Owner> ownerList = ownerService.findAll();
        // DTO 변환
        List<OwnerResponse> ownerResponseList = ownerList.stream()
                .map(OwnerResponse::fromWithPet)
                .collect(Collectors.toList());
        return ownerResponseList;
    }

    /**
     * 이름 검색 Owner 조회
     */
    @GetMapping("/search")
    public List<OwnerResponse> findOwner(@RequestParam String name) {
        List<Owner> ownerList = ownerService.findLastNameOrFirstName(name);
        return ownerList.stream()
                .map(OwnerResponse::fromWithPet)
                .collect(Collectors.toList());
    }

    /**
     * id로 회원
     */
    @GetMapping("/{id}")
    public OwnerResponse ownerFindById(@PathVariable Long id) {
        Optional<Owner> owner = ownerService.findById(id);
        return OwnerResponse.fromWithPet(owner.get());
    }

    /**
     * Owner 등록
     */
    @PostMapping
    public Owner addOwner(@RequestBody OwnerRequest ownerRequest) {
        Owner owner = ownerRequest.toEntity();
        return ownerService.save(owner);
    }

    /**
     * Owner 수정
     */
    @PatchMapping("/{id}")
    public Owner updateOwner(@PathVariable Long id, @RequestBody OwnerRequest ownerRequest) {
        Owner owner = ownerRequest.toEntity();
        return ownerService.update(id, owner);
    }

    /**
     * Owner 삭제
     */
    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        Optional<Owner> owner = ownerService.findById(id);
        ownerService.delete(owner.get());
    }
}
