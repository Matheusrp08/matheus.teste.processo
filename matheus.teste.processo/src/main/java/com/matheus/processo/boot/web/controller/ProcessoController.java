package com.matheus.processo.boot.web.controller;

import java.time.LocalDate;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matheus.processo.boot.domain.Reu;
import com.matheus.processo.boot.domain.UF;
import com.matheus.processo.boot.service.ProcessoService;
import com.matheus.processo.boot.web.validator.ProcessoValidator;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/processos")
public class ProcessoController {

	@Autowired
	private ProcessoService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	binder.addValidators(new ProcessoValidator());
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Reu reu) {
		System.out.println("passou aqui");
		return "processo/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		try {
			model.addAttribute("processos", service.buscarTodos());
		} catch (Exception e) {
			// mensagemErro();
		}
		return "processo/lista";

	}

	@PostMapping("/salvar")
	public String salvar(@Valid Reu reu, BindingResult result, RedirectAttributes attr) {
		try {
			if (result.hasErrors())
				return "processo/cadastro";
			service.salvar(reu);
			attr.addFlashAttribute("success", "Processo enviado com sucesso.");
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Número do Processo já Existe");
		}
		return "redirect:/processos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		// System.out.println("passou aqui2");
		if (id != null) {
			try {
				model.addAttribute("reu", service.buscarPorId(id));
			} catch (Exception e) {
				attr.addFlashAttribute("fail", "Ocorreu um erro.");
				System.out.println("entrou aqui");
				return "redirect:/processos/listar";
			}
		} else {
			attr.addFlashAttribute("fail", "Número do Processo está Nulo!.");
			return "redirect:/processos/listar";
		}
		return "processo/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Reu reu, BindingResult result, RedirectAttributes attr) {
		// System.out.println("passou aqui3");
		try {
			if (result.hasErrors())
				return "processo/cadastro";
			service.editar(reu);
			attr.addFlashAttribute("success", "Processo editado com sucesso.");
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Ocorreu um erro..");
			return "redirect:/processos/listar";
		}

		return "redirect:/processos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		try {
			service.excluir(id);
			attr.addFlashAttribute("success", "Processo excluído com sucesso");
		} catch (Exception e) {
		}
		return "redirect:/processos/listar";
	}

	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model, RedirectAttributes attr) {
		// System.out.println("passou aqui4");
		try {
			model.addAttribute("processos", service.buscarPorNome(nome));
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Não encontrado.");
			return "redirect:/processos/listar";
		}
		return "processo/lista";
	}

	@GetMapping("/buscar/data")
	public String getPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
			@RequestParam("sai"
					+ "da") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida, ModelMap model,
			RedirectAttributes attr) {
		try {
			model.addAttribute("processos", service.buscarPorDatas(entrada, saida));
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Não encontrado.");
			return "redirect:/processos/listar";
		}

		return "processo/lista";
	}

	@ModelAttribute("ufs")
	public UF[] listaDeUFs() {
		return UF.values();
	}
}