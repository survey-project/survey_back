package com.survey.Global.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 요청 성공 시 응답하는 코드 모임입니다.
 * @author : 황시준
 * @since : 1.0
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    // Member
    REGISTER_SUCCESS(200, "M001", "회원가입 되었습니다."),
    LOGIN_SUCCESS(200, "M002", "로그인 되었습니다."),
    REISSUE_SUCCESS(200, "M003", "재발급 되었습니다."),
    LOGOUT_SUCCESS(200, "M004", "로그아웃 되었습니다."),
    GET_MY_INFO_SUCCESS(200, "M005", "내 정보 조회 완료"),
    USER_UPDATE_SUCCESS(200, "M006", "회원정보 수정 완료"),
    DELETE_USER_SUCCESS(200, "M007", "회원정보 삭제 완료"),

    CREATE_JOB_REQUEST_SUCCESS(200, "R001", "등록 되었습니다"),
    GET_JOB_STATUS_REQUEST_SUCCESS(200, "R002", "조회 되었습니다"),
    RUN_JOB_REQUEST_SUCCESS(200, "R003", "실행 되었습니다."),

    CREATE_SURVEY_REQUEST_SUCCESS(200, "S001", "설문을 생성했습니다."),
    SUBMIT_SURVEY_REQUEST_SUCCESS(200, "S002", "설문을 제출했습니다."),
    GET_SURVEY_REQUEST_SUCCESS(200, "S003", "설문조사 결과를 불러왔습니다.");
    private int status;
    private final String code;
    private final String message;
}
