package com.sacumen.hiretalent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.sacumen.hiretalent.domain.Candidate;
import com.sacumen.hiretalent.domain.Requisition;
import com.sacumen.hiretalent.domain.User;
import com.sacumen.hiretalent.repository.UserRepository;
import com.sacumen.hiretalent.service.CandidateService;
import com.sacumen.hiretalent.service.RequisitionService;

@Controller
public class RequisitionController   {
	
	@Autowired
	private RequisitionService requisitionService;
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private UserRepository repository;
	
	/**
	 * This method is used to display the Home page
	 * 
	 * @return
	 */
	@GetMapping("/homepage")
	public String showHomePage() {
		return "requisition/home";
	}

	/**
	 * This method is used to display the Requisition Details page
	 * 
	 * @param modelMap
	 * @param requisitionId
	 * @return
	 */
	@GetMapping("/requisitionDetail")
	public String getRequisitionDetail(ModelMap modelMap, @RequestParam(required = false) String requisitionId) {
		modelMap.put("requisitions", requisitionService.findAllByRequisitionId(requisitionId));
		modelMap.put("candidates", candidateService.findAll(requisitionId));
		modelMap.put("countid", candidateService.countByRequisitionId(requisitionId));
		modelMap.put("countl1", candidateService.countByL1(requisitionId));
		modelMap.put("countl2", candidateService.countByL2(requisitionId));
		modelMap.put("countl3", candidateService.countByL3(requisitionId));
		return "requisition/requisitionDetail";
	}

	/**
	 * This method is used to display the View Requisition Profile page 0r
	 * Requisition Details page based on from where you press the back button
	 * 
	 * @param modelMap
	 * @param isViewProfile
	 * @param pageable
	 * @param model
	 * @param requisitionId
	 * @return
	 */
	@GetMapping("/isViewProfile")
	public String getViewProfile(ModelMap modelMap, @RequestParam(required = false) boolean isViewProfile,
			Pageable pageable, Model model, @RequestParam(required = false) String requisitionId) {
		if (isViewProfile) {
			modelMap.put("requisitions", requisitionService.findAllByRequisitionId(requisitionId));
			modelMap.put("candidates", candidateService.findAll(requisitionId));
			modelMap.put("countid", candidateService.countByRequisitionId(requisitionId));
			modelMap.put("countl1", candidateService.countByL1(requisitionId));
			modelMap.put("countl2", candidateService.countByL2(requisitionId));
			modelMap.put("countl3", candidateService.countByL3(requisitionId));
			return "requisition/requisitionDetail";
		} else {
			Page<Candidate> pages = requisitionService.requisitionList(pageable);
			Iterator<Candidate> candidates = pages.iterator();
			model.addAttribute("number", pages.getNumber());
			model.addAttribute("totalPages", pages.getTotalPages());
			model.addAttribute("totalElements", pages.getTotalElements());
			model.addAttribute("size", pages.getSize());
			ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
			while (candidates.hasNext()) {
				Candidate candidate = candidates.next();
				if (candidate.getRequisition().getRequisitionId().equals(requisitionId)) {
					candidateList.add(candidate);
				}
			}
			model.addAttribute("candidates", candidateList);
			Iterable<Requisition> requisitions = requisitionService.findAllByRequisitionId(requisitionId);
			Requisition requisition = ((List<Requisition>) requisitions).get(0);
			modelMap.put("requisition", requisition);
			return "/requisition/viewProfile";
		}
	}

	/**
	 * This method is used to display the Add NewProfile page.
	 * 
	 * @param modelMap
	 * @param isViewProfile
	 * @param requisitionId
	 * @return
	 */
	@GetMapping("/addnewprofile")
	public String addnewprofile(ModelMap modelMap, @RequestParam(required = false) boolean isViewProfile,
			@RequestParam(required = false) String requisitionId) {
		modelMap.put("isViewProfile", isViewProfile);
		Iterable<Requisition> requisitions = requisitionService.findAllByRequisitionId(requisitionId);
		Requisition requisition = ((List<Requisition>) requisitions).get(0);
		modelMap.put("requisition", requisition);
		modelMap.put("sourceTypes", candidateService.findAllSourceTypes());
		return "requisition/addNewProfile";
	}

	/**
	 * This method is used to display View Profiles page and apply the pagination
	 * 
	 * @param model
	 * @param pageable
	 * @param modelMap
	 * @param requisitionId
	 * @return
	 */
	@GetMapping("/viewprofile")
	public String CandidateList(Model model, Pageable pageable, ModelMap modelMap,@RequestParam(required = false) String requisitionId) {
		Page<Candidate> pages = requisitionService.requisitionList(pageable);
		Iterator<Candidate> candidates = pages.iterator();
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		while (candidates.hasNext()) {
			Candidate candidate = candidates.next();
			if (candidate.getRequisition().getRequisitionId().equals(requisitionId)) {
				candidateList.add(candidate);
			}
		}
		model.addAttribute("candidates", candidateList);
		Iterable<Requisition> requisitions = requisitionService.findAllByRequisitionId(requisitionId);
		Requisition requisition = ((List<Requisition>) requisitions).get(0);
		modelMap.put("requisition", requisition);
		return "/requisition/viewProfile";
	}

