package com.ssafy.newkids.api.service.member;

import com.ssafy.newkids.IntegrationTestSupport;
import com.ssafy.newkids.api.controller.member.response.MemberResponse;
import com.ssafy.newkids.domain.member.Member;
import com.ssafy.newkids.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class AccountServiceTest extends IntegrationTestSupport {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("이메일로 회원 정보를 조회할 수 있다.")
    @Test
    void getMemberInfo() {
        //given
        Member member = createMember();

        //when
        MemberResponse response = accountService.getMemberInfo("ssafy@ssafy.com");

        //then
        assertThat(response)
            .extracting("name", "age", "level", "exp", "nickname")
            .containsExactlyInAnyOrder("김싸피", 10, 1, 0, "광주C205");
    }

    @DisplayName("이미 등록된 이메일이라면 true를 반환한다.")
    @Test
    void checkEmailWithTrue() {
        //given
        Member member = createMember();

        //when
        boolean result = accountService.checkEmail("ssafy@ssafy.com");

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("사용 가능한 이메일이라면 false를 반환한다.")
    @Test
    void checkEmailWithFalse() {
        //given

        //when
        boolean result = accountService.checkEmail("ssafy@ssafy.com");

        //then
        assertThat(result).isFalse();
    }

    private Member createMember() {
        Member member = Member.builder()
            .email("ssafy@ssafy.com")
            .encryptedPwd("encryptedPwd")
            .name("김싸피")
            .age(10)
            .level(1)
            .exp(0)
            .nickname("광주C205")
            .active(true)
            .build();
        return memberRepository.save(member);
    }
}