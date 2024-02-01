package dev.spring.petclinic.controller;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller // 스프링 빈으로 등록
@RequestMapping("/owners") // 요청 경로 맵핑, localhost:8080/owners로 요청할 경우 OwnerController가 담당
public class OwnerController {

    private final OwnerService ownerService;

    // GET: localhost:8080/owners/find
    @RequestMapping(path = "/find")
    public String findOwners(Model model) {
        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);

        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindResult result, Model model) {
        System.out.println("owner.getLastName() = " + owner.getLastName() + " " + owner.getFirstName());
        if (owner.getLastName().isEmpty()) {
            owner.setLastName("");
        }
        List<Owner> owners = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        model.addAttribute("listOwners", owners);

        return "owners/ownersList";
    }

    @GetMapping("/{id}")
    public String ownerDetailPage(Owner owner, Model model) {
        Optional<Owner> findOwner = ownerService.findById(owner.getId());
        System.out.println("findOwner = " + findOwner.get().getLastName());
        model.addAttribute("owner", findOwner.get());

        return "owners/ownerDetails";
    }
}
