package dev.spring.petclinic.controller;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller // 스프링 빈으로 등록
@RequestMapping("/owners") // 요청 경로 맵핑, localhost:8080/owners로 요청할 경우 OwnerController가 담당
public class OwnerController {

    private final OwnerService ownerService;

    // owner 추가, 갱신 기능 구현을 위한 html 파일 경로
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";


    // GET: localhost:8080/owners/find
    @RequestMapping(path = "/find")
    public String findOwners(Model model) {
        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);

        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, Model model) {

        if (owner.getLastName().isEmpty()) {
            owner.setLastName("");
        }
        List<Owner> owners = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if (owners.size() > 1) {
            log.info("1명이상");
            model.addAttribute("listOwners", owners);
            return "owners/ownersList";
        } else if (owners.size() == 1) {
            log.info("1명");
            model.addAttribute("owner", owners.get(0));
            return "owners/ownerDetails";
        } else {
            log.info("owner가 존재하지 않습니다.");
            return "error";
        }
    }

    @GetMapping("/{id}")
    public String ownerDetailPage(Owner owner, Model model) {
        Optional<Owner> findOwner = ownerService.findById(owner.getId());

        model.addAttribute("owner", findOwner.get());

        return "owners/ownerDetails";
    }

    @GetMapping("/new")
    public String createOwnerForm(Model model) {
        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String createOwner(Owner owner, Model model) {
        Owner saveOwner = ownerService.save(owner);
        model.addAttribute("owner", saveOwner);

        return "owners/findOwners";
    }

    @GetMapping("/{id}/edit")
    public String updateOwnerForm(Owner owner, Model model) {
        Optional<Owner> findOwner = ownerService.findById(owner.getId());
        model.addAttribute("owner", findOwner.get());

        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{id}/edit")
    public String updateOwner(Owner owner, Model model) {
        Owner updateOwner = ownerService.update(owner);
        model.addAttribute("owner", updateOwner);

        return "redirect:/owners?lastName=";
    }


}
