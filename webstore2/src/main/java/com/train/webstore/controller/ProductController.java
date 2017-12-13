package com.train.webstore.controller;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.train.webstore.domain.Product;
import com.train.webstore.service.ProductService;

@Controller
//@RequestMapping("/products")
public class ProductController {
	
	
	@InitBinder
	public void initWebData(WebDataBinder wdb){
		wdb.setDisallowedFields("unitsInOrder","discontinued");
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		CustomDateEditor cde = new CustomDateEditor(df, true);
		
		wdb.registerCustomEditor(Date.class, cde);
		
		
	}
	
	

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list")// /prodts/list
	public String list(Model model){
	
		model.addAttribute("products",productService.getAllProducts());
		
	
		return "products";
	}
	
	@RequestMapping("/list2")// /prodts/list
	public ModelAndView list(){
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("products",productService.getAllProducts());
		mv.setViewName("products");
		
	
		return mv;
	}
	
	@RequestMapping("/products/{category}")
	public String findProductByCategory(Model model,@PathVariable("category") String category){
		
		model.addAttribute("products",productService.getProductsByCategory(category));
		
		return "products";
	}
	
	
	
//	@RequestMapping("/")// /prodts/list  /
	public String welcome(Model model){
	
		//model.addAttribute("products",productService.getAllProducts());
		
		model.addAttribute("welcome","welocme webstore");
	
		return "welcome";
	}
	@RequestMapping("/order")
	public String order(Model model ,@RequestParam String pid,@RequestParam int quantity){
		
		productService.orderProduct(pid, quantity);
		
		return "redirect:/list";

		
	}
	
	
	@RequestMapping("/filter/{ByCriteria}")//filter/byCriteria;brand=google,dell;category=tv,phone;byCriteria2;brand=google,dell;category=tv,phone
	
	public String getProductsByFilter(Model model,@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterMap){
		
		System.out.println("by filter....");
		model.addAttribute("products",productService.getProductsByFilter(filterMap));
		
		
		return "products"; 
	}
	
	@RequestMapping("/tablet/{byPrice}")//filter/byCriteria;brand=google,dell;category=tv,phone;byCriteria2;brand=google,dell;category=tv,phone
	
	public String getProductsByPrice(Model model,@MatrixVariable(pathVar="byPrice") Map<String,List<String>> filterMap,@RequestParam String brand){
		
		//System.out.println("by filter....");
	//	model.addAttribute("products",productService.getProductsByPrice(filterMap,brand));
		
		
		return "products"; 
	}
	
	
	@RequestMapping("/product")
	public String showProductById(Model model,@RequestParam("pid") String productId){
		
		
		model.addAttribute("product",productService.getProductById(productId));
		
		
		return "product";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET )
	public String toAddProductForm(Model model){
		
		Product newProduct = new Product();
		newProduct.setPubDate(new Date());
		newProduct.setUnitsInStock(100l);
		newProduct.setCondition("new");
		model.addAttribute("newProduct",newProduct);
		
		System.out.println("to addProduct!!!");
		return "addProduct";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveProduct(Model model,
			@ModelAttribute("newProduct") Product newProduct,
			BindingResult bindingResult,
			HttpServletRequest request 
			)
	{
		
		if(bindingResult.getSuppressedFields().length>0){
			System.out.println(bindingResult.getSuppressedFields());
			throw new RuntimeException("有不允许提交的域");
		}
		
		System.out.println(newProduct.getPubDate());
		
		String filePath = request.getServletContext().getRealPath("/");
		
		MultipartFile imageFile = newProduct.getProductImageFile();
		System.out.println(imageFile.getOriginalFilename());
		String myTime = System.currentTimeMillis()+"";
		System.out.println(myTime);
		
		filePath = filePath+"/images/"+newProduct.getProductId()+".jpg";
		System.out.println(filePath);
		try {
			imageFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(filePath);
		
		
		System.out.println("saveProduct.....");
		productService.addProduct(newProduct);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/showPromoProduct")
	public String promoProductSuccess(Model model){
		return "showPromoProduct";
	}
	
	@RequestMapping("/promoCodeError")
	public String promoProductError(){
		return "promoProductError";
	}
	
	
	@RequestMapping("/orderPromoCode")
	public String toPromoProductSuccess(Model model){
		return "showPromoProduct";
	}

}
