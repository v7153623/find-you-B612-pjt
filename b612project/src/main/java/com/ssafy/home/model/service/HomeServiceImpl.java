package com.ssafy.home.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.home.model.dao.HomeDao;
import com.ssafy.home.model.dto.Home;
import com.ssafy.home.model.dto.HouseInfoDto;
import com.ssafy.home.model.dto.SidoGugunCodeDto;

@Service
public class HomeServiceImpl implements HomeService {

	HomeDao dao;
	
	public HomeServiceImpl(HomeDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Home> homeListByDong(String dongName) {
		return dao.homeListByDong(dongName);
	}

	@Override
	public List<Home> homeListBySiGunGu(String siGunGuName) {
		return dao.homeListBySiGunGu(siGunGuName);
	}

	@Override
	public List<Home> homeListBySiDo(String siDoName) {
		return dao.homeListBySiDo(siDoName);
	}

	@Override
	public List<Home> homeListByApt(String aptName) {
		return dao.homeListByApt(aptName);
	}
	
	
	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return dao.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return dao.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return dao.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return dao.getAptInDong(dong);
	}

}
