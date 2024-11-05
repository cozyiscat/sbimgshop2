package kr.co.cofile.sbimgshop2.common.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class pageDTO<T> {
	private int page;
	private int size;
	private int totalPages;
	private long totalElement;
	private List<T> content;
}
