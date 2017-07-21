package com.mertaydar.emw.service;

import java.util.List;

import com.mertaydar.emw.entity.Ban;
import com.mertaydar.emw.model.BanInfo;

public interface BanDAO {
	public Ban findBan(Integer id);
	public void saveBan (BanInfo banInfo);
	public BanInfo findBanInfo (Integer id);
	public void deleteBan (Integer id);
	
	public boolean isBanned (Integer userId);
	public List<BanInfo> banHistory(Integer userId);
	public void banUser (Integer userId,String explanation,Integer banDay);
	public void removeBan (Integer userId);
}
