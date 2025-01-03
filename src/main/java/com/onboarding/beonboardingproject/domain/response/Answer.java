package com.onboarding.beonboardingproject.domain.response;

import com.onboarding.beonboardingproject.domain.survey.Question;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "answer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id")
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "response_id", nullable = false)
    private Response response; // 어떤 응답(Response)와 연결되어 있는지

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question; // 어떤 질문에 대한 응답인지 연결

    @Column(nullable = false)
    private String answerValue; // 사용자가 입력한 응답 텍스트

    @Column
    @Setter
    private boolean deletedQuestion = false; // 삭제된 질문인지 여부
}
