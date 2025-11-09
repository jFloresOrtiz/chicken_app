package com.chicken.inventario.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chicken.inventario.Model.Inventario;
import com.chicken.inventario.Model.Response;
import com.chicken.inventario.Service.InventarioService;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {
    private InventarioService service;
    public InventarioController(InventarioService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<Response<List<Inventario>>> GetProduct(@RequestParam String codigo){
        return service.GetProductByCode(codigo);
    }
}
