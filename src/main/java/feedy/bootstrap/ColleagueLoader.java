package feedy.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import feedy.domain.Colleague;
import feedy.repositories.ColleagueRepository;

@Component
public class ColleagueLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ColleagueRepository colleagueRepository;

	@Autowired
	public void setColleagueRepository(ColleagueRepository colleagueRepository) {
		this.colleagueRepository = colleagueRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		Colleague colleague = new Colleague();
		colleague.setFirstName("Andrea");
		colleague.setLastName("Calin");
		colleague.setAge(26);
		colleague.setPosition("Professional Java Developer");

		colleagueRepository.save(colleague);

		Colleague colleague1 = new Colleague();
		colleague1.setFirstName("Colcea");
		colleague1.setLastName("Gabriel");
		colleague1.setAge(29);
		colleague1.setPosition("Senior Java Developer");

		colleagueRepository.save(colleague1);
	}

}
