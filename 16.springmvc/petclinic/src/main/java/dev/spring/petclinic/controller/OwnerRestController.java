package dev.spring.petclinic.controller;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/owners")
@RestController
public class OwnerRestController {

    private final OwnerService ownerService;

    @GetMapping
    public List<Owner> listOwners() {
        return ownerService.findAll();
    }
}
