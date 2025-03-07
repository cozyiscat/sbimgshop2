package kr.co.cofile.sbimgshop2.common.exception;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
	private final String code;
	private final String message;
	private final int status;
	private final LocalDateTime timestamp;

	//해당 필드가 null일 경우 JSON 직렬화 시 해당 필드는 제외시켜 응답 크기를 줄임
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private final Map<String, String> errors;
	
	public static ErrorResponse of(ErrorCode errorCode) {
		return ErrorResponse.builder()
				.code(errorCode.getCode())
				.message(errorCode.getMessage())
				.status(errorCode.getStatus())
				.timestamp(LocalDateTime.now())
				.build();
	}
	public static ErrorResponse of(ErrorCode errorCode, Map<String, String> errors) {
		return ErrorResponse.builder()
				.code(errorCode.getCode())
				.message(errorCode.getMessage())
				.status(errorCode.getStatus())
				.timestamp(LocalDateTime.now())
				.build();
	}
	
	//맵으로 변환
		public static Map<String, String>
		bindingResultToMap(BindingResult bindingResult){
			return bindingResult.getFieldErrors().stream()
					.collect(Collectors.toMap(
							FieldError::getField,
							fieldError ->
							Optional.ofNullable(fieldError.getDefaultMessage())
								.orElse("Invalid value"),
								(existing, replacement) -> existing
								//중복된 필드의 경우 첫번째 에러 메세지 유지
							));
		}
}
