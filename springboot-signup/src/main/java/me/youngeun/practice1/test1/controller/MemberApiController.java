package me.youngeun.practice1.test1.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.youngeun.practice1.test1.model.dto.MemberRequestDto;
import me.youngeun.practice1.test1.model.dto.MemberResponseDto;
import me.youngeun.practice1.test1.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/signup")
    public String signup2(@RequestBody MemberRequestDto requestDto) {
        MemberResponseDto memberResponseDto = null;
        try {
            memberResponseDto = memberService.signup(requestDto);
        } catch(RuntimeException e) {
            ResponseEntity.status(HttpServletResponse.SC_CONFLICT).body(requestDto.toMemberResponseDto(requestDto));
        }

        return "redirect:/login";
    }

}
