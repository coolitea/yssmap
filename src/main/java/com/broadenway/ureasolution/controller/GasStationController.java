package com.broadenway.ureasolution.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.broadenway.ureasolution.domain.GasStationDto;
import com.broadenway.ureasolution.service.GasStationService;

import lombok.RequiredArgsConstructor;

@Controller()
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class GasStationController {

	private final GasStationService gasStationService;

	@Value("${kakao-map-key}")
	private String kakaoMapKey;

	@RequestMapping("/station-list")
	public ModelAndView getStations() {
		List<GasStationDto> gasStationDatas = gasStationService.findAll()
			.stream()
			.map(GasStationDto::from)
			.collect(Collectors.toList());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("gasStations", gasStationDatas);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/")
	public ModelAndView getStationsView() {
		List<GasStationDto> gasStationDatas = gasStationService.findAll()
			.stream()
			.map(GasStationDto::from)
			.collect(Collectors.toList());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("gasStations", gasStationDatas);
		modelAndView.addObject("mapKey", kakaoMapKey);
		modelAndView.setViewName("stations-view");
		return modelAndView;
	}
}
