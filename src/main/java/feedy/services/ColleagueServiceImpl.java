package feedy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feedy.domain.Colleague;
import feedy.repositories.ColleagueRepository;

@Service
public class ColleagueServiceImpl implements ColleagueService {
	private ColleagueRepository colleagueRepository;

	@Autowired
	public void setColleagueRepository(ColleagueRepository colleagueRepository) {
		this.colleagueRepository = colleagueRepository;
	}

	@Override
	public List<?> listAll() {
		return (List<?>) colleagueRepository.findAll();
	}

	@Override
	public Colleague getById(Integer id) {

		return colleagueRepository.findOne(id);
	}

	@Override
	public Colleague saveOrUpdate(Colleague domainObject) {

		return colleagueRepository.save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		colleagueRepository.delete(id);

	}

	@Override
	public Colleague findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
