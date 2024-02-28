package org.example.orm_gestion_instituto.controller;

import org.example.orm_gestion_instituto.module.Alumno;
import org.example.orm_gestion_instituto.module.Direccion;
import org.example.orm_gestion_instituto.module.Modulo;
import org.example.orm_gestion_instituto.module.Profesor;
import org.example.orm_gestion_instituto.service.AlumnoService;
import org.example.orm_gestion_instituto.service.DireccionService;
import org.example.orm_gestion_instituto.service.ModuloService;
import org.example.orm_gestion_instituto.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/examen")
public class MiControlador {

    private final AlumnoService alumnoService;
    private final DireccionService direccionService;
    private final ModuloService moduloService;
    private final ProfesorService profesorService;
    //no se porque me sale un error aqui
    public MiControlador(AlumnoService alumnoService, DireccionService direccionService, ModuloService moduloService, ProfesorService profesorService) {
        this.alumnoService = alumnoService;
        this.direccionService = direccionService;
        this.moduloService = moduloService;
        this.profesorService = profesorService;
    }




    //este aparato no me dado tiempo a acabarlo
    @RequestMapping("/alumnado")
    public String alumando(Alumno alumno) {
        Alumno alumno = new Alumno(500,"bouhrich","hmidi",5662262,"fatine",55666334646,"");


        return "alumnado";
    }
    @RequestMapping("/profesorado")
    public String profesorado(Profesor profesor) {
        Profesor profesor1 = new profesor(500,"bouhrich","hmidi",5662262,"fatine",55666334646,"");


        return "profesorado";
    }
    @RequestMapping("/modulos")
    public String alumando(Alumno alumno) {
        Modulo modulo = new Modulo(500,"bouhrich","hmidi",5662262,"fatine",55666334646,"");


        return "modulos";
    }


/////////////////////


    //LISTAR
    @GetMapping(value = "/alumnado")
    public String listarAlumno(Alumno alumno) {
        List<Alumno> alumnos = alumnoService.getAllAlumnos();
        alumno.addAttribute("alumnos", alumnos);
        return "index";
    }

    @GetMapping(value = "/direcciones")
        public String listarDireccion (Direccion direccion){
            List<Direccion> direcciones = direccionService.getAllDirecciones();
            direccion.addAttribute("direcciones", direcciones);
            return "index";

    }

    @GetMapping(value = "/modulos")
    public String listarModulo (Modulo modulo){
        List<Modulo> modulos = moduloService.getAllModulos();
        modulo.addAttribute("modulos", modulos);
        return "index";

    }

    @GetMapping(value = "/profesorado")
    public String listarProfesor (Profesor profesor){
        List<Profesor> profesores = profesorService.getAllProfesores();
        profesor.addAttribute("profesores", profesores);
        return "index";

    }



    ///////////////POST(INSERTAR)
    @PostMapping("/alumando")
    public ResponseEntity<Alumno> insertarAlumn0(@RequestBody Alumno alumno){
        this.alumnoService.saveDriver(alumno);
        return  ResponseEntity.ok(alumno);


    }

    @PostMapping("/direccion")
    public ResponseEntity<Direccion> insertarDireccion(@RequestBody Direccion direccion){
        this.direccionService.saveDireccion(direccion);
        return  ResponseEntity.ok(direccion);


    } @PostMapping("/modulo")
    public ResponseEntity<Modulo> insertarModulo(@RequestBody Modulo modulo){
        this.moduloService.saveModule(modulo);
        return  ResponseEntity.ok(modulo);


    } @PostMapping("/profesor")
    public ResponseEntity<Profesor> insertarprofesor(@RequestBody Profesor profesor){
        this.profesorService.saveProfesor(profesor);
        return  ResponseEntity.ok(profesor);

    }

    //PUT
    @PutMapping("/alumnado")
    public ResponseEntity<Alumno> actualizarAlumno(@RequestBody Alumno alumno){

        this.alumnoService.saveDriver(alumno);
        return  ResponseEntity.ok(alumno);


    }
    @PutMapping("/direccion")
    public ResponseEntity<Direccion> actualizarDireccion(@RequestBody Direccion direccion){

        this.direccionService.saveDireccion(direccion);
        return  ResponseEntity.ok(direccion);


    }

    @PutMapping("/modulo")
    public ResponseEntity<Modulo> actualizarModulo(@RequestBody Modulo modulo){

        this.moduloService.saveModule(modulo);
        return  ResponseEntity.ok(modulo);


    }

    @PutMapping("/profesor")
    public ResponseEntity<Profesor> actualizarProfesor(@RequestBody Profesor profesor){

        this.profesorService.saveProfesor(profesor);
        return  ResponseEntity.ok(profesor);


    }

    //DELETE






}
