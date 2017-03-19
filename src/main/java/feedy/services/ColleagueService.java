package feedy.services;

import feedy.domain.Colleague;

public interface ColleagueService extends CRUDService<Colleague> {

	Colleague findByUsername(String username);

}
