package kr.co.cofile.sbimgshop2.codegroups;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeGroupMapper {
	
	@Insert("INSERT INTO code_group (group_code, group_name) VALUES (#{groupCode},#{groupName})")
	void create(CodeGroupDTO codeGroupDTO);
}
