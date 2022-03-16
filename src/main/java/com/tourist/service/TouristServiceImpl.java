package com.tourist.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourist.entity.Tourist;
import com.tourist.exception.TouristNotFoundException;
import com.tourist.repository.ITouristRepo;

@Service("touristService")
public class TouristServiceImpl implements ITouristService {

	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {
		int idVal = repo.save(tourist).getTouristId();
		return "Tourist is registered having the id value::" + idVal;
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist> list = repo.findAll();
		list.stream().sorted((t1, t2) -> t1.getTouristId().compareTo(t2.getTouristId())).collect(Collectors.toList());
		return list;
	}

	@Override
	public Tourist findByTourist(Integer touristId) throws TouristNotFoundException {
		Optional<Tourist> opt = repo.findById(touristId);
		return opt.orElseThrow(() -> new TouristNotFoundException(touristId + "Tourist not found"));
	}

	@Override
	public String updateTourist(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> opt = repo.findById(tourist.getTouristId());
		if (opt.isPresent()) {
			repo.save(tourist);
			return tourist.getTouristId() + "Tourist details are updated";
		} else {
			throw new TouristNotFoundException(tourist.getTouristId() + "Tourist not found");
		}
	}

	@Override
	public String deleteTourit(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> opt = repo.findById(tid);
		if (opt.isPresent()) {
			repo.delete(opt.get());
			return tid + "Tourist Deleted successfully";
		} else {
			throw new TouristNotFoundException("Tourist not found with this is TouristId");
		}
	}

}