	/**
	 * This method is to display the Create Requisition page.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/createRequisition")
	public String getCreateRequisition(ModelMap modelMap) {
		modelMap.put("projects", requisitionService.findProject());
		modelMap.put("designations", requisitionService.findDesignation());
		return "requisition/createRequisition";
	}

	/**
	 * This method is to save the Requisition and to display the View Requisition
	 * page.
	 * 
	 * @param requisition
	 * @return
	 */
	@RequestMapping("/viewrequisition")
	public String saveData(Requisition requisition) {
		requisitionService.create(requisition);
		return "requisition/viewRequisition";
	}

	/**
	 * This method is used to display the View Requisition page.
	 * 
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/viewrequisition")
	public String getViewrequisition(ModelMap modelMap) {
		return "requisition/viewRequisition";
	}

	/**
	 * This method is used to apply the pagination for Status Open page.
	 * 
	 * @param model
	 * @param pageable
	 * @param requisition_status
	 * @return
	 */
	@GetMapping("/statusopen")
	public String viewRequisitionList(Model model, Pageable pageable, String requisition_status) {
		Page<Requisition> pages = requisitionService.viewrequisitionList(pageable, requisition_status);
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		model.addAttribute("viewrequisitions", pages.getContent());
		return "requisition/statusOpen";
	}

	/**
	 * This method is used to apply the pagination for Status Close page.
	 * 
	 * @param model
	 * @param pageable
	 * @param requisition_status
	 * @return
	 */
	@GetMapping("/statusclose")
	public String viewRequisitionListAll(Model model, Pageable pageable, String requisition_status) {
		Page<Requisition> pages = requisitionService.viewrequisitionListAll(pageable, requisition_status);
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		model.addAttribute("viewreq", pages.getContent());
		return "requisition/statusClose";
	}

	/**
	 * This method is used to save the Add New Profiles page and display View Profiles page
	 * 
	 * @param modelMap
	 * @param candidate
	 * @param pageable
	 * @param model
	 * @param requisitionId
	 * @return
	 */
	@PostMapping("/viewprofile")
	public String saveAddNewProfile(Candidate candidate, Model model, Pageable pageable, ModelMap modelMap,@RequestParam(required = false) String requisitionId
			,@RequestParam("files") MultipartFile[] files) throws IOException {
		Iterable<Requisition> requisitions = requisitionService.list();
		List<Requisition> requisitionList = ((List<Requisition>) requisitions);
		Requisition requisition = null;
		for (int i = 0; i <= requisitionList.size(); i++) {
			if (requisitionList.get(i).getRequisitionId().equals(requisitionId)) {
				requisition = requisitionList.get(i);
				break;
			}
		}
		candidate.setRequisition(requisition);
		candidate.setCandidateStatus("Sourced");
		for (MultipartFile file: files) {
			candidateService.saveCandidate(candidate,file);
		}
		Page<Candidate> pages = requisitionService.requisitionList(pageable);
		Iterator<Candidate> candidates = pages.iterator();
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		while (candidates.hasNext()) {
			Candidate candidateNext = candidates.next();
			if (candidateNext.getRequisition().getRequisitionId().equals(requisitionId)) {
				candidateList.add(candidateNext);
			}
		}
		model.addAttribute("candidates", candidateList);
		Iterable<Requisition> requisitionIterable = requisitionService.findAllByRequisitionId(requisitionId);
		Requisition requisitionFirst = ((List<Requisition>) requisitionIterable).get(0);
		modelMap.put("requisition", requisitionFirst);
		return "/requisition/viewProfile";
	}

	/**
	 * This method is used to download the candidate resume
	 * 
	 * @param candidateId
	 */
	@GetMapping("/downloadFile/{candidateId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String candidateId){
		Candidate candidate = candidateService.getFile(candidateId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(candidate.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+candidate.getDocName()+"\"")
				.body(new ByteArrayResource(candidate.getData()));
	}

	/**
	 * This method is used to login
	 * 
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "requisition/login";
	}
	
	/**
	 * This method is used to password recovery
	 * 
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/passwordrecovery")
	public String passwordrecovery(ModelMap modelMap) {
		modelMap.put("passwordrecoverys", requisitionService.findAll());
		return "requisition/passwordrecovery";
	}
	
	/**
	 * This method is used to display Add User Page.
	 * 
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/addUser")
	public String adduser(ModelMap modelMap) {
		modelMap.put("roles", requisitionService.findRoles());
		return "requisition/adduser";
	}
	
	/**
	 * This method is used to save Add User Page.
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String saveAddUser(User user) {
		repository.save(user);
		return "requisition/adduser";
	}
}