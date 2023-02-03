package com.ssafy.home.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.home.model.dto.Home;
import com.ssafy.home.model.dto.HouseInfoDto;
import com.ssafy.home.model.dto.SidoGugunCodeDto;

public interface HomeDao {
	
	List<Home> homeListByDong(String dongName);

	List<Home> homeListBySiGunGu(String siGunGuName);

	List<Home> homeListBySiDo(String siDoName);
	
	List<Home> homeListByApt(String aptName);
	
	List<SidoGugunCodeDto> getSido() throws SQLException;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;
	List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;
	List<HouseInfoDto> getAptInDong(String dong) throws SQLException;
}
