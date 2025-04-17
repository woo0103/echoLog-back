package com.deli.echolog.dto.transformDiary;

import com.deli.echolog.domain.TransformDiary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransformDiaryResponseDto {
    private Long transformDiaryId;
    private String content;

    public static TransformDiaryResponseDto from(TransformDiary transformDiary) {
        return new TransformDiaryResponseDto(
                transformDiary.getId(), transformDiary.getContent()
        );
    }
}
