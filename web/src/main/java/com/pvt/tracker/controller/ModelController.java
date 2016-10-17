package com.pvt.tracker.controller;

import com.pvt.tracker.beans.Model;
import com.pvt.tracker.services.IModelService;
import com.pvt.tracker.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping ("/model")
public class ModelController{

	@Autowired
	private IUserService userService;
	@Autowired
	private IModelService modelService;

	@SuppressWarnings("unchecked")
	@RequestMapping (value = "/models/main", method = RequestMethod.GET)
	public String mainPage(ModelMap model) {
		getModelsTree(modelService.getAll());
		return "models/main";
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String userInfo() {
		return "models/info";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/createModel", method = RequestMethod.POST)
	public String createModel(@ModelAttribute("model") Model model){
		if (model.getId() == 0) {
			this.modelService.create(model);
		} else {
			this.modelService.update(model);
		}
		return "redirect:models/main";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteModel")
	public String deleteModelById(@ModelAttribute("model") Model model, ModelMap modelMap) {
		if (model != null) {
			this.modelService.delete(model);
			modelMap.put("message", "Model: " + model.getName() + " was deleted");
		}
		return "redirect:/models/main";
	}

	@RequestMapping("/updateModel/{id}")
	public String updateModel(@PathVariable ("id") int id, @ModelAttribute("model") ModelMap model) {
		model.addAttribute("model", this.modelService.getById(id));
		model.addAttribute("getAllModels", this.modelService.getAll());
		return "redirect:/models/main";
	}

	private Map<Model, List<Model>> getModelsTree(List<Model> projects) {
		Map<Model, List<Model>> tree = new HashMap<>();
		for(Model task : projects) {
			if (task.getCreator().getId() == 0) {
				List<Model> subModuls = new ArrayList<>();
				for (Model subTask : projects) {
					if (subTask.getCreator().getId() == task.getId()) {
						subModuls.add(subTask);
					}
				}
				tree.put(task, subModuls);
			}
		}
		return tree;
	}

	private Date getDateFromString(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
