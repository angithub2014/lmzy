package com.lmzy.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public interface BbsSelectService {
	public List<Map<String,Object>> selectBbsTopbicDigest();

}
