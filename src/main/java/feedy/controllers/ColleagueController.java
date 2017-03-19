package feedy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feedy.domain.Colleague;
import feedy.services.ColleagueService;

@Controller
public class ColleagueController {

	private ColleagueService colleagueService;

	@Autowired
	public void setColleagueService(ColleagueService colleagueService) {
		this.colleagueService = colleagueService;
	}

	@RequestMapping(value = "/colleagues", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("colleagues", colleagueService.listAll());
		return "colleagues";
	}

	@RequestMapping("colleague/show/{id}")
	public String showColleague(@PathVariable Integer id, Model model) {
		model.addAttribute("colleague", colleagueService.getById(id));
		return "colleagueshow";
	}

	@RequestMapping("colleague/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("colleague", colleagueService.getById(id));
		return "colleagueform";
	}

	@RequestMapping("colleague/new")
	public String newColleague(Model model) {
		model.addAttribute("colleague", new Colleague());
		return "colleagueform";
	}

	@RequestMapping(value = "colleague", method = RequestMethod.POST)
	public String saveColleague(Colleague colleague) {
		colleagueService.saveOrUpdate(colleague);
		return "redirect:/colleague/show/" + colleague.getId();
	}

	@RequestMapping("colleague/delete/{id}")
	public String delete(@PathVariable Integer id) {
		colleagueService.delete(id);
		return "redirect:/colleagues";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

}
