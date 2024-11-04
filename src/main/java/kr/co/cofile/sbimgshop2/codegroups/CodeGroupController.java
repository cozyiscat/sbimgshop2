package kr.co.cofile.sbimgshop2.codegroups;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kr.co.cofile.sbimgshop2.common.exception.CustomValidationException;
import kr.co.cofile.sbimgshop2.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/codegroups")
public class CodeGroupController {
	private final CodeGroupService codeGroupService;
	
	@PostMapping
	public ResponseEntity<CodeGroupDTO> register(@Valid @RequestBody CodeGroupDTO codeGroupDTO,
			BindingResult bindingResult) {
		log.info("register : {}",codeGroupDTO);
		if(bindingResult.hasErrors()) {
			throw new CustomValidationException(ErrorCode.VALIDATION_ERROR, bindingResult);
		}
		
		codeGroupService.register(codeGroupDTO);
		return ResponseEntity.ok(codeGroupDTO);
		}
	
}
