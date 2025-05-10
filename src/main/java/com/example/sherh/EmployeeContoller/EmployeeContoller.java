package com.example.sherh.EmployeeContoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sherh.atrbrut.Employee;
import com.example.sherh.service.EmployeeService;

@Controller
public class EmployeeContoller {

	 @Autowired
	    private EmployeeService service;

	 @GetMapping("/")
	 public String add(Model model) {
	     List<Employee> listemployee = service.listAll();
	     model.addAttribute("listemployee", listemployee); // ← لازم تضيف القائمة
	     model.addAttribute("emplo", new Employee());    // ← فورم فاضي للبحث أو الإضافة
	     return "index";
	 }

	 @PostMapping("/search")
	 public String doSearchEmployee(@ModelAttribute("emplo") Employee formData, Model model) {

	     List<Employee> results = new ArrayList<>();

	     boolean searched = false;

	     if (formData.getEmployeeNumber() != null && !formData.getEmployeeNumber().isEmpty()) {
	         results = service.searchByEmployeeNumber(formData.getEmployeeNumber());
	         searched = true;
	     }

	     if (!searched && formData.getEname() != null && !formData.getEname().isEmpty()) {
	         results = service.searchByName(formData.getEname());
	         searched = true;
	     }

	     model.addAttribute("listemployee", results);
	     model.addAttribute("emplo", new Employee());
	     return "index";
	 }

	   
	    
	    
	    
	    @GetMapping("/newaddition")
		 public String addd(Model model) {
		     model.addAttribute("Employee", new Employee());
		     return "newaddition";
		 }
	
	
	    
	    @PostMapping("/save")
		 public String save(@ModelAttribute("Employee") Employee mohmmed) {
		     service.save(mohmmed);
		     return "redirect:/";
		 }
	    
	    
	    
	    
	    
	    
	    @GetMapping("/edit/{id}")
	    public String showEditForm(@PathVariable("id") Long id, Model model) {
	        Employee emp = service.get(id);
	        model.addAttribute("emplo", emp);
	        return "edit"; // ← صفحة تعديل مستقلة
	    }


	    
	    @PostMapping("/updateEmployee")
	    public String updateEmployee(@ModelAttribute("emplo") Employee emplo) {
	        service.save(emplo); // ← نفس الدالة، لو فيه ID بيعمل تحديث
	        return "redirect:/";
	    }

	    
	    
	    @GetMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable Long id) {
	        service.delete(id);  // ← احذف الموظف من قاعدة البيانات
	        return "redirect:/"; // ← ارجع للصفحة الرئيسية بعد الحذف
	    }

	    @GetMapping("/about")
	    public String aboutPage() {
	        return "about";
	    }

	    
}
