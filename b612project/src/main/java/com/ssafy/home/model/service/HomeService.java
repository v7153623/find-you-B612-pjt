package com.ssafy.home.model.service;

import java.util.List;

import com.ssafy.home.model.dto.Home;
import com.ssafy.home.model.dto.HouseInfoDto;
import com.ssafy.home.model.dto.SidoGugunCodeDto;

public interface HomeService {
	
	List<Home> homeListByDong(String dongName);
	List<Home> homeListBySiGunGu(String siGunGuName);
	List<Home> homeListBySiDo(String siDoName);
	List<Home> homeListByApt(String aptName);
	
	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getAptInDong(String dong) throws Exception;
}
