package com.jbedu.member.dao;

import java.util.ArrayList;

import com.jbedu.member.dto.MemberDto;

public interface MemberDao {
	public void joinMemberDao(String mid, String mpw, String mname, String memail, int mage);
	public ArrayList<MemberDto> memberLitDao();
	public void memberDeleteDao(String mid);
}
