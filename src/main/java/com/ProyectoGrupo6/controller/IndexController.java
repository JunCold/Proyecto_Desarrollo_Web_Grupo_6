
package com.ProyectoGrupo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.ProyectoGrupo6.serviceImpl.FirebaseStorageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String page(Model model) {
       
        return "index";
    }
    
}
