package com.sofka.LibretaPrueba.services;
import com.sofka.LibretaPrueba.domain.Contacto;
import com.sofka.LibretaPrueba.domain.Telefono;
import com.sofka.LibretaPrueba.repository.ContactoRepository;
import com.sofka.LibretaPrueba.repository.TelefonoRepository;
import com.sofka.LibretaPrueba.services.interfaces.ILibreta;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;
@Service

public class LibretaService {
    /**
     * Repositorio de Contacto
     */
    @Autowired
    private ContactoRepository contactoRepository;

    /**
     * Repositorio de Telefono
     */
    @Autowired
    private TelefonoRepository telefonoRepository;

    /**
     * Devuelve una lista de Contactos con todos contactos del sistema
     * @return
     */


    @Transactional(readOnly = true)
    public List<Contacto> getList() {
        return contactoRepository.findAll();
    }

    /**
     * Devuelve una lista de Contactos con todos contactos del sistema ordenados por el campo indicado ya sea asc
     * o desc
     *
     * @param field campo por el cual ordenar
     * @param order método de ordenado ASC o DESC
     * @return Lista de contactos
     *

     */

    @Transactional(readOnly = true)
    public List<Contacto> getList(String field, Sort.Direction order) {
        return contactoRepository.findAll(Sort.by(order, field));
    }

    /**
     * Busca un dato entre el nombre o los apellidos en un contacto
     *
     * @param dataToSearch Dato a buscar
     * @return Lista de contactos
     *

     */

    @Transactional(readOnly = true)
    public List<Contacto> searchContacto(String dataToSearch) {
        var contacto1 = contactoRepository.findByNombreOrApellidoStartingWith(dataToSearch);
        var contacto2 = contactoRepository.findByNombreOrApellidoContains(dataToSearch);
        var contacto3 = contactoRepository.findByNombreOrApellidoEndingWith(dataToSearch);
        var answer = new HashSet<Contacto>();
        answer.addAll(contacto1);
        answer.addAll(contacto2);
        answer.addAll(contacto3);
        return new ArrayList<>(answer);
    }

    /**
     * Crea un contacto en el sistema
     * @param contacto Objeto del contacto a crear
     * @return Objeto del contacto creado
     */

    @Transactional
    public  Contacto createContacto(Contacto contacto) {
        contacto.setCreatedAt(Instant.now());
        return contactoRepository.save(contacto);
    }

    /**
     * Crea un teléfono en el sistema a nombre de un contacto
     *
     * @param telefono Objeto del teléfono a crear
     * @return Objeto del teléfono creado
     */

    @Transactional
    public Telefono createTelefono(Telefono telefono) {
        telefono.setCreatedAt(Instant.now());
        return telefonoRepository.save(telefono);
    }

    /**
     * Actualiza una tupla completa de un contacto
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */


    @Transactional
    public Contacto updateContacto(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setUpdatedAt(Instant.now());
        return contactoRepository.save(contacto);
    }

    /**
     * Actualiza el nombre de un contacto
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     *

     */


    @Transactional
    public Contacto updateNombre(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setUpdatedAt(Instant.now());
        contactoRepository.updateNombre(id, contacto.getNombre());
        return contacto;
    }

    /**
     * Actualiza el apellido de un contacto
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     *

     */


    @Transactional
    public Contacto updateApellido(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setUpdatedAt(Instant.now());
        contactoRepository.updateApellido(id, contacto.getApellido());
        return contacto;
    }

    /**
     * Actualiza la tupla completa de un teléfono en el sistema
     *
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     *

     */


    @Transactional
    public Telefono updateTelefono(Integer id, Telefono telefono) {
        telefono.setId(id);
        telefono.setUpdatedAt(Instant.now());
        telefonoRepository.save(telefono);
        return telefono;
    }

    /**
     * Actualiza solamente el teléfono de un contacto a partir del ID de la tupla del teléfono
     *
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado

     */


    @Transactional
    public Telefono updateOnlyTelefono(Integer id, Telefono telefono) {
        telefono.setId(id);
        telefono.setUpdatedAt(Instant.now());
        telefonoRepository.updateTelefono(id, telefono.getTelefono());
        return telefono;
    }

    /**
     * Borra un contacto del sistema
     * @param id Identificación del contacto a borrar
     * @return Objeto del contacto borrado
     */


    @Transactional
    public Contacto deleteContacto(Integer id) {
        var contacto = contactoRepository.findById(id);
        if (contacto.isPresent()) {
            contactoRepository.delete(contacto.get());
            return contacto.get();
        } else {
            return null;
        }
    }

    /**
     * Borra un teléfono del sistema
     * @param id Identificación del teléfono a borrar
     * @return Objeto del teléfono borrado

     */

    @Transactional
    public Telefono deleteTelefono(Integer id) {
        var telefono = telefonoRepository.findById(id);
        if (telefono.isPresent()) {
            telefonoRepository.delete(telefono.get());
            return telefono.get();
        } else {
            return null;
        }
    }


}
